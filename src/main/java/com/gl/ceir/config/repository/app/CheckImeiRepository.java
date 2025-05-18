package com.gl.ceir.config.repository.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gl.ceir.config.model.app.RuleEngineMapping;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.stereotype.Repository;


@Repository
public  interface CheckImeiRepository extends JpaRepository<RuleEngineMapping,Long>, JpaSpecificationExecutor<RuleEngineMapping>  {

	public List<RuleEngineMapping> getByFeatureAndUserTypeOrderByRuleOrder(String feature,String user_type);

}

