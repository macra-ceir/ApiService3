package com.gl.ceir.config.repository.app;

import com.gl.ceir.config.model.app.RuleEngineMapping;
import org.springframework.data.jpa.repository.JpaRepository;
 
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 

@Repository
public interface RulesRepository  extends JpaRepository<RuleEngineMapping, Long>  {
 
  @Query(value="select distinct feature from  RuleEngineMapping ")
    public List<String> findDistinctFeature();
    
    
    
//    @Query(value="select distinct feature from  rule_engine_mapping ")
//    List<String> findNonReferencedFeature();
  
     


}