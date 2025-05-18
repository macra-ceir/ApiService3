package com.gl.ceir.config.model.app;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@ApiModel
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlackList implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@JsonIgnore
//	@CreationTimestamp
//	private Date expiryDate;

//	@JsonIgnore//	@UpdateTimestamp //	private Date modifiedOn;

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
			userType;
}
