package com.gl.ceir.config.service.impl;

import com.gl.ceir.config.exceptions.InternalServicesException;
import com.gl.ceir.config.model.app.AppDeviceDetailsDb;
import com.gl.ceir.config.model.app.DeviceidBaseUrlDb;
import com.gl.ceir.config.model.constants.Alerts;
import com.gl.ceir.config.repository.app.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class CheckImeiOtherApiImpl {

    private static final Logger logger = LogManager.getLogger(CheckImeiOtherApiImpl.class);

    @Value("${local-ip}")
    public String localIp;

    @Value("${nullPointerException}")
    private String nullPointerException;

    @Value("${sqlException}")
    private String sQLException;

    @Value("${ruleResponseError}")
    private String ruleResponseError;

    @Value("${someWentWrongException}")
    private String someWentWrongException;

    @Autowired
    AlertServiceImpl alertServiceImpl;

    @Autowired
    SystemConfigurationDbRepository systemConfigurationDbRepositry;

    @Autowired
    CheckImeiResponseParamRepository checkImeiResponseParamRepository;

    @Autowired
    GsmaTacDetailsRepository gsmaTacDetailsRepository;

    @Autowired
    CheckImeiRequestRepository checkImeiRequestRepository;

    @Autowired
    AppDeviceDetailsRepository appDeviceDetailsRepository;

    @Autowired
    LanguageLabelDbRepository languageLabelDbRepository;


    @Autowired
    CheckImeiPreInitRepository checkImeiPreInitRepository;

    @Autowired
    NationalWhitelistRepository nationalWhitelistRepository;

    @Autowired
    CheckImeiServiceSendSMS checkImeiServiceSendSMS;


    public void saveDeviceDetails(AppDeviceDetailsDb appDeviceDetailsDb) {
        try {
            appDeviceDetailsRepository.saveDetails(
                    appDeviceDetailsDb.getOsType(),
                    appDeviceDetailsDb.getDeviceId(),
                    appDeviceDetailsDb.getDeviceDetails().toJSONString(),
                    appDeviceDetailsDb.getLanguageType());
        } catch (Exception e) {
            alertServiceImpl.raiseAnAlert(Alerts.ALERT_1104.getName(), 0);
            throw new InternalServicesException(this.getClass().getName(), "internal server error");
        }
    }


    public DeviceidBaseUrlDb getPreinitApi(String deviceId) {
        try {
            var response = checkImeiPreInitRepository.getByDeviceId(deviceId);
            if (response == null) {
                response = checkImeiPreInitRepository.getByDeviceId("default_setup");
            }
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage() + " : " + e.getLocalizedMessage());
            alertServiceImpl.raiseAnAlert(Alerts.ALERT_1106.getName(), 0);
            throw new InternalServicesException(this.getClass().getName(), e.getLocalizedMessage());
        }
    }

}


//      private JSONObject deviceDetails(String brand_name, String modelName, String device_type, String manufacturer, String marketing_name, String lang) {
//        JSONObject item = new JSONObject();
//        try {
//            Field map = item.getClass().getDeclaredField("map");
//            map.setAccessible(true);//because the field is private final...
//            map.set(item, new LinkedHashMap<>());
//            map.setAccessible(false);//return flag
//        } catch (Exception e) {
//            logger.error("Json serial at " + e.getLocalizedMessage() + " ie " + e.getMessage());
//        }
//        item.put(lang.equals("en") ? "Brand Name" : languageLabelDbRepository.getKhmerNameFromLabel("brandName"), brand_name);
//        item.put(lang.equals("en") ? "Model Name" : languageLabelDbRepository.getKhmerNameFromLabel("modelName"), modelName);
//        item.put(lang.equals("en") ? "Manufacturer" : languageLabelDbRepository.getKhmerNameFromLabel("manufacturer"), manufacturer);
//        item.put(lang.equals("en") ? "Marketing Name" : languageLabelDbRepository.getKhmerNameFromLabel("marketingName"), marketing_name);
//        item.put(lang.equals("en") ? "Device Type" : languageLabelDbRepository.getKhmerNameFromLabel("deviceType"), device_type);
//        return item;
//    }
//    private String getRuleResponse(CheckImeiRequest checkImeiRequest, long startTime) {
//        var ruleResponseStatus
//                = checkImeiRequest.getChannel().equalsIgnoreCase("ussd") || checkImeiRequest.getChannel().equalsIgnoreCase("sms")
//                ? "CheckImeiPassForUssd" : "CheckImeiPass";
//        try (Connection conn = connectionConfiguration.getConnection()) {
//            List<RuleEngineMapping> ruleList = checkImeiRepository.getByFeatureAndUserTypeOrderByRuleOrder("CheckImei", "default");
//            for (RuleEngineMapping rules : ruleList) {
//                Rule rule = new Rule(rules.getName(), rules.getOutput(), rules.getRuleMessage());
//                String[] my_arr = {
//                    rule.rule_name, "1", "NONCDR",
//                    checkImeiRequest.getImei(),
//                    "", "", "", "", "", "IMEI", "", " ", " ", ""};
//                String expOutput = RuleEngineApplication.startRuleEngine(my_arr, conn, null);
//                if (!rule.output.equalsIgnoreCase(expOutput)) {
//                    ruleResponseStatus = rule.rule_name;
//                    break;
//                }
//            }
//            conn.close();
//            return ruleResponseStatus;
//        } catch (SQLException e) {
//            logger.error(e.getMessage() + " : " + e.getLocalizedMessage());
//            saveCheckImeiFailDetails(checkImeiRequest, startTime, ruleResponseError);
//            throw new InternalServicesException(checkImeiRequest.getLanguage(), globalErrorMsgs(checkImeiRequest.getLanguage()));
//        }
//    }

/*  *******************************  */

/*  *******************************  */

/*  *******************************  */


//    public CheckImeiResponse getImeiDetailsDevices(CheckImeiRequest checkImeiRequest, long startTime) {
//        //  JSONObject deviceDetails = null;
//        String status = null;
//        int complianceValue = 0;
//        var isValidImei = false;
//        GsmaTacDetails gsmaTacDetails = null;
//        LinkedHashMap mappedDeviceDetails = null;
//        try {
//            //   var ruleResponseStatus = getRuleResponse(checkImeiRequest, startTime);
//            boolean nationalWhiteListResponse = getnationalWhiteListResponse(checkImeiRequest.getImei().length() > 14 ? checkImeiRequest.getImei().substring(0, 14) : checkImeiRequest.getImei());
//            logger.info("Is imei present in natinoal whitelist  :" + nationalWhiteListResponse);
//            //   if (ruleResponseStatus.contains("CheckImeiPass")) {
//            gsmaTacDetails = gsmaTacDetailsRepository.getBydeviceId(checkImeiRequest.getImei().substring(0, 8));
//            if (gsmaTacDetails != null) {
//                isValidImei = true;
//                mappedDeviceDetails = deviceDetailsNew(gsmaTacDetails.getBrand_name(), gsmaTacDetails.getModel_name(), gsmaTacDetails.getDevice_type(), gsmaTacDetails.getManufacturer(), gsmaTacDetails.getMarketing_name(), checkImeiRequest.getLanguage());
//                if (gsmaTacDetails.getDevice_type().equalsIgnoreCase("Smartphone") || gsmaTacDetails.getDevice_type().contains("phone")) {
//                    if (nationalWhiteListResponse) {
//                        status = "WhiteListedSmartphone";
//                        complianceValue = 1;
//                    } else {
//                        status = "NonWhiteListedSmartphone";
//                        complianceValue = 2;
//                    }
//                } else {
//                    if (nationalWhiteListResponse) {
//                        status = "WhiteListedOtherDevice";
//                        complianceValue = 3;
//                    } else {
//                        status = "NonWhiteListedOtherDevice";
//                        complianceValue = 4;
//                    }
//                }
//            } else {
//                if (nationalWhiteListResponse) {
//                    status = "WhiteListedNoDevice";
//                    complianceValue = 5;
//                } else {
//                    status = "NonWhiteListedNoDevice";
//                    complianceValue = 6;
//                }
//            }
//            logger.info("Status is  :->" + status + ", For Channel -" + checkImeiRequest.getChannel() + ", For Language -" + checkImeiRequest.getLanguage() + "  isValidImei:-> " + isValidImei);
//            var message = checkImeiResponseParamRepository.getByTagAndTypeAndFeatureName(
//                            checkImeiRequest.getChannel().equalsIgnoreCase("ussd") ? status + "ForUssd" : checkImeiRequest.getChannel().equalsIgnoreCase("sms")
//                                    ? status + "ForSms" : status,
//                            checkImeiRequest.getLanguage().contains("kh") ? 2 : 1,
//                            "CheckImei")
//                    .getValue()
//                    .replace("<imei>", checkImeiRequest.getImei());
//            logger.info("Semi Response  message::  :" + message);
//            var compStatus = checkImeiResponseParamRepository.getByTagAndTypeAndFeatureName(
//                    checkImeiRequest.getChannel().equalsIgnoreCase("ussd") ? status + "ComplianceForUssd" : checkImeiRequest.getChannel().equalsIgnoreCase("sms") ? status + "ComplianceForSms" : status + "Compliance",
//                    checkImeiRequest.getLanguage().contains("kh") ? 2 : 1, "CheckImei");
//            logger.info("Comp Status:::::::  :" + compStatus);
//            var complianceStatus = compStatus == null ? null : compStatus.getValue().replace("<imei>", checkImeiRequest.getImei());
//
//            logger.info("Compliance Status::  :" + complianceStatus + ",Response via  mobileDeviceRepository :" + mappedDeviceDetails);
//            var symbol_color = systemConfigurationDbRepositry.getByTag(status + "SymbolColor").getValue();    //  message, deviceDetails == null ? null :
//            var result = new Result(isValidImei, symbol_color, complianceStatus, message, mappedDeviceDetails == null ? null : mappedDeviceDetails);
//
//            checkImeiRequest.setRequestProcessStatus("Success");
//            checkImeiRequest.setImeiProcessStatus(isValidImei == true ? "Valid" : "Invalid");
//            checkImeiRequest.setComplianceStatus(complianceStatus);
//            checkImeiRequest.setSymbol_color(symbol_color);
//            checkImeiRequest.setComplianceValue(complianceValue);
//            var response = saveCheckImeiRequest(checkImeiRequest, startTime);
//            if (checkImeiRequest.getChannel().equalsIgnoreCase("ussd") && systemConfigurationDbRepositry.getByTag("send_sms_flag").getValue().equalsIgnoreCase("true")) {
//                logger.info("Going for ussd and send_sms_flag true  ");
//                var smsMessage = checkImeiResponseParamRepository.getByTagAndTypeAndFeatureName(
//                                status + "ForSms",
//                                checkImeiRequest.getLanguage().contains("kh") ? 2 : 1,
//                                "CheckImei")
//                        .getValue()
//                        .replace("<imei>", checkImeiRequest.getImei());
//                //  createPostRequestForNotification(checkImeiRequest, smsMessage, response.getId().intValue());
//            }
//
//            return new CheckImeiResponse(String.valueOf(HttpStatus.OK.value()), StatusMessage.FOUND.getName(), checkImeiRequest.getLanguage(), result);
//        } catch (Exception e) {
//            logger.error("Failed at " + e.getLocalizedMessage() + " ----- " + e.toString() + " ::::: " + e.getMessage() + " $$$$$$$$$$$ " + e);
//            if (e instanceof NullPointerException) {
//                saveCheckImeiFailDetails(checkImeiRequest, startTime, nullPointerException);
//            } else if (e instanceof SQLException) {
//                saveCheckImeiFailDetails(checkImeiRequest, startTime, sQLException);
//            } //  else if (e instanceof SQLGrammarException) { saveCheckImeiFailDetails(checkImeiRequest, startTime, e.getLocalizedMessage());            }
//            else {
//                saveCheckImeiFailDetails(checkImeiRequest, startTime, e.getLocalizedMessage());
//            }
//            alertServiceImpl.raiseAnAlert(Alerts.ALERT_1103.getName(), 0);
//            logger.error("Failed at " + e.getLocalizedMessage());
//            saveCheckImeiRequest(checkImeiRequest, startTime);
//            throw new InternalServicesException(checkImeiRequest.getLanguage(), globalErrorMsgs(checkImeiRequest.getLanguage()));
//        }
//    }


