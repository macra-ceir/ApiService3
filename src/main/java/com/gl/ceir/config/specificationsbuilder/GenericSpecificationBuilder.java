/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gl.ceir.config.specificationsbuilder;

/**
 *
 * @author maverick
 */


 


 
import com.gl.ceir.config.model.app.FilterRequest;
import com.gl.ceir.config.model.app.ScheduleReportDb;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.gl.ceir.config.configuration.PropertiesReader;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.domain.Specification;

import com.gl.ceir.config.model.app.SearchCriteria;
import com.gl.ceir.config.model.constants.Datatype;
import com.gl.ceir.config.model.constants.SearchOperation;
import com.gl.ceir.config.util.DbFunctions;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericSpecificationBuilder<T> {
    
    @Autowired
    PropertiesReader      propertiesReader  ;
	private static final Logger logger = LogManager.getLogger(GenericSpecificationBuilder.class);

	private final List<SearchCriteria> params;
	private final List<SearchCriteria> orParams;
	private final List<SearchCriteria> searchParams;
	private final String dialect;
	private List<Specification<T>> specifications;

	public GenericSpecificationBuilder(String dialect) {
		params = new ArrayList<>();
		orParams = new ArrayList<>();
		searchParams = new ArrayList<>();
		specifications = new LinkedList<>();
		this.dialect = dialect;
	}

	public final GenericSpecificationBuilder<T> with(SearchCriteria criteria) { 
		params.add(criteria);
		return this;
	}

	public final GenericSpecificationBuilder<T> orSearch(SearchCriteria criteria) { 
		searchParams.add(criteria);
		return this;
	}
	
	public final GenericSpecificationBuilder<T> or(SearchCriteria criteria) { 
		orParams.add(criteria);
		return this;
	}

	public Specification<T> build() { 
		// convert each of SearchCriteria params to Specification and construct combined specification based on custom rules.
		int j = 0;
		Specification<T> finalSpecification   = null;
		Specification<T> searchSpecification  = null;
		Specification<T> orSpecification  = null;
		
		/** Specification added from addSpecification method**/
		if(!specifications.isEmpty()) {
			finalSpecification = Specification.where(specifications.get(0));
			for(int i = 1; i<specifications.size() ;i++) {
				finalSpecification = finalSpecification.and(specifications.get(i));
			}
		}
		/***If params list not empty***/
		specifications = createSpecifications( params );
		if(!specifications.isEmpty()) {
			if( finalSpecification != null ) {
				j = 0;
			}else {//If no call of addSpecification method
				j = 1;
				finalSpecification = Specification.where(specifications.get(0));
			}
			for(int i = j; i<specifications.size() ;i++) {
				finalSpecification = finalSpecification.and(specifications.get(i));
			}
		}
		/***If searchParams list not empty***/
		specifications = createSpecifications( searchParams );
		if( !specifications.isEmpty()) {
			searchSpecification = specifications.get(0);
			for(int i = 1; i<specifications.size() ;i++) {
				searchSpecification = searchSpecification.or(specifications.get(i));
			}
			if( finalSpecification != null ) {
				finalSpecification = finalSpecification.and( searchSpecification );
			}else {//If no call of addSpecification method
				finalSpecification = Specification.where(searchSpecification);
			}
		}
		
		/***If orParams list not empty***/
		specifications = createSpecifications( orParams );
		if( !specifications.isEmpty()) {
			orSpecification = specifications.get(0);
			for(int i = 1; i<specifications.size() ;i++) {
				orSpecification = orSpecification.or(specifications.get(i));
			}
			if( finalSpecification != null ) {
				finalSpecification = finalSpecification.or( orSpecification );
			}else {//If no call of addSpecification method and empty params 
				finalSpecification = Specification.where(orSpecification);
			}
		}
		
		return finalSpecification;
	}

	public void addSpecification(Specification<T> specification) { 
		specifications.add(specification);
	}

	private List<Specification<T>> createSpecifications( List<SearchCriteria> criterias){
		List<Specification<T>> specifications = new ArrayList<>();
		try {
			for(SearchCriteria searchCriteria : criterias) {
				specifications.add((root, query, cb)-> {
					// Path<Tuple> tuple = root.<Tuple>get(searchCriteria);
					if(SearchOperation.GREATER_THAN.equals(searchCriteria.getSearchOperation())
							&& Datatype.STRING.equals(searchCriteria.getDatatype())) {
						return cb.greaterThan(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
					}
					else if(SearchOperation.LESS_THAN.equals(searchCriteria.getSearchOperation())
							&& Datatype.STRING.equals(searchCriteria.getDatatype())) {
						return cb.lessThan(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
					}
					else if(SearchOperation.EQUALITY.equals(searchCriteria.getSearchOperation())
							&& Datatype.STRING.equals(searchCriteria.getDatatype())) {
						if( searchCriteria.getKey().contains("-")) {
							//logger.info("Search Criteria join key:["+searchCriteria.getKey()+"]");
							String[] key = (searchCriteria.getKey()).split("-");
							if( key.length == 2)
								return cb.equal(root.join(key[0]).get(key[1]).as( String.class ),
										searchCriteria.getValue().toString());
							else
								return cb.equal(root.join(key[0]).join(key[1]).get(key[2]).as( String.class ),
										searchCriteria.getValue().toString());
						}else {
							return cb.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
						}
					}
//					else if(SearchOperation.EQUALITY_CASE_INSENSITIVE.equals(searchCriteria.getSearchOperation())
					else if(SearchOperation.EQUALITY.equals(searchCriteria.getSearchOperation())
							&& Datatype.STRING.equals(searchCriteria.getDatatype())) {
						return cb.equal(cb.lower(root.get(searchCriteria.getKey())), searchCriteria.getValue().toString().toLowerCase());
					}
					else if(SearchOperation.EQUALITY.equals(searchCriteria.getSearchOperation())
							&& Datatype.INT.equals(searchCriteria.getDatatype())) {
						return cb.equal(root.get(searchCriteria.getKey()), (Integer)searchCriteria.getValue());
					}
					else if(SearchOperation.EQUALITY.equals(searchCriteria.getSearchOperation())
							&& Datatype.LONG.equals(searchCriteria.getDatatype())) {
						return cb.equal(root.get(searchCriteria.getKey()), (Long)searchCriteria.getValue());
					}
					else if(SearchOperation.GREATER_THAN.equals(searchCriteria.getSearchOperation())
							&& Datatype.DATE.equals(searchCriteria.getDatatype())){
						Expression<String> dateStringExpr = cb.function(DbFunctions.getDate(dialect), String.class, root.get(searchCriteria.getKey()), cb.literal(DbFunctions.getDateFormat(dialect)));
						return cb.greaterThanOrEqualTo(cb.lower(dateStringExpr), searchCriteria.getValue().toString());
					}
					else if(SearchOperation.LESS_THAN.equals(searchCriteria.getSearchOperation())
							&& Datatype.DATE.equals(searchCriteria.getDatatype())){
						Expression<String> dateStringExpr = cb.function(DbFunctions.getDate(dialect), String.class, root.get(searchCriteria.getKey()), cb.literal(DbFunctions.getDateFormat(dialect)));
						return cb.lessThanOrEqualTo(cb.lower(dateStringExpr), searchCriteria.getValue().toString());
					}
					else if(SearchOperation.NEGATION.equals(searchCriteria.getSearchOperation())
							&& Datatype.STRING.equals(searchCriteria.getDatatype())) {
						return cb.notEqual(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
					}
					else if(SearchOperation.NEGATION.equals(searchCriteria.getSearchOperation())
							&& Datatype.INT.equals(searchCriteria.getDatatype())) {
						return cb.notEqual(root.get(searchCriteria.getKey()), (Integer)searchCriteria.getValue());
					}else if(SearchOperation.NEGATION.equals(searchCriteria.getSearchOperation())
							&& Datatype.LONG.equals(searchCriteria.getDatatype())) {
						return cb.notEqual(root.get(searchCriteria.getKey()), (Long)searchCriteria.getValue());
					}else if(SearchOperation.LIKE.equals(searchCriteria.getSearchOperation())
							&& Datatype.STRING.equals(searchCriteria.getDatatype())) {
						if( searchCriteria.getKey().contains("-")) {
							//logger.info("Search Criteria join key:["+searchCriteria.getKey()+"]");
							String[] key = (searchCriteria.getKey()).split("-");
							if( key.length == 2)
								return cb.like(cb.lower(root.join(key[0]).get(key[1]).as( String.class )),
										"%"+((String)searchCriteria.getValue()).toLowerCase()+"%");
							else
								return cb.like(cb.lower(root.join(key[0]).join(key[1]).get(key[2]).as( String.class )),
										"%"+((String)searchCriteria.getValue()).toLowerCase()+"%");
						}else {
							return cb.like(cb.lower(root.get(searchCriteria.getKey()).as( String.class )), "%"+((String)searchCriteria.getValue()).toLowerCase()+"%");
						}
					}else {
						return null;
					}
				});
			}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return specifications;
	}

	public Specification<T> in(String key, List<Integer> status){
		return (root, query, cb) ->  cb.in(root.get(key)).value(status);
	}

	public Specification<T> notIn(String key, List<String> status){
		return (root, query, cb) -> cb.in(root.get(key)).value(status).not();
	}
	
	
//	public Specification<ConsignmentMgmt> joinWithMultiple(SearchCriteria searchCriteria){
//		return (root, query, cb) -> {
//		Join<ConsignmentMgmt, User> join_User = root.join("user".intern());
//		Join<User, UserProfile> join_UserProfile = join_User.join("userProfile".intern());
//		return cb.equal(join_UserProfile.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
//		};
//		}
        
        
    
//    public GenericSpecificationBuilder<ScheduleReportDb> buildSpecification(FilterRequest filterRequest){
//		GenericSpecificationBuilder<ScheduleReportDb> cmsb = new GenericSpecificationBuilder<>(propertiesReader.dialect);
//
//		if(Objects.nonNull(filterRequest.getRuleName()))
//			cmsb.with(new SearchCriteria("name", filterRequest.getRuleName(), SearchOperation.EQUALITY, Datatype.STRING));
//
//		if(Objects.nonNull(filterRequest.getFeatureName()))
//			cmsb.with(new SearchCriteria("feature", filterRequest.getFeatureName(), SearchOperation.EQUALITY, Datatype.STRING));
//
//		if(Objects.nonNull(filterRequest.getUserType()))
//			cmsb.with(new SearchCriteria("userType", filterRequest.getUserType(), SearchOperation.EQUALITY, Datatype.STRING));
//
//
//		if(Objects.nonNull(filterRequest.getSearchString()) && !filterRequest.getSearchString().isEmpty()){
//			cmsb.orSearch(new SearchCriteria("ruleOrder", filterRequest.getSearchString(), SearchOperation.LIKE, Datatype.STRING));	
//			cmsb.orSearch(new SearchCriteria("name", filterRequest.getSearchString(), SearchOperation.LIKE, Datatype.STRING));
//			cmsb.orSearch(new SearchCriteria("feature", filterRequest.getSearchString(), SearchOperation.LIKE, Datatype.STRING));	
//			cmsb.orSearch(new SearchCriteria("userType", filterRequest.getSearchString(), SearchOperation.LIKE, Datatype.STRING));
//
//		}
//		return cmsb;
//	}

        
        
        
        
        
        
        
        
}
