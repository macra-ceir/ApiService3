package com.gl.ceir.config.repository.app;

import com.gl.ceir.config.model.app.UploadedFileDBOld;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

 
 
@Component
public interface UploadedFileDBRepositoryOld extends JpaRepository<UploadedFileDBOld, Long> {
	 
}
