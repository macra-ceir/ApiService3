package com.gl.ceir.config.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gl.ceir.config.exceptions.FileStorageException;
import com.gl.ceir.config.model.app.GenricResponse;
import com.gl.ceir.config.model.app.ImmegreationFileDetails;
import com.gl.ceir.config.model.app.StackholderPolicyMapping;
import com.gl.ceir.config.repository.app.ImmegreationFileDertailsRepository;
import com.gl.ceir.config.repository.app.StackholderPolicyMappingRepository;
import com.gl.ceir.config.util.Utility;

@Service
public class ImmegreationServiceImpl {

	@Autowired
	StackholderPolicyMappingRepository stackholderPolicyMappingRepository;

	@Autowired
	Utility utility;

	@Autowired
	ImmegreationFileDertailsRepository immegreationFileDertailsRepository;

	private final static String NUMERIC_STRING = "0123456789";

//	@Autowired
//	FileStorageProperties fileStorageProperties;


	@Transactional
	public GenricResponse uploadFileStatus(MultipartFile file, ImmegreationFileDetails immegreationFileDetails)
	{
		try {
			String txnId = getTxnId();

                    String serverPath = "";
                    //fileStorageProperties.getImmegreationUploadDir();
			serverPath = serverPath.replace("txnId", txnId);

			File dir = new File(serverPath);
			if (!dir.exists()) {
				boolean status=	dir.mkdirs();
			}

			File serverFile = new File(serverPath+file.getOriginalFilename());
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(file.getBytes());
			stream.flush();


			if("Block".equalsIgnoreCase(immegreationFileDetails.getFileType())) {

				if("Default".equalsIgnoreCase(immegreationFileDetails.getBlockingType()) || immegreationFileDetails.getBlockingType() == "" || immegreationFileDetails.getBlockingType() == null)
				{

					StackholderPolicyMapping stackholderPolicyMapping =	stackholderPolicyMappingRepository.getByListType("Block");

					String newdate =utility.newDate(stackholderPolicyMapping.getGraceTimePeriod());
					immegreationFileDetails.setBlockingTime(newdate);
					immegreationFileDetails.setBlockingType("Default");				

				}
			}


			immegreationFileDetails.setTxnId(txnId);
			immegreationFileDertailsRepository.save(immegreationFileDetails);

			return new GenricResponse(200, "File Upload SuccessFully","");
		}catch (Exception e) {

			throw new FileStorageException("Could not store file " + file.getOriginalFilename() + ". Please try again!", e);
		}
	}


	public String getTxnId() {

		DateFormat dateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
		//DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
		Date date = new Date();
		String transactionId = dateFormat.format(date)+randomNumericString(3);	
		return transactionId;
	}

	public static String randomNumericString(int length) {
		StringBuilder builder = new StringBuilder();
		while (length-- != 0) {
			int character = (int)(Math.random()*NUMERIC_STRING.length());
			builder.append(NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}







}
