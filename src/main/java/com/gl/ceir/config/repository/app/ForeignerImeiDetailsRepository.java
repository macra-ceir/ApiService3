package com.gl.ceir.config.repository.app;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gl.ceir.config.model.app.ForeignerImeiDetails;
import com.gl.ceir.config.model.app.ImeiInfo;

public interface ForeignerImeiDetailsRepository extends JpaRepository<ForeignerImeiDetails, Long> {


	public List<ForeignerImeiDetails> getByPassportNumber(String passportNumber);

	public void deleteByPassportNumber(String passportNumber);


	public ForeignerImeiDetails save(ForeignerImeiDetails foreignerImeiDetails);


	@Transactional
	@Modifying
	@Query(value = "UPDATE foreigner_imei_details  set  status= ?1,updated_on =now() where passport_number= ?2 and (first_imei=?3 or second_imei=?4)",
	nativeQuery = true)
	void updateUser(String status,String pasportNumber,Long imei1,Long imei2);





}
