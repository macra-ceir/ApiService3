package com.gl.ceir.config.repository.app;

import com.gl.ceir.config.model.app.UploadedFileDB;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

 
 
@Component
public interface UploadedFileDBRepository extends JpaRepository<UploadedFileDB, Long> {
	 
}
