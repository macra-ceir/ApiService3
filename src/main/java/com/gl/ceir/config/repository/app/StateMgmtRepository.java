package com.gl.ceir.config.repository.app;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.gl.ceir.config.model.app.StateMgmtDb;

@Repository
public interface StateMgmtRepository extends JpaRepository<StateMgmtDb, Long>, JpaSpecificationExecutor<StateMgmtDb> {

	public List<StateMgmtDb> getByFeatureIdAndUserTypeId(Integer featureId, Integer userTypeId);

}
