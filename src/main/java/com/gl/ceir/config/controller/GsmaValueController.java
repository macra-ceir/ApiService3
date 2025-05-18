package com.gl.ceir.config.controller;

import com.gl.ceir.config.model.app.FilterRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.ceir.config.model.app.GsmaValueModel;
import com.gl.ceir.config.model.app.UsagesValueModel;
import com.gl.ceir.config.service.impl.GsmaValueServiceImpl;

//import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class GsmaValueController {   // sachin Maverick 

    private static final Logger logger = LogManager.getLogger(GsmaValueController.class);

    @Autowired
    GsmaValueServiceImpl GsmaValueServiceImpl;

    //@ApiOperation(value = "View All list of Values of Gsma", response = GsmaValueModel.class)
    @PostMapping(path = "gsma/GsmaValues")
    public MappingJacksonValue getAllValues(@RequestBody FilterRequest checkImeiValuesEntity) {

        String msisdn = checkImeiValuesEntity.getMsisdn().trim();
        String imei = checkImeiValuesEntity.getImei();
        String identifierType = checkImeiValuesEntity.getIdentifierType();

        MappingJacksonValue mapping = null;
        logger.info("imei " + imei);
        logger.info("msisdn" + msisdn);
        logger.info("identifierType =" + identifierType);

        String ismi = null;
        UsagesValueModel usagesValueModel = null;
        if (imei == null) {  // imei not found    then    going ot fetch details by msisdn 
            usagesValueModel = GsmaValueServiceImpl.getimeiValbymsisdn(msisdn);
            if (usagesValueModel == null) {
                logger.info("IMEI IS NOT FOUND");
                imei = "NA";
                ismi = "NA";
            } else {
                imei = usagesValueModel.getImei();
                ismi = usagesValueModel.getImsi() == null ? "NA" : usagesValueModel.getImsi();
            }
        } else {
            imei = imei.substring(0, 14);
            usagesValueModel = GsmaValueServiceImpl.getimeiValbyImei(imei);
            ismi = usagesValueModel == null ? "NA" : usagesValueModel.getImsi();
            msisdn = usagesValueModel == null ? "NA" : usagesValueModel.getMsisdn();
        }
        logger.info("  imei ISS ....." + imei);
        logger.info("  imsi ISS ....." + ismi);
        logger.info("  MSISDN ISS ....." + msisdn);
        int tac = 00;
        if (imei != "NA") {
            tac = Integer.parseInt(imei.toString().trim().substring(0, 8));     // 8 digit
        }
        logger.info("  tac  ....." + tac);
        GsmaValueModel getvals = GsmaValueServiceImpl.getAll(tac);

        logger.info("rsult at cntrl " + getvals);

        logger.info(checkImeiValuesEntity.getId() + "rsult values " + checkImeiValuesEntity.getUserId() + "  :: " + checkImeiValuesEntity.getUserName());

//            auditTrailRepository.save(new AuditTrail(checkImeiValuesEntity.getUserId(), checkImeiValuesEntity.getUserName(),
//                    Long.valueOf(checkImeiValuesEntity.getUserTypeId()), checkImeiValuesEntity.getUserType(),
//                    Long.valueOf(checkImeiValuesEntity.getFeatureId()), "Search", "View", "", "NA" ,
//                    checkImeiValuesEntity.getRoleType(), checkImeiValuesEntity.getPublicIp(), checkImeiValuesEntity.getBrowser()));
//            logger.info("AUDIT : Saved view request in audit.");
        if (getvals == null) {
            GsmaValueModel getvals1 = new GsmaValueModel();
            logger.info("For Nulled");
            getvals1.setModelName("NA");
            getvals1.setBandName("NA");
            getvals1.setEquipmentType("NA");
            getvals1.setOperatingSystem("NA");
            getvals1.setImei(imei);
            getvals1.setImsi(ismi);
            getvals1.setMsisdn(msisdn);
            getvals1.setIdentifierType(identifierType);

            mapping = new MappingJacksonValue(getvals1);
        } else {
            if (usagesValueModel == null) {
                getvals.setImei("NA");
                getvals.setMsisdn("NA");
                getvals.setImsi("NA");
                getvals.setACTION("NA");
                getvals.setCREATE_FILENAME("NA");
                getvals.setFAILED_RULE_DATE("NA");
                getvals.setFAILED_RULE_ID("NA");
                getvals.setFAILED_RULE_NAME("NA");
                getvals.setFEATURE_NAME("NA");
                getvals.setFOREGIN_RULE(00);
                getvals.setMOBILE_OPERATOR("NA");
                getvals.setPERIOD("NA");
                getvals.setRECORD_TIME("NA");
                getvals.setRECORD_TYPE("NA");
                getvals.setSYSTEM_TYPE("NA");
                getvals.setTAC("NA");
                getvals.setUPDATE_FILENAME("NA");
            } else {
                getvals.setImei(usagesValueModel.getImei());
                getvals.setMsisdn(usagesValueModel.getMsisdn());
                getvals.setImsi(usagesValueModel.getImsi());
                getvals.setACTION(usagesValueModel.getACTION());
                getvals.setCREATE_FILENAME(usagesValueModel.getCREATE_FILENAME());
                getvals.setFAILED_RULE_DATE(usagesValueModel.getFAILED_RULE_DATE());
                getvals.setFAILED_RULE_ID(usagesValueModel.getFAILED_RULE_ID());
                getvals.setFAILED_RULE_NAME(usagesValueModel.getFAILED_RULE_NAME());
                getvals.setFEATURE_NAME(usagesValueModel.getFEATURE_NAME());
//                    getvals.setFOREGIN_RULE(usagesValueModel.getFOREGIN_RULE());
                getvals.setMOBILE_OPERATOR(usagesValueModel.getMOBILE_OPERATOR());
                getvals.setPERIOD(usagesValueModel.getPERIOD());
                getvals.setRECORD_TIME(usagesValueModel.getRECORD_TIME());
                getvals.setRECORD_TYPE(usagesValueModel.getRECORD_TYPE());
                getvals.setSYSTEM_TYPE(usagesValueModel.getSYSTEM_TYPE());
                getvals.setTAC(usagesValueModel.getTAC());
                getvals.setUPDATE_FILENAME(usagesValueModel.getUPDATE_FILENAME());
            }
            getvals.setIdentifierType(identifierType);
            mapping = new MappingJacksonValue(getvals);
        }
        logger.info("Response of View =" + mapping);
        return mapping;
    }

    //@ApiOperation(value = " Check Imei Msisdn Combination Present ")
    @PostMapping(path = "gsma/CheckImeiMsisdnValues")
    public String CheckImeiMsisdnValues(String imei, String msisdn) {
        logger.info("Imei:   " + imei + " ;msisdn: " + msisdn);
        String stats = GsmaValueServiceImpl.getimeiMsisdnDetail(imei, msisdn);
        logger.info("Response =" + stats);
        return stats;
    }

}

//
//logger.info("Request TO view TO all identifierType =" + identifierType);
//
//String imeiVal = "";
//String iemi = "";
//String ismi = "";
//String msdn = "";
//UsagesValueModel usagesValueModel = null;
//if (imei == null) {
//	usagesValueModel = GsmaValueServiceImpl.getimeiValbymsisdn(msisdn);
//	if (usagesValueModel == null) {
//		logger.info("  IMEI IS NOT FOUND");
//		imeiVal = "0000000000000";
//		 iemi =  "00" ;
//		 ismi =  "00";
//		 msdn =  msisdn.toString();	
//	} else {
//		imeiVal = usagesValueModel.getImei().toString();
//		 ismi =  usagesValueModel.getImsi() == null ?"00" : usagesValueModel.getImsi().toString() ;
//		 msdn =  usagesValueModel.getMsisdn() == null ? "00" : usagesValueModel.getMsisdn().toString() ;	
//		logger.info("  IMEI IS  FOUND  WITH " + imeiVal);
//		msdn =  msisdn.toString();	
//		
//	}
//
//} else {
//	imeiVal = imei.toString();
//	usagesValueModel = GsmaValueServiceImpl.getimeiValbyImei(imei);
//	 iemi =  imeiVal;
////	 iemi =  usagesValueModel == null ?  "00" :usagesValueModel.getImei().toString() ;
//	 ismi =  usagesValueModel == null ?"00" : usagesValueModel.getImsi().toString() ;
//	 msdn =  usagesValueModel == null ? "00" : usagesValueModel.getMsisdn().toString() ;	
//}
//
//
//
//logger.info("  imeiVal ISS ....." + imeiVal);
//int tac = Integer.parseInt(imeiVal.trim().substring(0, 8));
//logger.info("  tac  ....." + tac);
//GsmaValueModel getvals = GsmaValueServiceImpl.getAll(tac);
//
// logger.info("rsult at cntrl " + getvals);
//
//if (getvals == null) {
//	GsmaValueModel getvals1 = new GsmaValueModel();
//	 logger.info("For Nulled");
//	getvals1.setModelName("NA");
//	getvals1.setBandName("NA");
//	getvals1.setEquipmentType("NA");
//	getvals1.setOperatingSystem("NA");
//	getvals1.setImei(iemi);
//	getvals1.setImsi(ismi);
//	getvals1.setMsisdn(msdn);
//	 logger.info("\\ Nulled  NA  FOR 66666");
//	
//	mapping = new MappingJacksonValue(getvals1);
//} else {
//	getvals.setImei(usagesValueModel.getImei().toString());
//	getvals.setMsisdn(usagesValueModel.getMsisdn().toString());
//	getvals.setImsi(usagesValueModel.getImsi().toString());
//	mapping = new MappingJacksonValue(getvals);
//}

