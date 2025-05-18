package com.gl.ceir.config.service.impl;

import com.gl.RuleEngineAdaptor;
import com.gl.ceir.config.exceptions.InternalServicesException;
import com.gl.ceir.config.model.app.*;
import com.gl.ceir.config.repository.app.*;
import com.gl.custom.CustomCheck;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.*;
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
// @Transactional to run with deleteByid -uncomment
public class CustomImeiRegisterServiceImpl {

    private static final Logger logger = LogManager.getLogger(CustomImeiRegisterServiceImpl.class);


    @Value("${customSource}")
    private String customSource;

    @Value("${gdFailMessage}")
    private String gdFailMessage;

    @Value("${failMessage}")
    private String failMessage;

    @Value("${passMessage}")
    private String passMessage;

    @Value("${sourceServerName}")
    private String sourceServerName;

    @Value("${destServerName}")
    private String destServerName;

    @Value("${serverName}")
    private String serverName;

    @Value("${imeiInvalid_Msg}")
    private String imeiInvalid_Msg;

    @Value("${mandatoryParameterMissing}")
    private String mandatoryParameterMissing;

    @Autowired
    CheckImeiServiceSendSMS checkImeiServiceSendSMS;


    @Autowired
    DbRepository dbRepository;

    @Autowired
    BlackListHisRepo blackListHisRepo;
    @Autowired
    BlackListRepository blackListRepository;
    @Autowired
    ExceptionListRepo exceptionListRepo;
    @Autowired
    ExceptionListHisRepo exceptionListHisRepo;
    @Autowired
    ImeiPairDetailRepo imeiPairDetailRepo;
    @Autowired
    ImeiPairDetailHisRepo imeiPairDetailHisRepo;
    @Autowired
    GdceDataRepository gdceDataRepository;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    GdceRegisterImeiReqRepo gdceRegisterImeiReqRepo;

    @Autowired
    SystemParamServiceImpl systemParamServiceImpl;

    @Autowired
    CustomImeiCheckImeiServiceImpl customImeiCheckImeiServiceImpl;

    public List<ResponseArray> registerService(List<GdceData> gdceData, GdceRegisterImeiReq obj) {
        int failCount = 0;
        int passCount = 0;
        List<ResponseArray> responseArray = new LinkedList<>();
        List<PrintReponse> a = new LinkedList<>();
        try {
            for (GdceData gdData : gdceData) {
                gdData.setRequest_id(obj.getRequestId());
                logger.info("Starting Registering for" + gdceData);
                if (StringUtils.isBlank(gdData.getImei()) ||
                        StringUtils.isBlank(gdData.getGoods_description()) ||
                        StringUtils.isBlank(gdData.getCustoms_duty_tax())
                        || StringUtils.isBlank(gdData.getDevice_type()) ||
                        StringUtils.isBlank(gdData.getBrand()) ||
                        StringUtils.isBlank(gdData.getModel()) ||
                        gdData.getSim() == 0) {
                    logger.info("Mandatory param missing for " + gdData);
                    responseArray.add(new ResponseArray(gdData.getImei(), gdData.getSerial_number(), 202, failMessage));
                    a.add(new PrintReponse(gdData.getImei(), gdData.getSerial_number(), 202, failMessage, mandatoryParameterMissing));
                    failCount++;
                } else if (gdData.getImei().length() < 14 || gdData.getImei().length() > 20 ||
                        !gdData.getImei().matches("^[ 0-9 ]+$")) {
                    logger.info("imei not valid : " + gdData.getImei());
                    responseArray.add(new ResponseArray(gdData.getImei(), gdData.getSerial_number(), 202, failMessage));
                    a.add(new PrintReponse(gdData.getImei(), gdData.getSerial_number(), 202, failMessage, imeiInvalid_Msg));
                    failCount++;
                } else if (systemParamServiceImpl.getValueByTag("strict_check_imei_validation").equalsIgnoreCase("OFF")) {
                    logger.info("Strict Validation is OFF ");
                    if (checkImeiInGdceData(gdData)) { //  present in db
                        failCount++;
                        responseArray.add(new ResponseArray(gdData.getImei(), gdData.getSerial_number(), 201, gdFailMessage));
                        a.add(new PrintReponse(gdData.getImei(), gdData.getSerial_number(), 201, gdFailMessage, applicationContext.getEnvironment().getProperty("CUSTOM_GDCE_Msg")));
                    } else {
                        if (insertInGdceData(gdData)) {
                            passCount++;
                            responseArray.add(new ResponseArray(gdData.getActual_imei(), gdData.getSerial_number(), 200, passMessage));
                            a.add(new PrintReponse(gdData.getActual_imei(), gdData.getSerial_number(), 200, passMessage, "Pass"));
                        } else {
                            failCount++;
                            responseArray.add(new ResponseArray(gdData.getImei(), gdData.getSerial_number(), 202, failMessage));
                            a.add(new PrintReponse(gdData.getImei(), gdData.getSerial_number(), 202, failMessage, "Fail to insert in gdce_data"));
                        }
                    }
                } else {
                    LinkedHashMap<String, Boolean> rules = null;
                    var deviceInfo = Map.of("appdbName", "app", "auddbName", "aud", "repdbName", "rep", "edrappdbName", "app_edr", "userType", "default", "imei", gdData.getImei(), "feature", "CustomRegisterImei", "source", customSource);
                    try (var conn = dbRepository.getConnection()) {
                        rules = RuleEngineAdaptor.startAdaptor(conn, deviceInfo);
                    }
                    logger.info("Rules Return " + rules);
                    var lastRule = rules.entrySet().stream().map(Map.Entry::getKey).reduce((first, second) -> second).orElse(null);  // optimse
                    var response = rules.entrySet().stream().map(Map.Entry::getValue).reduce((first, second) -> second).orElse(null); // opt
                    logger.info("Finale " + lastRule + "  rule-> " + response);
                    if (!response) {  // if (userType.equals("default") && !response) {
                        if (rules.containsKey("CUSTOM_GDCE")) {
                            responseArray.add(new ResponseArray(gdData.getImei(), gdData.getSerial_number(), 201, gdFailMessage));
                            a.add(new PrintReponse(gdData.getImei(), gdData.getSerial_number(), 201, gdFailMessage, applicationContext.getEnvironment().getProperty(lastRule+ "_Msg")));
                        } else {
                            responseArray.add(new ResponseArray(gdData.getImei(), gdData.getSerial_number(), 202, failMessage));
                            a.add(new PrintReponse(gdData.getImei(), gdData.getSerial_number(), 202, failMessage,  applicationContext.getEnvironment().getProperty(lastRule+ "_Msg")));
                        }
                    } else {
                        logger.info("Request Pass for  " + gdData.getImei());
                        addInImeiPairDetail(gdData);
                        addInExceptionList(gdData);
                        addInBlackList(gdData);
                        if (insertInGdceData(gdData)) {
                            passCount++;
                            responseArray.add(new ResponseArray(gdData.getActual_imei(), gdData.getSerial_number(), 200, passMessage));
                            a.add(new PrintReponse(gdData.getActual_imei(), gdData.getSerial_number(), 200, passMessage, "Pass"));
                        } else {
                            failCount++;
                            responseArray.add(new ResponseArray(gdData.getImei(), gdData.getSerial_number(), 202, failMessage));
                            a.add(new PrintReponse(gdData.getImei(), gdData.getSerial_number(), 202, failMessage, "Fail to insert in gdce_data"));
                        }
                    }
                }
            }
            updateGdceRegister(passCount, failCount, obj);
        } catch (Exception e) {
            createFile(customImeiCheckImeiServiceImpl.globalErrorMsgs("en"), "registerIMEI", "response", obj.getRequestId());
            logger.error(e + "in [" + Arrays.stream(e.getStackTrace()).filter(ste -> ste.getClassName().equals(CustomImeiRegisterServiceImpl.class.getName())).collect(Collectors.toList()).get(0) + "]");
            throw new InternalServicesException("en", customImeiCheckImeiServiceImpl.globalErrorMsgs("en"));
        }
        createFile(Arrays.toString(a.toArray()), "registerIMEI", "response", obj.getRequestId());
        return responseArray;
    }

    private void updateGdceRegister(int passCount, int failCount, GdceRegisterImeiReq obj) {
        obj.setRemark("200");
        obj.setHttpStatusCode(200);
        obj.setStatus("DONE");
        obj.setFailCount(failCount);
        obj.setSuccessCount(passCount);
        gdceRegisterImeiReqRepo.save(obj);
    }

    @Transactional
    private void addInImeiPairDetail(GdceData gdData) {
        try {
            List<ImeiPairDetail> pairs = imeiPairDetailRepo.getByImei(gdData.getImei());
            for (ImeiPairDetail p : pairs) {
                imeiPairDetailHisRepo.save(new ImeiPairDetailHis(p.getAllowedDays(), p.getImei(), p.getImsi(), p.getMsisdn(), p.getFilename(), p.getGsmaStatus(), p.getPairMode(), p.getOperator(), "2", p.getPairingDate(), p.getRecordTime(), p.getExpiryDate(), "GDCE_TAX_PAID"));
            }
            imeiPairDetailRepo.deleteByImei(gdData.getImei());
        } catch (Exception e) {
            logger.warn("Not able to insert/update in imei_pair/his, Exception :{}", e.getLocalizedMessage());
        }
    }

    @Transactional
    private void addInExceptionList(GdceData gdData) {
        try {
            for (ExceptionList e : exceptionListRepo.getByImei(gdData.getImei())) {
                exceptionListHisRepo.save(new ExceptionListHist(e.getComplaintType(), e.getImei(), e.getModeType(), e.getRequestType(), e.getTxnId(), e.getUserId(), e.getUserType(), e.getOperatorId(), e.getOperatorName(), e.getActualImei(), e.getTac(), e.getRemarks(), e.getImsi(), e.getMsisdn(), e.getSource(), e.getExpiryDate(), "GDCE_TAX_PAID"));
            }
            exceptionListRepo.deleteByImei(gdData.getImei());
        } catch (Exception e) {
            logger.warn("Not able to insert/update in exception/his, Exception :{}", e.getLocalizedMessage());
        }
    }


    @Transactional
    private void addInBlackList(GdceData gdData) {
        try {
            for (BlackList b : blackListRepository.getByImei(gdData.getImei())) {
                blackListHisRepo.save(new BlackListHis(b.getActualImei(), b.getComplaintType(), b.getImei(), b.getImsi(), b.getModeType(), b.getMsisdn(), b.getOperatorId(), b.getOperatorName(), b.getRemarks(), b.getRequestType(), b.getSource(), b.getTac(), b.getTxnId(), b.getUserId(), b.getUserType(), "GDCE_TAX_PAID"));
            }
            logger.info(" . ");
            blackListRepository.deleteByImei(gdData.getImei());
        } catch (Exception e) {
            logger.warn("Not able to insert/update in blacklist/his, Exception :{}", e.getLocalizedMessage());
        }
    }

    private boolean insertInGdceData(GdceData gdData) {
        try {
            gdData.setActual_imei(gdData.getImei());
            gdData.setImei(gdData.getImei().substring(0, 14));
            gdData.setIsCustomTaxPaid(gdData.getCustoms_duty_tax().equals("paid") ? 1 : 0);
            gdData.setSource("GDCE");
            gdceDataRepository.save(gdData);
            return true;
        } catch (Exception e) {
            logger.warn("Not able to insert in gdce_data, Exception :{}", e.getLocalizedMessage());
            return false;
        }
    }



    private boolean checkImeiInGdceData(GdceData gdData) {
        var a = gdceDataRepository.getByImei(gdData.getImei().substring(0, 14));
        if (a == null) return false;
        else return true;
    }

    public String createFile(String prm, String feature, String type, String reqId) {
        try {
            var filepath = systemParamServiceImpl.getValueByTag("CustomApiFilePath") + "/" + feature + "/" + reqId + "/";
            Files.createDirectories(Paths.get(filepath));
            if (StringUtils.isBlank(prm.trim())) prm = customImeiCheckImeiServiceImpl.globalErrorMsgs("en");
            logger.info("FullFilePath--" + filepath + reqId + "_" + type + ".txt");
            logger.info("Content-> " + prm);
            FileWriter writer = new FileWriter(filepath + reqId + "_" + type + ".txt");
            writer.write(prm);
            writer.close();
            var fileName = reqId + "_" + type + ".txt";//   callFileCopierApi(filepath, fileName ,reqId);
            return fileName;
        } catch (Exception e) {
            logger.error("Not able to create custom reg file {}", e.getLocalizedMessage());
        }
        return null;
    }

    private void callFileCopierApi(String filepath, String fileName,String req) {
        String url = systemParamServiceImpl.getValueByTag("platFormComponentApiUrl") + "/fileCopyApi";
        String body ="{\n" +
                "  \"appName\": \"CustomImei\",\n" +
                "  \"remarks\": \"CustomImei File to be copied\",\n" +
                "  \"destination\": [\n" +
                "    {\n" +
                "      \"destFilePath\": \""+filepath+"\",\n" +
                "      \"destServerName\": \" "+destServerName+" \"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"serverName\": \" "+serverName+" \",\n" +
                "  \"sourceFileName\": \" "+fileName+" \",\n" +
                "  \"sourceFilePath\": \" "+filepath+"  \",\n" +
                "  \"sourceServerName\": \"   "+sourceServerName+" \",\n" +
                "  \"txnId\": \" "+req+" \"\n" +
                "}" ;
        checkImeiServiceSendSMS.sendPostRequestToUrl(url, body);
    }

    public String startSample(String imei, String source) {
        try (Connection conn = dbRepository.getConnection()) {
            logger.info("Connection " + conn);
            return CustomCheck.identifyCustomComplianceStatus(imei, source);
        } catch (Exception e) {
            logger.error(" Not able to get response  {}", e.toString());
        }
        return null;
    }
}


class PrintReponse {
    String imei;
    String serialNumber;
    int statusCode;
    String statusMessage;
    String response;

    public PrintReponse(String imei, String serialNumber, int statusCode, String statusMessage, String response) {
        this.imei = imei;
        this.serialNumber = serialNumber;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.response = response;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public PrintReponse() {
    }

    @Override
    public String toString() {
        return "{" + "imei='" + imei + '\'' + ", serialNumber='" + serialNumber + '\'' + ", statusCode=" + statusCode + ", statusMessage='" + statusMessage + '\'' + ", response='" + response + '\'' + '}';
    }
}

class ResponseArray {

    String imei;
    String serialNumber;
    int statusCode;
    String statusMessage;

    public ResponseArray() {
    }

    public ResponseArray(String imei, String serialNumber, int statusCode, String statusMessage) {
        this.imei = imei;
        this.serialNumber = serialNumber;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @Override
    public String toString() {
        return "{" + "imei='" + imei + '\'' + ", serialNumber='" + serialNumber + '\'' + ", statusCode=" + statusCode + ", statusMessage='" + statusMessage + '\'' + '}';
    }
}

