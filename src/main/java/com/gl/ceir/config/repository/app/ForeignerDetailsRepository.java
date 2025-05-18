package com.gl.ceir.config.repository.app;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gl.ceir.config.model.app.ForeignerDetails;
import com.gl.ceir.config.model.app.ForeignerRequest;

public interface ForeignerDetailsRepository extends JpaRepository<ForeignerDetails, Long>{

	public ForeignerDetails findByPassportNumberOrVisaNumber(String passportNumber,String visaNumber);

	public ForeignerDetails save(ForeignerDetails foreignerDetails);

	public List<ForeignerDetails> findAll();



	public ForeignerDetails getByPassportNumber(String passportNumber);





}
