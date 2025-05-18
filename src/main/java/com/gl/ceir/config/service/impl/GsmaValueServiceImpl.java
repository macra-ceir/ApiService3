package com.gl.ceir.config.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.ceir.config.exceptions.ResourceServicesException;
import com.gl.ceir.config.model.app.GsmaValueModel;
import com.gl.ceir.config.model.app.UsagesValueModel;
import com.gl.ceir.config.model.app.DuplicateValueModel;
import com.gl.ceir.config.repository.app.GsmaValueRepository;
import com.gl.ceir.config.repository.app.UsagesValueRepository;
import com.gl.ceir.config.repository.app.DuplicateValueRepository;

@Service
public class GsmaValueServiceImpl  {

     private static final Logger logger = LogManager.getLogger(GsmaValueServiceImpl.class);
 @Autowired
     DuplicateValueRepository duplicateValueRepository;
     @Autowired
     GsmaValueRepository gsmaValueRepository;

     @Autowired
     UsagesValueRepository usagesValueRepository;

    
     

     public GsmaValueModel getAll(int device_id) {
          try {
               logger.info("Going to get All Values   for id;; " + device_id);
               GsmaValueModel gmaValueModel = gsmaValueRepository.getByDeviceId(device_id);
                logger.info("result is " + gmaValueModel);
               return gsmaValueRepository.getByDeviceId(device_id);

          } catch (Exception e) {
               logger.error(e.getMessage(), e);
               throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
          }
     }

     public UsagesValueModel getimeiValbymsisdn(String msisdn) {
          UsagesValueModel usagesValueModel = null;
          try {
               logger.info(" imei is Null ");
               usagesValueModel = usagesValueRepository.getByMsisdn(msisdn.toString());
               logger.info(" result is  " + usagesValueModel);
               return usagesValueModel;
          } catch (Exception e) {
               logger.error(e.getMessage(), e);
               throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
          }
     }

     public UsagesValueModel getimeiValbyImei(String imei) {
          UsagesValueModel usagesValueModel = null;
          try {
               logger.info("Get Values By Imei");
               usagesValueModel = usagesValueRepository.getByImei(imei.toString());
               logger.info(" Result by imei is  " + usagesValueModel);
               return usagesValueModel;
          } catch (Exception e) {
               logger.error(e.getMessage(), e);
               throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
          }

     }

     public String getimeiMsisdnDetail(String imei, String msisdn) {
          UsagesValueModel usagesValueModel = null;
          DuplicateValueModel duplicateValueModel = null;
          try {
               logger.info("Find if Combination Present");
               usagesValueModel = usagesValueRepository.getByImeiAndMsisdn(imei, msisdn);  //usage db
               logger.info("Value From usagesValueModel Query : " + usagesValueModel);
               if (usagesValueModel == null) {
                    logger.info(":: ");
                    duplicateValueModel = duplicateValueRepository.getByImeiAndMsisdn(imei, msisdn);  // dublicate dv
                    logger.info("Value From duplicateValueModel Query : " + duplicateValueModel);
                    if (duplicateValueModel == null) {
                         logger.info("  :::: ");
                         return "No";
                    } else {
                         return "Yes";
                    }
               } else {
                    return "Yes";
               }
          } catch (Exception e) {
               logger.error(e.getMessage(), e);
               throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
          }
     }

}

//	public UsagesValueModel getimeiVal(Integer msisdn , Long  imei) {
//				UsagesValueModel usagesValueModel  = new UsagesValueModel() ;
//		try {
//			logger.info("Going to get imei , imsi , msisdn  ;; ");
//			if(imei  == null) {
//				logger.info(" imei is Null ");
//           usagesValueModel = usagesValueRepository.getByMsisdn(msisdn);
//           logger.info(" result is  "+ usagesValueModel);
//			}else {
//				logger.info(" imei is  Not Null , MSisdn is null" );
//				usagesValueModel = usagesValueRepository.getByImei( imei);
//				 logger.info(" result by imei is  "+ usagesValueModel);
//			}
//			 	return usagesValueModel;
//				
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
//		}
//		
//		
//		
//	}
