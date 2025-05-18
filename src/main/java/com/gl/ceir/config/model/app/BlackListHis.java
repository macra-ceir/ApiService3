package com.gl.ceir.config.model.app;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlackListHis implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@JsonIgnore
//	@CreationTimestamp
//	private Date expiryDate;

	String actualImei,
			complaintType,
			imei,
			imsi,
			modeType,
			msisdn,
			operatorId,
			operatorName,
			remarks,
			requestType,
			source,
			tac,
			txnId,
			userId,
			userType,actionRemark;

	public BlackListHis( String actualImei, String complaintType, String imei, String imsi, String modeType, String msisdn, String operatorId, String operatorName, String remarks, String requestType, String source, String tac, String txnId, String userId, String userType,String actionRemark) {
		this.actualImei = actualImei;
		this.complaintType = complaintType;
		this.imei = imei;
		this.imsi = imsi;
		this.modeType = modeType;
		this.msisdn = msisdn;
		this.operatorId = operatorId;
		this.operatorName = operatorName;
		this.remarks = remarks;
		this.requestType = requestType;
		this.source = source;
		this.tac = tac;
		this.txnId = txnId;
		this.userId = userId;
		this.userType = userType;
		this.actionRemark =actionRemark;
	}
}
