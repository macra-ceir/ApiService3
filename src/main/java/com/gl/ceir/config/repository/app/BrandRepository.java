package com.gl.ceir.config.repository.app;

import com.gl.ceir.config.model.app.DevBrandName;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<DevBrandName, Long>,
        JpaRepository<DevBrandName, Long>, JpaSpecificationExecutor<DevBrandName> {

    //    @Query("SELECT NEW com.gl.ceir.config.model.app.DevBrandName(id, brandName) FROM DevBrandName order by brandName= :brand1 desc,brandName= brand2 desc,brandName =brand3 desc,brandName =brand4 desc,brandName =brand5 desc,brandName asc ")
//    List<DevBrandName> findDistinctTagsWithDescription();

    // @Query(value = "select  khmer_name  from  label_mul_lingual_text where label = :label", nativeQuery = true)
  //  @Query(value = "SELECT NEW com.gl.ceir.config.model.app.DevBrandName(a.id, a.brandName) FROM DevBrandName a "
    //         + "order by a.brandName= :brand1 desc,a.brandName= :brand2 desc,a.brandName =:brand3 desc,a.brandName =:brand4 desc,a.brandName =:brand5 desc,a.brandName asc ")  //, nativeQuery = true

    @Query(value = "select id , brand_name from dev_brand_name order by brand_name=:brand1 desc,brand_name=:brand2 desc,brand_name =:brand3 desc,brand_name =:brand4 desc,brand_name =:brand5 desc,brand_name asc ", nativeQuery = true)
    public List<DevBrandName> getBrandNameWithTop5New(String brand1, String brand2, String brand3, String brand4, String brand5);
    //  public List<DevBrandName> getBrandNameWithTop5New1();

    
    
   @Query(value = "select id , brand_name from dev_brand_name ORDER BY CASE "
           + "WHEN brand_name = :brand1 THEN 1 "
           + "WHEN brand_name = :brand2 THEN 2 "
           + "WHEN brand_name = :brand3 THEN 3 "
          + "WHEN brand_name = :brand4 THEN 4 "
          + "WHEN brand_name = :brand5 THEN 5 "
           + "ELSE 6    END , brand_name ASC  ", nativeQuery = true)
    public List<DevBrandName> getBrandNameWithTop5NewOracle(String brand1, String brand2, String brand3, String brand4, String brand5);
    
//    @Query("SELECT NEW com.gl.ceir.config.model.app.DevBrandName(id, brandName) FROM DevBrandName order by brandName= :brand1 desc,brandName= :brand2 desc,brandName =:brand3 desc,brandName =:brand4 desc,brandName =:brand5 desc,brandName asc ")
//    public List<DevBrandName> getBrandNameWithTop5(String brand1, String brand2, String brand3, String brand4, String brand5);
}
