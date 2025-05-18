package com.gl.ceir.config.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.ceir.config.exceptions.FileStorageException;
import com.gl.ceir.config.exceptions.ResourceServicesException;
import com.gl.ceir.config.model.app.ForeignerDetails;
import com.gl.ceir.config.model.app.ForeignerImeiDetails;
import com.gl.ceir.config.model.app.ForeignerRequest;
import com.gl.ceir.config.model.app.GenricResponse;
import com.gl.ceir.config.model.app.ImeiInfo;
import com.gl.ceir.config.model.app.SingleImeiDetails;
import com.gl.ceir.config.repository.app.ForeignerDetailsRepository;
import com.gl.ceir.config.repository.app.ForeignerImeiDetailsRepository;
import com.gl.ceir.config.repository.app.ImmegreationImeiDetailsRepository;
import com.gl.ceir.config.repository.app.StackholderPolicyMappingRepository;
import com.gl.ceir.config.util.Utility;

@Service
public class ForeignerServiceImpl {

	@Autowired
	ForeignerDetailsRepository foreignerDetailsRepository ;

	@Autowired
	ForeignerImeiDetailsRepository foreignerImeiDetailsRepository;


	@Autowired
	ImmegreationImeiDetailsRepository immegreationImeiDetailsRepository;

	@Autowired
	StackholderPolicyMappingRepository stackholderPolicyMappingRepository;

	@Autowired
	Utility utility;


	@Transactional	
	public GenricResponse addForeignerInfo(ForeignerRequest foreignerDetails) {
		try {

			ForeignerDetails foreignerDetailsData = new ForeignerDetails();
			foreignerDetailsData.setCountry(foreignerDetails.getCountry());
			foreignerDetailsData.setCreatedOn(new Date());
			foreignerDetailsData.setEmailId(foreignerDetails.getEmailId());
			foreignerDetailsData.setForeignerId(foreignerDetails.getForeignerId());
			foreignerDetailsData.setName(foreignerDetails.getName());
			foreignerDetailsData.setPassportNumber(foreignerDetails.getPassportNumber());
			foreignerDetailsData.setUpdatedOn(new Date());
			foreignerDetailsData.setVisaExpireDate(foreignerDetails.getVisaExpireDate());
			foreignerDetailsData.setVisaNumber(foreignerDetails.getVisaNumber());

			ForeignerDetails passportNumberInfo = foreignerDetailsRepository.findByPassportNumberOrVisaNumber(foreignerDetails.getPassportNumber(), foreignerDetails.getVisaNumber());

			if(passportNumberInfo == null) {

				foreignerDetailsRepository.save(foreignerDetailsData);

				for(ImeiInfo details : foreignerDetails.getImeiInfo() )
				{
					ForeignerImeiDetails foreignerImeiDetails = new ForeignerImeiDetails();
					foreignerImeiDetails.setCreatedOn(new Date());
					foreignerImeiDetails.setUpdatedOn(new Date());
					foreignerImeiDetails.setFirstImei(details.getFirstImei());
					foreignerImeiDetails.setFirstMsisdn(details.getFirstMsisdn());
					foreignerImeiDetails.setSecondImei(details.getSecondImei());
					foreignerImeiDetails.setSecondMsidn(details.getSecondMsidn());
					foreignerImeiDetails.setPassportNumber(foreignerDetails.getPassportNumber());

					foreignerImeiDetailsRepository.save(foreignerImeiDetails);
				}


				return new GenricResponse(200, "Upload SuccessFully","");
			}else {

				return new GenricResponse(1002,"Passport number or Visa number any one already exist","");
			}

		}catch (Exception e) {
			throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
		}	
	}



	public List<ForeignerImeiDetails> viewImeidetails(String passportNumber){
		try {

			return 	foreignerImeiDetailsRepository.getByPassportNumber(passportNumber);

		} catch (Exception e) {
			throw new FileStorageException("Exception found.",e);
		}
	}


	public GenricResponse updateInfo(ForeignerRequest foreignerDetails) {
		try {

			ForeignerDetails passporntNumber = foreignerDetailsRepository.getByPassportNumber(foreignerDetails.getPassportNumber());
			if(passporntNumber == null) {

				return new GenricResponse(1003, "Passport number Not Found","");
			}else {

				ForeignerDetails foreignerDetailsData = new ForeignerDetails();
				foreignerDetailsData.setCountry(foreignerDetails.getCountry());
				foreignerDetailsData.setEmailId(foreignerDetails.getEmailId());
				foreignerDetailsData.setForeignerId(foreignerDetails.getForeignerId());
				foreignerDetailsData.setName(foreignerDetails.getName());
				foreignerDetailsData.setPassportNumber(foreignerDetails.getPassportNumber());
				foreignerDetailsData.setUpdatedOn(new Date());
				foreignerDetailsData.setVisaExpireDate(foreignerDetails.getVisaExpireDate());
				foreignerDetailsData.setVisaNumber(foreignerDetails.getVisaNumber());

				foreignerDetailsRepository.save(foreignerDetailsData);

				foreignerImeiDetailsRepository.deleteByPassportNumber(foreignerDetails.getPassportNumber());

				for(ImeiInfo details : foreignerDetails.getImeiInfo() )
				{
					ForeignerImeiDetails foreignerImeiDetails = new ForeignerImeiDetails();
					foreignerImeiDetails.setCreatedOn(new Date());
					foreignerImeiDetails.setUpdatedOn(new Date());
					foreignerImeiDetails.setFirstImei(details.getFirstImei());
					foreignerImeiDetails.setFirstMsisdn(details.getFirstMsisdn());
					foreignerImeiDetails.setSecondImei(details.getSecondImei());
					foreignerImeiDetails.setSecondMsidn(details.getSecondMsidn());
					foreignerImeiDetails.setPassportNumber(foreignerDetails.getPassportNumber());

					foreignerImeiDetailsRepository.save(foreignerImeiDetails);
				}

				return new GenricResponse(200, "Update Successfully","");
			}

		} catch (Exception e) {
			throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
		}
	}



	public ForeignerRequest getPassportNumberDetails(String passportNumber) {
		try {
			List<ImeiInfo> list =new ArrayList<ImeiInfo>();
			ImeiInfo imeiInfo = new ImeiInfo();
			ForeignerDetails passportInfo = foreignerDetailsRepository.getByPassportNumber(passportNumber);

			ForeignerRequest foreignerRequest = new ForeignerRequest();
			foreignerRequest.setCountry(passportInfo.getCountry());
			foreignerRequest.setEmailId(passportInfo.getEmailId());
			foreignerRequest.setForeignerId(passportInfo.getForeignerId());
			foreignerRequest.setName(passportInfo.getName());
			foreignerRequest.setPassportNumber(passportNumber);
			foreignerRequest.setVisaExpireDate(passportInfo.getVisaExpireDate());
			foreignerRequest.setVisaNumber(passportInfo.getVisaNumber());
			foreignerRequest.setCreatedOn(passportInfo.getCreatedOn());
			foreignerRequest.setUpdatedOn(passportInfo.getUpdatedOn());			


			List<ForeignerImeiDetails> info = foreignerImeiDetailsRepository.getByPassportNumber(passportNumber);

			for(ForeignerImeiDetails details :info) {
				imeiInfo.setFirstImei(details.getFirstImei());
				imeiInfo.setSecondImei(details.getSecondImei());
				imeiInfo.setFirstMsisdn(details.getFirstMsisdn());
				imeiInfo.setSecondMsidn(details.getSecondMsidn());

				list.add(imeiInfo);
			}

			foreignerRequest.setImeiInfo(list);

			return foreignerRequest;

		} catch (Exception e) {
			throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
		}

	}



	public List<ForeignerDetails> fetchallData(){
		try {

			return 	foreignerDetailsRepository.findAll();

		} catch (Exception e) {
			throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
		}


	}

	@Transactional
	public GenricResponse updateImeiActionInfo(SingleImeiDetails immegreationImeiDetails) {


		return null;
	}












}
