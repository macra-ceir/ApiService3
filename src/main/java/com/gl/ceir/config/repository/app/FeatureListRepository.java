package com.gl.ceir.config.repository.app;

import com.gl.ceir.config.model.app.FeatureSubmenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeatureListRepository extends JpaRepository<FeatureSubmenu, Long> {
    //JpaSpecificationExecutor<FeatureMenu>     , CrudRepository<FeatureMenu, Long>

    @Override
    List<FeatureSubmenu> findAll();

    List<FeatureSubmenu> findByFeatureMenuId(Long l);
}
