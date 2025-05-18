package com.gl.ceir.config.specificationsbuilder;

import com.gl.ceir.config.model.app.ReportDb;
import com.gl.ceir.config.model.app.ScheduleReportDb;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.Expression;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.domain.Specification;

import com.gl.ceir.config.model.app.SearchCriteria;
import com.gl.ceir.config.model.constants.Datatype;
import com.gl.ceir.config.model.constants.SearchOperation;
import com.gl.ceir.config.util.DbFunctions;
import javax.persistence.criteria.Join;

public class SpecificationBuilder<T> {

	private static final Logger logger = LogManager.getLogger(SpecificationBuilder.class);

	private final List<SearchCriteria> params;
	private final List<SearchCriteria> searchParams;
	private final String dialect;
	private List<Specification<T>> specifications;

	public SpecificationBuilder(String dialect) {
		params = new ArrayList<>();
		searchParams = new ArrayList<>();
		specifications = new LinkedList<>();
		this.dialect = dialect;
	}

	public final SpecificationBuilder<T> with(SearchCriteria criteria) { 
		params.add(criteria);
		return this;
	}

	public final SpecificationBuilder<T> orSearch(SearchCriteria criteria) { 
		searchParams.add(criteria);
		return this;
	}

	public Specification<T> build() { 
		// convert each of SearchCriteria params to Specification and construct combined specification based on custom rules.

		Specification<T> finalSpecification = null;

		Specification<T> searchSpecification  = null;
		List<Specification<T>> specifications = createSpecifications( params );

		if(!specifications.isEmpty()) {
			finalSpecification = Specification.where(specifications.get(0));

			for(int i = 1; i<specifications.size(); i++) {
				finalSpecification = finalSpecification.and(specifications.get(i));
			}
		}

		if( !searchParams.isEmpty() ) {
			specifications = createSpecifications( searchParams );
			if( !specifications.isEmpty()) {
				
				searchSpecification = specifications.get(0);
				for(int i = 1; i<specifications.size() ;i++) {
					searchSpecification = searchSpecification.or(specifications.get(i));
				}
				
				finalSpecification = finalSpecification.and( searchSpecification );
			}
		}

		return finalSpecification;
	}

	public void addSpecification(Specification<T> specification) { 
		specifications.add(specification);
	}

	private List<Specification<T>> createSpecifications(List<SearchCriteria> criterias){

		try {
			for(SearchCriteria searchCriteria : params) {
				specifications.add((root, query, cb)-> {
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
						return cb.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
					}
					else if(SearchOperation.GREATER_THAN.equals(searchCriteria.getSearchOperation())
							&& Datatype.DATE.equals(searchCriteria.getDatatype())){
						Expression<String> dateStringExpr = cb.function(DbFunctions.getDate(dialect), String.class, root.get(searchCriteria.getKey()), cb.literal(DbFunctions.getDateFormat(dialect)));
						return cb.greaterThan(cb.lower(dateStringExpr), searchCriteria.getValue().toString());
					}
					else if(SearchOperation.LESS_THAN.equals(searchCriteria.getSearchOperation())
							&& Datatype.DATE.equals(searchCriteria.getDatatype())){
						Expression<String> dateStringExpr = cb.function(DbFunctions.getDate(dialect), String.class, root.get(searchCriteria.getKey()), cb.literal(DbFunctions.getDateFormat(dialect)));
						return cb.lessThan(cb.lower(dateStringExpr), searchCriteria.getValue().toString());
					}
					
					else if(SearchOperation.EQUALITY.equals(searchCriteria.getSearchOperation())
							&& Datatype.DATE.equals(searchCriteria.getDatatype())){
						Expression<String> dateStringExpr = cb.function(DbFunctions.getDate(dialect), String.class, root.get(searchCriteria.getKey()), cb.literal(DbFunctions.getDateFormat(dialect)));
						return cb.equal(cb.lower(dateStringExpr), searchCriteria.getValue().toString());
					}
					
					else {
						return null;
					}
				});
			}
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
		}

		return specifications;
	}

	public Specification<T> in(String key, List<Integer> status){
		return (root, query, cb) -> {
			logger.info("In query save ");
			return cb.in(root.get(key)).value(status);
		};
	}

        public Specification<ScheduleReportDb> joinWithUserType(SearchCriteria searchCriteria){
		logger.info("inside join with usertype and data is: "+searchCriteria);
		return (root, query, cb) -> { 
			Join<ScheduleReportDb, ReportDb> user = root.join("usertype".intern());
			if(SearchOperation.GREATER_THAN.equals(searchCriteria.getSearchOperation())
					&& Datatype.STRING.equals(searchCriteria.getDatatype())) {
				return cb.greaterThan(user.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
			}
			else if(SearchOperation.LESS_THAN.equals(searchCriteria.getSearchOperation())
					&& Datatype.STRING.equals(searchCriteria.getDatatype())) {
				return cb.lessThan(user.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
			}
			else if(SearchOperation.EQUALITY.equals(searchCriteria.getSearchOperation())
					&& Datatype.STRING.equals(searchCriteria.getDatatype())) {
				return cb.equal(user.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
			}
			else if(SearchOperation.EQUALITY.equals(searchCriteria.getSearchOperation())
					&& Datatype.INT.equals(searchCriteria.getDatatype())) {
				return cb.equal(user.get(searchCriteria.getKey()), (int)searchCriteria.getValue());
			} 
			else if(SearchOperation.EQUALITY.equals(searchCriteria.getSearchOperation())
					&& Datatype.INT.equals(searchCriteria.getDatatype())) {
				return cb.equal(user.get(searchCriteria.getKey()),searchCriteria.getValue());
			} 
			else if(SearchOperation.EQUALITY.equals(searchCriteria.getSearchOperation())
					&& Datatype.LONG.equals(searchCriteria.getDatatype())) {
				return cb.equal(user.get(searchCriteria.getKey()), (Long)searchCriteria.getValue());
			}
			else if(SearchOperation.GREATER_THAN.equals(searchCriteria.getSearchOperation())
					&& Datatype.DATE.equals(searchCriteria.getDatatype())){
				Expression<String> dateStringExpr = cb.function(DbFunctions.getDate(dialect), String.class, user.get(searchCriteria.getKey()), cb.literal(DbFunctions.getDateFormat(dialect)));
				return cb.greaterThanOrEqualTo(cb.lower(dateStringExpr), searchCriteria.getValue().toString());
			}
			else if(SearchOperation.LESS_THAN.equals(searchCriteria.getSearchOperation())
					&& Datatype.DATE.equals(searchCriteria.getDatatype())){
				Expression<String> dateStringExpr = cb.function(DbFunctions.getDate(dialect), String.class, user.get(searchCriteria.getKey()), cb.literal(DbFunctions.getDateFormat(dialect)));
				return cb.lessThanOrEqualTo(cb.lower(dateStringExpr), searchCriteria.getValue().toString());
			}
			else if(SearchOperation.NEGATION.equals(searchCriteria.getSearchOperation())
					&& Datatype.STRING.equals(searchCriteria.getDatatype())) {
				return cb.notEqual(user.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
			}
			else if(SearchOperation.NEGATION.equals(searchCriteria.getSearchOperation())
					&& Datatype.INT.equals(searchCriteria.getDatatype())) {
				return cb.notEqual(user.get(searchCriteria.getKey()), (Integer)searchCriteria.getValue());
			}else if(SearchOperation.NEGATION.equals(searchCriteria.getSearchOperation())
					&& Datatype.LONG.equals(searchCriteria.getDatatype())) {
				return cb.notEqual(user.get(searchCriteria.getKey()), (Long)searchCriteria.getValue());
			}else {
				return null;
			}

		};
	}
        
        
}
