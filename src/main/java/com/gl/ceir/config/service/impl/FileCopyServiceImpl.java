
package com.gl.ceir.config.service.impl;

import com.gl.ceir.config.model.app.GenricResponse;
import com.gl.ceir.config.model.app.UploadedFileDB;
import com.gl.ceir.config.model.app.UploadedFileDBOld;
import com.gl.ceir.config.repository.app.UploadedFileDBRepository;
import com.gl.ceir.config.repository.app.UploadedFileDBRepositoryOld;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileCopyServiceImpl {

    private static final Logger logger = LogManager.getLogger(FileCopyServiceImpl.class);

    @Autowired
    UploadedFileDBRepository uploadedFileDBRepository;
    
     @Autowired
    UploadedFileDBRepositoryOld uploadedFileDBRepositoryOld;

    public GenricResponse saveDetailsWithParam(UploadedFileDB uploadedFileDB) {
        try {
            var id = uploadedFileDBRepository.save(uploadedFileDB);
            return new GenricResponse(0, "Success", String.valueOf(id.getId()));
        } catch (Exception e) {
            logger.error( e.getLocalizedMessage(), e);
            logger.error(e.getCause().getCause().toString());
            return new GenricResponse(1, "Fail", e.getCause().getCause().toString());
        }
    }
    
    
      public GenricResponse saveFileCopyToSync(UploadedFileDBOld UploadedFileDBOld) {
        try {
            var id = uploadedFileDBRepositoryOld.save(UploadedFileDBOld);
            return new GenricResponse(0, "Success", String.valueOf(id.getId()));
        } catch (Exception e) {
            logger.error( e.getLocalizedMessage(), e);
            logger.error(e.getCause().getCause().toString());
            return new GenricResponse(1, "Fail", e.getCause().getCause().toString());
        }
    }
}
