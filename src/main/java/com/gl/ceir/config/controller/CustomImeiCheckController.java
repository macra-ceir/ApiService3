package com.gl.ceir.config.controller;

import com.gl.ceir.config.exceptions.MissingRequestParameterException;
import com.gl.ceir.config.exceptions.PayloadSizeExceeds;
import com.gl.ceir.config.exceptions.UnAuthorizationException;
import com.gl.ceir.config.exceptions.UnprocessableEntityException;
import com.gl.ceir.config.model.app.*;
import com.gl.ceir.config.model.constants.CustomCheckImeiRequest;
import com.gl.ceir.config.repository.app.*;
import com.gl.ceir.config.service.impl.*;
import com.gl.ceir.config.service.userlogic.UserFactory;
import com.gl.custom.CustomCheck;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class CustomImeiCheckController {  //sachin

    private static final Logger logger = LogManager.getLogger(CustomImeiCheckController.class);

    @Value("${local-ip}")
    public String localIp;
    @Value("${authFail}")
    private String authFail;
    @Value("${authUserIpNotMatch}")
    private String authUserIpNotMatch;
    @Value("${authFeatureIpNotMatch}")
    private String authFeatureIpNotMatch;
    @Value("${authFeatureIpNotPresent}")
    private String authFeatureIpNotPresent;
    @Value("${authUserPassNotMatch}")
    private String authUserPassNotMatch;
    @Value("${authOperatorNotPresent}")
    private String authOperatorNotPresent;
    @Value("${authNotPresent}")
    private String authNotPresent;
    @Value("${requiredValueNotPresent}")
    private String requiredValueNotPresent;
    @Value("${mandatoryParameterMissing}")
    private String mandatoryParameterMissing;
    @Value("${nullPointerException}")
    private String nullPointerException;
    @Value("${sqlException}")
    private String sQLException;
    @Value("${someWentWrongException}")
    private String someWentWrongException;

    @Value("${customImeiPayLoadMaxSize}")
    private String customImeiPayLoadMaxSize;

    @Value("${customImeiRegisterPayLoadMaxSize}")
    private String customImeiRegisterPayLoadMaxSize;

    @Value("${maxSizeDefinedException}")
    private String maxSizeDefinedException;

    @Value("#{'${languageType}'.split(',')}")
    public List<String> languageType;

    @Autowired
    UserFactory userFactory;

    @Autowired
    CheckImeiServiceImpl checkImeiServiceImpl;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    SystemConfigListRepository systemConfigListRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FeatureIpAccessListRepository featureIpAccessListRepository;

    @Autowired
    UserFeatureIpAccessListRepository userFeatureIpAccessListRepository;

    @Autowired
    GdceCheckImeiReqRepository gdceCheckImeiReqRepository;

    @Autowired
    CustomImeiRegisterServiceImpl customImeiCheckServiceImpl;

    @Autowired
    CustomImeiCheckImeiServiceImpl customImeiCheckImeiServiceImpl;

    @Autowired
    GdceRegisterImeiReqRepo gdceRegisterImeiReqRepo;

    @Autowired
    SystemParamServiceImpl systemParamServiceImpl;

    @Autowired
    DbRepository dbRepository;

    @Autowired
    CustomCheck customCheck;

    @Autowired
    EirsResponseParamServiceImpl eirsResponseParamServiceImpl;

    @ApiOperation(value = "Sample Imei Check Api", response = CustomImeiCheckResponse.class)
    @CrossOrigin(origins = "", allowedHeaders = "")
    @GetMapping("/gdce/Sample/checkIMEI")
    public String sampleController(@RequestParam String imei, String source) {
        try (Connection conn = dbRepository.getConnection()) {
            return customImeiCheckServiceImpl.startSample(imei, source);
        } catch (Exception e) {
            logger.info("TESTING ERRROR {}", e);
        }
        return null;
    }

    @ApiOperation(value = "Custom Imei Check Api", response = CustomImeiCheckResponse.class)
    @CrossOrigin(origins = "", allowedHeaders = "")
    @PostMapping("/gdce/services/checkIMEI")
    public ResponseEntity gdceCheckImeiDevice(@RequestBody List<CustomCheckImeiRequest> customCheckImeiRequest) {
        String reqId = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        getHeaderDetails();
        authorizationCheckerForCustom();
        String fileName = customImeiCheckServiceImpl.createFile(Arrays.toString(customCheckImeiRequest.toArray()), "checkIMEI", "req", reqId);
        var obj = gdceCheckImeiReqRepository.save(new GdceCheckImeiReq("INIT", " ", reqId, customCheckImeiRequest.size(), fileName));
        errorValidationCheckerForCustomCheck(customCheckImeiRequest, obj);
        List<CustomImeiCheckResponse> value = customImeiCheckImeiServiceImpl.startCustomCheckService(customCheckImeiRequest, obj);
        return ResponseEntity.status(HttpStatus.OK).headers(HttpHeaders.EMPTY).body(new MappingJacksonValue(value));
    }

    @ApiOperation(value = "register Custom Imei Check Api", response = ResponseEntity.class)
    @CrossOrigin(origins = "", allowedHeaders = "")
    @PostMapping("/gdce/services/registerIMEI")
    public ResponseEntity gdceRegisterDevice(@RequestBody List<GdceData> gdceData) {
        getHeaderDetails();
        authorizationCheckerForCustom();
        logger.info("Request :: {} ", gdceData);
        String reqId = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        String fileName = customImeiCheckServiceImpl.createFile(Arrays.toString(gdceData.toArray()), "registerIMEI", "req", reqId);
        var obj = gdceRegisterImeiReqRepo.save(new GdceRegisterImeiReq("INIT", "", reqId, gdceData.size(), fileName));
        errorValidationCheckerForRegister(gdceData, obj);
        var value = customImeiCheckServiceImpl.registerService(gdceData, obj);
        return ResponseEntity.status(HttpStatus.OK).headers(HttpHeaders.EMPTY).body(new MappingJacksonValue(value));
    }

    private void errorValidationCheckerForRegister(List<GdceData> gdceRegister, GdceRegisterImeiReq obj) {
        if (gdceRegister == null || gdceRegister.size() == 0) {
            obj.setStatus("FAIL");
            obj.setRemark(eirsResponseParamServiceImpl.getValueByTag("customImeiRegisterReqLength0"));
            obj.setHttpStatusCode(400);
            gdceRegisterImeiReqRepo.save(obj);
            customImeiCheckServiceImpl.createFile(mandatoryParameterMissing, "registerIMEI", "response", obj.getRequestId());
            throw new MissingRequestParameterException("en", mandatoryParameterMissing);
        }

        if (gdceRegister.size() > Integer.parseInt(customImeiRegisterPayLoadMaxSize)) {
            obj.setStatus("FAIL");
            obj.setRemark(eirsResponseParamServiceImpl.getValueByTag("customImeiRegisterPayLoadMaxSize"));
            obj.setHttpStatusCode(413);
            gdceRegisterImeiReqRepo.save(obj);
            customImeiCheckServiceImpl.createFile(customImeiRegisterPayLoadMaxSize, "registerIMEI", "response", obj.getRequestId());
            throw new PayloadSizeExceeds("en", maxSizeDefinedException);
        }// authorizationChecker(re,);
    }

    void errorValidationCheckerForCustomCheck(List<CustomCheckImeiRequest> customCheckImeiRequest, GdceCheckImeiReq re) {
        if (customCheckImeiRequest == null || customCheckImeiRequest.size() == 0) {
            re.setStatus("FAIL");
            re.setRemark(mandatoryParameterMissing);
            gdceCheckImeiReqRepository.save(re);
            customImeiCheckServiceImpl.createFile(mandatoryParameterMissing, "checkIMEI", "response", re.getRequestId());
            throw new MissingRequestParameterException("en", mandatoryParameterMissing);
        }
        if (customCheckImeiRequest.size() > Integer.parseInt(customImeiPayLoadMaxSize)) {
            re.setStatus("FAIL");
            re.setRemark(maxSizeDefinedException);
            gdceCheckImeiReqRepository.save(re);
            customImeiCheckServiceImpl.createFile(maxSizeDefinedException, "checkIMEI", "response", re.getRequestId());
            throw new PayloadSizeExceeds("en", maxSizeDefinedException);
        }
    }

    private <T> void authorizationCheckerForCustom() {
        //long startTime = System.currentTimeMillis();
        if (!Optional.ofNullable(request.getHeader("Authorization")).isPresent() || !request.getHeader("Authorization").startsWith("Basic ")) {
            logger.info("Rejected Due to  Authorization  Not Present" + request.getHeader("Authorization"));
            throw new UnAuthorizationException("en", checkImeiServiceImpl.globalErrorMsgs("en"));
        }
        logger.info("Basic Authorization present " + request.getHeader("Authorization").substring(6));
        try {
            var decodedString = new String(Base64.getDecoder().decode(request.getHeader("Authorization").substring(6)));
            logger.info("user:" + decodedString.split(":")[0] + "pass:" + decodedString.split(":")[1]);
            UserVars userValue = null;
            if (systemParamServiceImpl.getValueByTag("CustomApiAuthOperatorCheck").equalsIgnoreCase("true")) {
                var systemConfig = systemConfigListRepository.findByTagAndInterp("OPERATORS", request.getHeader("Operator"));
                if (systemConfig == null) {
                    logger.info("Operator Not allowed ");
                    throw new UnprocessableEntityException("en", checkImeiServiceImpl.globalErrorMsgs("en"));
                }
                logger.info("Found operator with  value " + systemConfig.getValue());
                userValue = (UserVars) userFactory.createUser().getUserDetailDao(decodedString.split(":")[0], decodedString.split(":")[1], systemConfig.getValue());
            } else {
                userValue = (UserVars) userFactory.createUser().getUserDetailDao(decodedString.split(":")[0], decodedString.split(":")[1]);
            }
            if (userValue == null || !userValue.getUsername().equals(decodedString.split(":")[0]) || !userValue.getPassword().equals(decodedString.split(":")[1])) {
                logger.info("username password not match");
                throw new UnAuthorizationException("en", checkImeiServiceImpl.globalErrorMsgs("en"));
            }

            if (systemParamServiceImpl.getValueByTag("CustomApiAuthWithIpCheck").equalsIgnoreCase("true")) {
                var checkimeiFeatureType = systemParamServiceImpl.getValueByTag("CUSTOM_API_FEATURE_ID");
                FeatureIpAccessList featureIpAccessList = featureIpAccessListRepository.getByFeatureId(checkimeiFeatureType);
                logger.info(" featureIpAccess List  " + featureIpAccessList);
                if (featureIpAccessList == null) {
                    throw new UnAuthorizationException("en", checkImeiServiceImpl.globalErrorMsgs("en"));
                }
                if (featureIpAccessList.getTypeOfCheck() == 1) {
                    if (!featureIpAccessList.getIpAddress().contains(request.getHeader("Header_ip"))) {//checkImeiRequest.getHeader_public_ip()
                        logger.info("Type Check 1 But Ip not allowed ");
                        // checkImeiServiceImpl.saveCheckImeiFailDetails(checkImeiRequest, startTime, authFeatureIpNotMatch);
                        throw new UnAuthorizationException("en", checkImeiServiceImpl.globalErrorMsgs("en"));
                    }
                } else {
                    logger.info("Type Check 2 with feature id  " + featureIpAccessList.getFeatureIpListId() + " And User id " + userValue.getId());
                    UserFeatureIpAccessList userFeatureIpAccessList = userFeatureIpAccessListRepository.getByFeatureIpListIdAndUserId(featureIpAccessList.getFeatureIpListId(), userValue.getId());
                    logger.info("Response from  UserFeatureIpAccess List " + userFeatureIpAccessList);
                    if (userFeatureIpAccessList == null || !(userFeatureIpAccessList.getIpAddress().contains(request.getHeader("Header_ip")))) { //checkImeiRequest.getHeader_public_ip()
                        logger.info("Type Check 2 But Ip not allowed ");
                        throw new UnAuthorizationException("en", checkImeiServiceImpl.globalErrorMsgs("en"));
                    }
                }
            }
            logger.debug("Authentication Pass");
        } catch (Exception e) {
            logger.warn("Authentication fail" + e);
            throw new UnAuthorizationException("en", checkImeiServiceImpl.globalErrorMsgs("en"));
        }
    }

    private void getHeaderDetails() {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Map<String, String> headers = Collections.list(httpRequest.getHeaderNames())
                .stream()
                .collect(Collectors.toMap(h -> h, httpRequest::getHeader));
        logger.info("Headers->  {}", headers);
    }
}
