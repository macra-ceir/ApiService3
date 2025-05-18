package com.gl.ceir.config.repository.app;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.ceir.config.model.app.StackholderPolicyMapping;

public interface StackholderPolicyMappingRepository extends JpaRepository<StackholderPolicyMapping, Long> {


	public 	StackholderPolicyMapping getByListType(String listType);

	public List<StackholderPolicyMapping> findByListTypeOrListType(String listType,String greyList);


}
