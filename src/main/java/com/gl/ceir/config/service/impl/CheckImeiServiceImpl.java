package com.gl.ceir.config.service.impl;

import com.gl.RuleEngineAdaptor;
import com.gl.ceir.config.exceptions.InternalServicesException;
import com.gl.ceir.config.model.app.CheckImeiRequest;
import com.gl.ceir.config.model.app.CheckImeiResponse;
import com.gl.ceir.config.model.app.Result;
import com.gl.ceir.config.model.constants.Alerts;
import com.gl.ceir.config.model.constants.StatusMessage;
import com.gl.ceir.config.repository.app.CheckImeiRequestRepository;
import com.gl.ceir.config.repository.app.CheckImeiResponseParamRepository;
import com.gl.ceir.config.repository.app.DbRepository;
import com.gl.ceir.config.repository.app.GsmaTacDetailsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Write a code :
 * get all values at the starting of api. like language sys_param checkImeiResponseParam etc.
 * create a function to check in database , if value of that tag is true:
 *  Call all values from db again. and once values are obtained. change sysParam_tag ->false
 * If  change sysParam_tag ->false. not to get values
 *
 * */

@Service
public class CheckImeiServiceImpl {

    private static final Logger logger = LogManager.getLogger(CheckImeiServiceImpl.class);

    @Value("${nullPointerException}")
    private String nullPointerException;

    @Value("${sqlException}")
    private String sQLException;

    @Value("${ruleResponseError}")
    private String ruleResponseError;

    @Value("${someWentWrongException}")
    private String someWentWrongException;

    @Value("${stolenRule}")
    private String stolenRule;

    @Value("${customRule}")
    private String customRule;

    @Autowired
    AlertServiceImpl alertServiceImpl;

    @Autowired
    CheckImeiResponseParamRepository chkImeiRespPrmRepo;

    @Autowired
    CheckImeiResponseParamRepoImpl cachedResponse;

    @Autowired
    GsmaTacDetailsRepository gsmaTacDetailsRepository;

    @Autowired
    CheckImeiRequestRepository checkImeiRequestRepository;

    @Autowired
    CheckImeiServiceSendSMS checkImeiServiceSendSMS;

    @Autowired
    DbRepository dbRepository;

    public CheckImeiResponse getImeiDetailsDevicesNew(CheckImeiRequest checkImeiRequest, long startTime) {
        try {
            LinkedHashMap<String, Boolean> rules = getResponseFromRuleEngine(checkImeiRequest);
            setComplianceValueByRule(checkImeiRequest, rules);
            var responseTag = "CheckImeiResponse_" + checkImeiRequest.getComplianceValue();  // optimise
            logger.info("Response Tag :: " + responseTag);
            var result = getResult(checkImeiRequest, rules, responseTag);
            checkImeiServiceSendSMS.sendSMSforUSSD_SMS(checkImeiRequest, responseTag, saveCheckImeiRequest(checkImeiRequest, startTime));
            return new CheckImeiResponse(String.valueOf(HttpStatus.OK.value()), StatusMessage.FOUND.getName(), checkImeiRequest.getLanguage(), result);
        } catch (Exception e) {
            logger.error(e + "in [" + Arrays.stream(e.getStackTrace()).filter(ste -> ste.getClassName().equals(CheckImeiServiceImpl.class.getName())).collect(Collectors.toList()).get(0) + "]");
            logger.error("Failed at " + e.getLocalizedMessage() + " ----- " + e.toString() + " ::::: " + e.getMessage() + " $$$$$$$$$$$ " + e);
            if (e instanceof NullPointerException) {
                saveCheckImeiFailDetails(checkImeiRequest, startTime, nullPointerException);
            } else if (e instanceof SQLException) {
                saveCheckImeiFailDetails(checkImeiRequest, startTime, sQLException);
            } else {
                saveCheckImeiFailDetails(checkImeiRequest, startTime, e.getLocalizedMessage());
            }  //  else if (e instanceof SQLGrammarException) { saveCheckImeiFailDetails(checkImeiRequest, startTime, e.getLocalizedMessage());            }
            alertServiceImpl.raiseAnAlert(Alerts.ALERT_1103.getName(), 0);
            logger.error("Failed at " + e.getLocalizedMessage());
            //   new Thread(() -> saveCheckImeiRequest(checkImeiRequest, startTime)).start();//saveCheckImeiRequest(checkImeiRequest, startTime);
            throw new InternalServicesException(checkImeiRequest.getLanguage(), globalErrorMsgs(checkImeiRequest.getLanguage()));
        }
    }

    //MDR //NATIONAL_WHITELISTS  // NWL_VALIDITYFLAG //   // CUSTOM_LOCAL_MANUFACTURER // TRC // if not present make pass
    private void setComplianceValueByRule(CheckImeiRequest checkImeiRequest, LinkedHashMap<String, Boolean> r) {
        int complianceValue = 0;
        boolean isWhitelisted = r.containsKey("NATIONAL_WHITELISTS") ? r.get("NATIONAL_WHITELISTS") : true;
        boolean isNWLValid = r.containsKey("NWL_VALIDITYFLAG") ? r.get("NWL_VALIDITYFLAG") : true;
        boolean isCustomManufacturer = r.containsKey("CUSTOM_LOCAL_MANUFACTURER") ? r.get("CUSTOM_LOCAL_MANUFACTURER") : true;
        boolean isMDR = r.containsKey("MDR") ? r.get("MDR") : true;
        if (isWhitelisted) {
            complianceValue = isNWLValid ? (isCustomManufacturer ? 1 : 3) : 2;
        } else {
            complianceValue = isMDR ? (isCustomManufacturer ? 4 : 5) : 6;
        }
        checkImeiRequest.setComplianceValue(complianceValue);
    }


    private LinkedHashMap<String, Boolean> getResponseFromRuleEngine(CheckImeiRequest checkImeiRequest) {
        try (Connection conn = dbRepository.getConnection()) {
        var deviceInfo = Map.of("appdbName", "app", "auddbName", "aud", "repdbName", "rep", "edrappdbName", "app_edr",
                "userType", "default",
                "imei", checkImeiRequest.getImei(), "msisdn", checkImeiRequest.getMsisdn() == null ? "" : checkImeiRequest.getMsisdn(), "imsi", checkImeiRequest.getImsi() == null ? "" : checkImeiRequest.getImsi(), "feature", "CheckImei", "operator", checkImeiRequest.getOperator() == null ? "" : checkImeiRequest.getOperator());
        var startTime = System.currentTimeMillis();
        LinkedHashMap<String, Boolean> rules = RuleEngineAdaptor.startAdaptor(conn, deviceInfo);
        logger.info("Rule response  {}", rules);
        logger.info( ":RuleEngine Time Taken is  :->" + (System.currentTimeMillis() - startTime) +" *** connection :-"+ conn);
            return rules;
        } catch (Exception e) {
            logger.error("Not able to get rules {}",e.getMessage());
           return null;
        }
    }

    private Result getResult(CheckImeiRequest checkImeiRequest, LinkedHashMap<String, Boolean> rules, String status) {
        String remarksValue = getRemarkString(checkImeiRequest, rules);
        LinkedHashMap mappedDeviceDetails = null;
        var isValidImei = false;
        try {
            if (checkImeiRequest.getComplianceValue() == 1 || checkImeiRequest.getComplianceValue() == 4) { // means validity flag 1 ********
                isValidImei = true;
                logger.info("Going For MDR details ");
                isValidImei = true;
                var gsmaTacDetails = gsmaTacDetailsRepository.getBydeviceId(checkImeiRequest.getImei().substring(0, 8));
                if (gsmaTacDetails == null)
                    logger.info("No MDR detail Found ");
                else
                    mappedDeviceDetails = deviceDetailsNew(gsmaTacDetails.getBrand_name(), gsmaTacDetails.getModel_name(), gsmaTacDetails.getDevice_type(), gsmaTacDetails.getManufacturer(), gsmaTacDetails.getMarketing_name(), checkImeiRequest.getLanguage());
            }
        } catch (Exception e) {
            logger.warn(" **** MDR/NWL Rule might not initialised .");
        }
        var message = chkImeiRespPrmRepo.getByTagAndLanguage(checkImeiRequest.getChannel().equalsIgnoreCase("ussd") ? status + "_MsgForUssd" : checkImeiRequest.getChannel().equalsIgnoreCase("sms") ? status + "_MsgForSms" : status + "_Msg", checkImeiRequest.getLanguage()).getValue().replace("<imei>", checkImeiRequest.getImei());

        var compStatus = chkImeiRespPrmRepo.getByTagAndLanguage(checkImeiRequest.getChannel().equalsIgnoreCase("ussd") ? status + "_ComplianceForUssd" : checkImeiRequest.getChannel().equalsIgnoreCase("sms") ? status + "_ComplianceForSms" : status + "_Compliance", checkImeiRequest.getLanguage());

        var complianceStatus = compStatus == null ? null : compStatus.getValue().replace("<imei>", checkImeiRequest.getImei());
        logger.info("Compliance Status:::->" + complianceStatus + ", MDR Response  :->" + mappedDeviceDetails);
        var symbolTag = status + "_SymbolColor";
        var symbolResponse = chkImeiRespPrmRepo.getByTagAndFeatureName(symbolTag, "CheckImei");    //  message, deviceDetails == null ? null :
        logger.info("SymbolColor Response :::->" + symbolResponse.toString());

        var symbolColor = symbolResponse.getValue();


        checkImeiRequest.setImeiProcessStatus(isValidImei == true ? "Valid" : "Invalid");
        checkImeiRequest.setComplianceStatus(complianceStatus);
        checkImeiRequest.setSymbol_color(symbolColor);
        checkImeiRequest.setRequestProcessStatus("Success");
        var result = new Result(isValidImei, symbolColor, complianceStatus, message + " " + remarksValue, mappedDeviceDetails == null ? null : mappedDeviceDetails);
        return result;
    }

    private String getRemarkString(CheckImeiRequest checkImeiRequest, LinkedHashMap<String, Boolean> r) {
        String remarksValue = "Remarks:";
        int val = 0;
        boolean IMEI_PAIRING = r.getOrDefault("IMEI_PAIRING", false);
        boolean STOLEN = r.getOrDefault(stolenRule.trim(), false);
        boolean DUPLICATE_DEVICE = r.getOrDefault("DUPLICATE_DEVICE", false);
        boolean BLACKLIST = r.getOrDefault("EXIST_IN_BLACKLIST_DB", false);

        logger.info("Remarks Check IMEI_PAIRING: {} , Stolen : {} ,DUPLICATE_DEVICE : {} ,BLACKLIST {} ", IMEI_PAIRING, STOLEN, DUPLICATE_DEVICE, BLACKLIST);
        if (IMEI_PAIRING) {
            if (DUPLICATE_DEVICE) {
                val = STOLEN ? 1 : (BLACKLIST ? 2 : 3);
            } else {
                val = STOLEN ? 4 : (BLACKLIST ? 5 : 6);
            }
        } else {
            if (DUPLICATE_DEVICE) {
                val = STOLEN ? 7 : (BLACKLIST ? 8 : 9);
            } else {
                val = STOLEN ? 10 : (BLACKLIST ? 11 : 12);
            }
        }
        var remarkTag = "CheckImeiRemark_" + val;
        logger.info("Remarks tag {} ", remarkTag);
        var v = chkImeiRespPrmRepo.getByTagAndLanguage(checkImeiRequest.getChannel().equalsIgnoreCase("ussd")
                ? remarkTag + "ForUssd" : checkImeiRequest.getChannel().equalsIgnoreCase("sms") ?
                remarkTag + "ForSms" : remarkTag, checkImeiRequest.getLanguage());
        remarksValue = (v == null || v.getValue().isEmpty())
                ? " " : v.getValue().replace("<imei>", checkImeiRequest.getImei());
        remarksValue = remarksValue.substring(0, remarksValue.length() - 1);
        if (remarksValue.equalsIgnoreCase("Remarks")) {
            remarksValue = "";
        }
        return remarksValue;
    }
    public void saveCheckImeiFailDetails(CheckImeiRequest checkImeiRequest, long startTime, String desc) {
        checkImeiRequest.setRequestProcessStatus("Fail");
        checkImeiRequest.setFail_process_description(desc);
        // alertServiceImpl.raiseAnAlert(Alerts.ALERT_1110.getName(), desc, "Check Imei ", 0);
        logger.info(" CHECK_IMEI :Start Time = " + startTime + "; End Time  = " + System.currentTimeMillis() + "  !!! Request = " + checkImeiRequest.toString() + ", Response =" + desc);
        new Thread(() -> saveCheckImeiRequest(checkImeiRequest, startTime)).start();//  saveCheckImeiRequest(checkImeiRequest, startTime);
    }

    public CheckImeiRequest saveCheckImeiRequest(CheckImeiRequest checkImeiRequest, long startTime) {
        try {
            checkImeiRequest.setCheckProcessTime(String.valueOf(System.currentTimeMillis() - startTime));
            var response = checkImeiRequestRepository.save(checkImeiRequest);
            return response;
        } catch (Exception e) {
            alertServiceImpl.raiseAnAlert(Alerts.ALERT_1110.getName(), 0);
            throw new InternalServicesException(checkImeiRequest.getLanguage(), globalErrorMsgs(checkImeiRequest.getLanguage()));
        }
    }

    public String globalErrorMsgs(String language) {
        return chkImeiRespPrmRepo.getByTagAndLanguage("CheckImeiErrorMessage", language).getValue();
    }

    public String checkImeiServiceDownMsg(String language) {
        return chkImeiRespPrmRepo.getByTagAndLanguage("CheckImeiServiceDownMessage", language).getValue();
    }

    private LinkedHashMap deviceDetailsNew(String brand_name, String model_name, String device_type, String manufacturer, String marketing_name, String lang) {
        LinkedHashMap<String, String> item = new LinkedHashMap();
        item.put(chkImeiRespPrmRepo.getByTagAndLanguage("brandName", lang).getValue(), brand_name);
        item.put(chkImeiRespPrmRepo.getByTagAndLanguage("modelName", lang).getValue(), model_name);
        item.put(chkImeiRespPrmRepo.getByTagAndLanguage("manufacturer", lang).getValue(), manufacturer);
        item.put(chkImeiRespPrmRepo.getByTagAndLanguage("marketingName", lang).getValue(), marketing_name);
        item.put(chkImeiRespPrmRepo.getByTagAndLanguage("deviceType", lang).getValue(), device_type);
        return item;
    }

}


//
//        if (r.get("trc")) {
//        if (r.get("custom")) {
//        if (r.get("NATIONAL_WHITELISTS")) {
//        if (r.get("NWL_VALIDITYFLAG")) {
//complianceValue = 1;
//        } else {
//complianceValue = 2;
//        }
//        } else {
//        if (r.get("MDR")) {
//complianceValue = 3;
//        } else {
//complianceValue = 4;
//        }
//        }
//        } else {
//        if (r.get("NATIONAL_WHITELISTS")) {
//        if (r.get("NWL_VALIDITYFLAG")) {
//complianceValue = 5;
//        } else {
//complianceValue = 6;
//        }
//        } else {
//        if (r.get("MDR")) {
//complianceValue = 7;
//        } else {
//complianceValue = 8;
//        }
//        }
//        }
//
//        } else {
//        if (r.get("custom")) {
//        if (r.get("NATIONAL_WHITELISTS")) {
//        if (r.get("NWL_VALIDITYFLAG")) {
//complianceValue = 9;
//        } else {
//complianceValue = 10;
//        }
//        } else {
//        if (r.get("MDR")) {
//complianceValue = 11;
//        } else {
//complianceValue = 12;
//        }
//        }
//        } else {
//        if (r.get("NATIONAL_WHITELISTS")) {
//        if (r.get("NWL_VALIDITYFLAG")) {
//complianceValue = 13;
//        } else {
//complianceValue = 14;
//        }
//        } else {
//        if (r.get("MDR")) {
//complianceValue = 15;
//        } else {
//complianceValue = 16;
//        }
//        }
//        }
//        }
//
//
//        if (r.get("custom")) {
//complianceValue = r.get("NATIONAL_WHITELISTS") ? (r.get("NWL_VALIDITYFLAG") ? 1 : 2) : (r.get("MDR") ? 3 : 4);
//        } else {
//complianceValue = r.get("NATIONAL_WHITELISTS") ? (r.get("NWL_VALIDITYFLAG") ? 5 : 6) : (r.get("MDR") ? 7 : 8);
//        }
//
//
//        if (!r.get("MDR")) {
//complianceValue = r.get("NWL") ? 9 : 10;
//        } else if (!r.get("NWL")) {
//        if (r.get("CUSTOM_CHK")) {
//complianceValue = r.get("TRC") ? 5 : 6;
//        } else {
//complianceValue = r.get("TRC") ? 7 : 8;
//        }
//        } else {
//        if (r.containsKey("CUSTOM_CHK") && r.get("CUSTOM_CHK")) {
//complianceValue = r.get("TRC") ? 1 : 2;
//        } else {
//complianceValue = r.get("TRC") ? 3 : 4;
//        }
//        }


//        if (r.get("NATIONAL_WHITELISTS")) {
//            if (r.get("NWL_VALIDITYFLAG")) {
//                complianceValue = 1;
//            } else {
//                complianceValue = 2;
//            }
//        } else {
//            if (r.get("MDR")) {
//                complianceValue = 3;
//            } else {
//                complianceValue = 4;
//            }
//        }


//        if (r.get("NATIONAL_WHITELISTS")) {
//        if (r.get("NWL_VALIDITYFLAG")) {
//        if (r.get("CUSTOM_LOCAL_MANUFACTURER")) {
//complianceValue = 1;
//        } else {
//complianceValue = 3;
//        }
//        } else {
//complianceValue = 2;
//        }
//        } else {
//        if (r.get("MDR")) {
//        if (r.get("CUSTOM_LOCAL_MANUFACTURER")) {
//complianceValue = 4;
//        } else {
//complianceValue = 5;
//        }
//        } else {
//complianceValue = 6;
//        }
//        }
//
//
//complianceValue = r.get("NATIONAL_WHITELISTS") ? (r.get("NWL_VALIDITYFLAG") ? 1 : 2) : (r.get("MDR") ? 3 : 4);
//
//        if (r.containsKey("CUSTOM_LOCAL_MANUFACTURER") && !r.get("CUSTOM_LOCAL_MANUFACTURER")) {
//complianceValue += 4;
//        }
//        if (r.containsKey("TRC") && !r.get("TRC")) {
//complianceValue += 8;
//        }