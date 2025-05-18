package com.gl.ceir.config.repository.app;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gl.ceir.config.model.app.modelRepoPojo;





public  interface ModelRepository extends JpaRepository<modelRepoPojo, Long>, JpaSpecificationExecutor<modelRepoPojo>  {


	public List<modelRepoPojo> getByBrandNameIdOrderByModelNameAsc(int brandNameId);
     
}
