package com.gl.ceir.config.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.ceir.config.exceptions.ResourceNotFoundException;
import com.gl.ceir.config.exceptions.ResourceServicesException;

import com.gl.ceir.config.model.app.FilterRequest;
import com.gl.ceir.config.model.app.ScheduleReportDb;
import com.gl.ceir.config.repository.app.ScheduleReportRepository;
import com.gl.ceir.config.service.ScheduleReportService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.gl.ceir.config.specificationsbuilder.GenericSpecificationBuilder;
import com.gl.ceir.config.configuration.PropertiesReader;
import com.gl.ceir.config.configuration.SortDirection;
import com.gl.ceir.config.model.app.SearchCriteria;
import com.gl.ceir.config.model.constants.Datatype;
import com.gl.ceir.config.model.constants.SearchOperation;
import java.util.Objects;

@Service
public class ScheduleReportControllerImpl implements ScheduleReportService {

    @Autowired
    private ScheduleReportRepository scheduleReportRepository;

//    buildSpecification
    @Autowired
    PropertiesReader propertiesReader;
    private static final Logger logger = LogManager.getLogger(ScheduleReportControllerImpl.class);

    @Override
    public List<ScheduleReportDb> getAll() {
        try {
            return scheduleReportRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ResourceServicesException("ScheduleReportControllerImpl", e.getMessage());
        }

    }

    @Override
    public ScheduleReportDb save(ScheduleReportDb action) {
        try {
            return scheduleReportRepository.save(action);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ResourceServicesException("ScheduleReportControllerImpl", e.getMessage());
        }

    }

    @Override
    public ScheduleReportDb get(Long id) {
        try {
            ScheduleReportDb action = scheduleReportRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Action", "id", id));
            return action;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ResourceServicesException("ActionServiceImpl", e.getMessage());
        }
    }

    @Override
    public ScheduleReportDb update(ScheduleReportDb action) {
        try {
            ScheduleReportDb srd = get(action.getId());
            action.setAction(srd.getAction());
            action.setCategory(srd.getCategory());
            action.setCreatedOn(srd.getCreatedOn());
            action.setModifiedOn(srd.getModifiedOn());
            action.setReportName(srd.getReportName());
            return scheduleReportRepository.save(action);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ResourceServicesException("ScheduleReportControllerImpl", e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            scheduleReportRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ResourceServicesException("ScheduleReportControllerImpl", e.getMessage());
        }
    }

    public Page<ScheduleReportDb> filterRuleEngineMapping(FilterRequest filterRequest, Integer pageNo, Integer pageSize, String operation) {
        try {

            String orderColumn = "0".equalsIgnoreCase(filterRequest.getColumnName()) ? "createdOn"
                    : "2".equalsIgnoreCase(filterRequest.getColumnName()) ? "category"
                    : "3".equalsIgnoreCase(filterRequest.getColumnName()) ? "reportName"
                    : "4".equalsIgnoreCase(filterRequest.getColumnName()) ? "EmailId"
                    : "5".equalsIgnoreCase(filterRequest.getColumnName()) ? "Action"
                    : "6".equalsIgnoreCase(filterRequest.getColumnName()) ? "flag"
                    : "7".equalsIgnoreCase(filterRequest.getColumnName()) ? "REPORT_ID" : "modifiedOn";

            Sort.Direction direction;
            if ("modifiedOn".equalsIgnoreCase(orderColumn)) {
                direction = Sort.Direction.DESC;
            } else {
                direction = SortDirection.getSortDirection(filterRequest.getSort());
            }

            //	Pageable pageable = PageRequest.of(pageNo, pageSize,  new SortDirection() );
            Pageable pageable = null;
            Page<ScheduleReportDb> page = scheduleReportRepository.findAll(buildSpecification(filterRequest).build(), pageable);
//			String operationType= "view".equalsIgnoreCase(operation) ? SubFeatures.VIEW_ALL : SubFeatures.EXPORT;
//			auditTrailRepository.save( new AuditTrail( Long.valueOf(filterRequest.getUserId()),
//					filterRequest.getUserName(), Long.valueOf(filterRequest.getUserTypeId()),
//					"SystemAdmin", Long.valueOf(filterRequest.getFeatureId()),
//					Features.RULE_FEATURE_MAPPING, operationType, "","NA",
//					filterRequest.getRoleType()));

            return page;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ResourceServicesException(this.getClass().getName(), e.getMessage());
        }
    }

    GenericSpecificationBuilder<ScheduleReportDb> buildSpecification(FilterRequest filterRequest) {
        GenericSpecificationBuilder<ScheduleReportDb> cmsb = new GenericSpecificationBuilder<>(propertiesReader.dialect);
        if (Objects.nonNull(filterRequest.getCategory())) {
            cmsb.with(new SearchCriteria("category", filterRequest.getCategory(), SearchOperation.EQUALITY, Datatype.STRING));
        }
        if (Objects.nonNull(filterRequest.getFlag())) {
            cmsb.with(new SearchCriteria("flag", filterRequest.getFlag(), SearchOperation.EQUALITY, Datatype.STRING));
        }

        if (Objects.nonNull(filterRequest.getCreatedOn())) {
            cmsb.with(new SearchCriteria("createdOn", filterRequest.getCreatedOn(), SearchOperation.EQUALITY, Datatype.DATE));
        }
        if (Objects.nonNull(filterRequest.getModifiedOn())) {
            cmsb.with(new SearchCriteria("modifiedOn", filterRequest.getModifiedOn(), SearchOperation.EQUALITY, Datatype.DATE));
        }
        if (Objects.nonNull(filterRequest.getReportName())) {
            cmsb.with(new SearchCriteria("reportName", filterRequest.getReportName(), SearchOperation.EQUALITY, Datatype.INT));
        }

        if (Objects.nonNull(filterRequest.getSearchString()) && !filterRequest.getSearchString().isEmpty()) {
            cmsb.orSearch(new SearchCriteria("flag", filterRequest.getSearchString(), SearchOperation.LIKE, Datatype.STRING));
            cmsb.orSearch(new SearchCriteria("category", filterRequest.getSearchString(), SearchOperation.LIKE, Datatype.STRING));
            cmsb.orSearch(new SearchCriteria("createdOn", filterRequest.getSearchString(), SearchOperation.LIKE, Datatype.DATE));
            cmsb.orSearch(new SearchCriteria("modifiedOn", filterRequest.getSearchString(), SearchOperation.LIKE, Datatype.DATE));
            cmsb.orSearch(new SearchCriteria("reportName", filterRequest.getSearchString(), SearchOperation.LIKE, Datatype.INT));
        }
        return cmsb;
    }

}
