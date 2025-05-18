package com.gl.ceir.config.repository.app;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.gl.ceir.config.model.app.StatesInterpretationDb;

@Repository
public interface StatesInterpretaionRepository extends JpaRepository<StatesInterpretationDb, Long>, JpaSpecificationExecutor<StatesInterpretationDb> {

	public List<StatesInterpretationDb> findByFeatureId(Integer featureId);
	
	public StatesInterpretationDb findByFeatureIdAndState(Integer featureId, int state);

}
