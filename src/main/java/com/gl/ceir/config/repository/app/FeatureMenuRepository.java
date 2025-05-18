package com.gl.ceir.config.repository.app;

import com.gl.ceir.config.model.app.FeatureMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeatureMenuRepository extends JpaRepository<FeatureMenu, Long> {
    //JpaSpecificationExecutor<FeatureMenu>     , CrudRepository<FeatureMenu, Long>
    @Override
    public List<FeatureMenu> findAll();

}
