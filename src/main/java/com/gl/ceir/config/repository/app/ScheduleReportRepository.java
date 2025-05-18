package com.gl.ceir.config.repository.app;

import com.gl.ceir.config.model.app.ScheduleReportDb;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




//@Repository
//public interface ScheduleReportRepository extends JpaRepository<ScheduleReportDb, Long> {
//    public Page<ScheduleReportDb> findAll(Specification<ScheduleReportDb> build, Pageable pageable);
//}

 
@Repository
public interface ScheduleReportRepository extends JpaRepository<ScheduleReportDb, Long>{
	Page<ScheduleReportDb> findAll(Specification<ScheduleReportDb> joins, Pageable pageable);
}
