package com.gl.ceir.config.model.app;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gl.ceir.config.model.constants.Period;

import io.swagger.annotations.ApiModel;

@ApiModel
@Entity
public class DeviceSnapShot implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long imei;

	// @ManyToOne
	private String mobileOperator;

	private int lastpPolicyBreached;
	private Date lastpPolicyBreachedDate;
	private Period period;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date createdOn;
	private String remarks;
	private int duplicateCount;
	private boolean taxPaid;
	private boolean foreginRule;
	private boolean globalBlacklist;
	private boolean validImport;
	private boolean pending;

	@OneToMany(mappedBy = "deviceSnapShot", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<DuplicateImeiMsisdn> duplicateImeiMsisdns;

	public Long getImei() {
		return imei;
	}

	public void setImei(Long imei) {
		this.imei = imei;
	}

	public String getMobileOperator() {
		return mobileOperator;
	}

	public void setMobileOperator(String mobileOperator) {
		this.mobileOperator = mobileOperator;
	}

	public int getLastpPolicyBreached() {
		return lastpPolicyBreached;
	}

	public void setLastpPolicyBreached(int lastpPolicyBreached) {
		this.lastpPolicyBreached = lastpPolicyBreached;
	}

	public Date getLastpPolicyBreachedDate() {
		return lastpPolicyBreachedDate;
	}

	public void setLastpPolicyBreachedDate(Date lastpPolicyBreachedDate) {
		this.lastpPolicyBreachedDate = lastpPolicyBreachedDate;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getDuplicateCount() {
		return duplicateCount;
	}

	public void setDuplicateCount(int duplicateCount) {
		this.duplicateCount = duplicateCount;
	}

	public boolean isTaxPaid() {
		return taxPaid;
	}

	public void setTaxPaid(boolean taxPaid) {
		this.taxPaid = taxPaid;
	}

	public boolean isForeginRule() {
		return foreginRule;
	}

	public void setForeginRule(boolean foreginRule) {
		this.foreginRule = foreginRule;
	}

	public boolean isGlobalBlacklist() {
		return globalBlacklist;
	}

	public void setGlobalBlacklist(boolean globalBlacklist) {
		this.globalBlacklist = globalBlacklist;
	}

	public boolean isValidImport() {
		return validImport;
	}

	public void setValidImport(boolean validImport) {
		this.validImport = validImport;
	}

	public List<DuplicateImeiMsisdn> getDuplicateImeiMsisdns() {
		return duplicateImeiMsisdns;
	}

	public void setDuplicateImeiMsisdns(List<DuplicateImeiMsisdn> duplicateImeiMsisdns) {
		this.duplicateImeiMsisdns = duplicateImeiMsisdns;
	}

	public boolean isPending() {
		return pending;
	}

	public void setPending(boolean pending) {
		this.pending = pending;
	}

}
