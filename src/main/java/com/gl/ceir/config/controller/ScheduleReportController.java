/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gl.ceir.config.controller;

import com.gl.ceir.config.model.app.CheckImeiMess;
import com.gl.ceir.config.model.app.FilterRequest;
import com.gl.ceir.config.model.app.ReportDb;
import com.gl.ceir.config.model.app.ScheduleReportDb;
import com.gl.ceir.config.repository.app.ScheduleReportRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RestController;
import com.gl.ceir.config.service.ScheduleReportService;
import com.gl.ceir.config.service.impl.ScheduleReportControllerImpl;
//import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.persistence.criteria.Join;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author maverick
 */
@RestController

public class ScheduleReportController {

    private static final Logger logger = LogManager.getLogger(ScheduleReportController.class);

    @Autowired
    ScheduleReportControllerImpl scheduleReportControllerImpl;
    @Autowired
    private ScheduleReportRepository scheduleReportRepository;
    
    @Autowired
    private ScheduleReportDb scheduleReportDb;
    
     

//    @Autowired
//    ScheduleReportService ScheduleReportService;
    //@ApiOperation(value = "View All witout Pagenation  ", response = ScheduleReportDb.class, responseContainer = "list")
    @RequestMapping(path = "/ScheduleReport/getAllValues", method = RequestMethod.GET)
    public MappingJacksonValue getAll() {
        List<ScheduleReportDb> allActions = scheduleReportControllerImpl.getAll();
//		List<ScheduleReportDb> allActions = ScheduleReportService.getAll();      it was early
        MappingJacksonValue mapping = new MappingJacksonValue(allActions);
        return mapping;
    }

    @RequestMapping(path = "/ScheduleReport/{id}", method = RequestMethod.GET)
    public MappingJacksonValue get(@PathVariable(value = "id") Long id) {
//		ScheduleReportDb action = actionService.get(id);
        ScheduleReportDb action = scheduleReportControllerImpl.get(id);
        MappingJacksonValue mapping = new MappingJacksonValue(action);
        return mapping;
    }

    @RequestMapping(path = "/ScheduleReport/", method = RequestMethod.POST)
    public MappingJacksonValue save(@RequestBody ScheduleReportDb action) {
        ScheduleReportDb savedAction = scheduleReportControllerImpl.save(action);
        MappingJacksonValue mapping = new MappingJacksonValue(savedAction);
        return mapping;
    }

    @RequestMapping(path = "/ScheduleReport/{id}", method = RequestMethod.DELETE)
    public MappingJacksonValue delete(@PathVariable(value = "id") Long id) {
        scheduleReportControllerImpl.delete(id);
        CheckImeiMess cImsg = new CheckImeiMess();
        cImsg.setStatus("true");
        MappingJacksonValue mapping = new MappingJacksonValue(cImsg);
        return mapping;
    }

    @RequestMapping(path = "/ScheduleReport/", method = RequestMethod.PUT)
    public MappingJacksonValue update(@RequestBody ScheduleReportDb action) {
        ScheduleReportDb updatedAction = scheduleReportControllerImpl.update(action);
        MappingJacksonValue mapping = new MappingJacksonValue(updatedAction);
        return mapping;
    }

    
    
    
    //@ApiOperation(value = "  View  By Pagination  ", response = ScheduleReportDb.class)
    @PostMapping("/ScheduleReport/getAll")
    public MappingJacksonValue getFilteredData(
            @RequestBody FilterRequest filterRequest,
            @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "file", defaultValue = "0") Integer file) {
        MappingJacksonValue mapping = null;
        file = 0;    //  
        if (file == 0) {
            logger.info(" filterRequest view   = " + filterRequest.toString());
            Page<ScheduleReportDb> ruleEngineMapping = scheduleReportControllerImpl.filterRuleEngineMapping(filterRequest, pageNo, pageSize, "view");
            mapping = new MappingJacksonValue(ruleEngineMapping);
            logger.info("Response of view Request = " + mapping.toString());
        } else {
//			ScheduleReportDb fileDetails = scheduleReportControllerImpl.getFile(filterRequest);
//			mapping = new MappingJacksonValue(fileDetails);		
        }
        return mapping;
    }
    
    
    

    //@ApiOperation(value = "  Values  By Pagination  ", response = ScheduleReportDb.class)
    @PostMapping("/ScheduleReport/getAllValues")
    public MappingJacksonValue getFilteredDataValues(
            @RequestBody FilterRequest filterRequest,
            @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "file", defaultValue = "0") Integer file) {
          // new Sort(Sort.Direction.DESC, "modifiedOn") ;
        Pageable pageable = PageRequest.of(pageNo, pageSize,null );
        Page<ScheduleReportDb> page = scheduleReportRepository.findAll(joinWithUserProfile(scheduleReportDb.getId().intValue()), pageable);
        MappingJacksonValue mapping = new MappingJacksonValue(page);
        return mapping; 
    }

    public Specification<ScheduleReportDb> joinWithUserProfile(int num) {
        return (root, query, cb) -> {
            Join<ScheduleReportDb, ReportDb> addresses = root.join("reportDb".intern());
            return cb.equal(addresses.get("reportnameId"), num);

        };
    }

    
    
    
    
    
    
    
    
    
    
    
//    @GetMapping("/ScheduleReport/getValues")
//	public ResponseEntity<?> get() {
//		Pageable pageable = PageRequest.of(0, 10, new Sort(Sort.Direction.DESC, "modifiedOn"));
//		Page<ScheduleReportDb> page = scheduleReportRepository.findAll(joinWithUserProfile(1), pageable);
//		
//		return new ResponseEntity<>(page, HttpStatus.OK);
//	}
//
//	public Specification<ScheduleReportDb> joinWithUserProfile(int num) {
//		return (root, query, cb) -> {
//			
//			Join<ScheduleReportDb,ReportDb> addresses = root.join("reportDb".intern());	
//			return cb.equal(addresses.get("reportnameId"), num);
//			
//		};
//	}
}
