package com.gl.ceir.config.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gl.ceir.config.model.app.LanguageLabelDb;
import org.springframework.data.jpa.repository.Query;

public interface LanguageLabelDbRepository extends JpaRepository<LanguageLabelDb, Long>, JpaSpecificationExecutor<LanguageLabelDb> {

    @Query(value = "select JSON_OBJECTAGG(label, english_name) as labelDetails from label_mul_lingual_text where feature_name = :featureName", nativeQuery = true)
    public String getEnglishNameAndLabelFromFeatureName(String featureName);

    @Query(value = "select JSON_OBJECTAGG(label, khmer_name)   as labelDetails from label_mul_lingual_text where feature_name = :featureName", nativeQuery = true)
    public String getKhmerNameAndLabelFromFeatureName(String featureName);

    @Query(value = "select  khmer_name  from  label_mul_lingual_text where label = :label", nativeQuery = true)
    public String getKhmerNameFromLabel(String label);

    @Query(value = "select  english_name  from  label_mul_lingual_text where label = :label", nativeQuery = true)
    public String getEnglishNameFromLabel(String label);

}

/* 6:04    working labelDetails
public interface LanguageLabelDbRepository extends JpaRepository<LanguageLabelDb, Long>, JpaSpecificationExecutor<LanguageLabelDb> {

    @Query(value = "select  label ,english_name , khmer_name  from language_label_db where feature_name = ?1 ", nativeQuery = true)
    public List<LanguageLabelDb> getEnglishNameAndLabelFromFeatureName(String featureName);
    // make it String
}



 */
