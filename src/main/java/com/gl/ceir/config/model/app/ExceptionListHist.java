package com.gl.ceir.config.model.app;

import com.fasterxml.jackson.annotation.JsonFormat;
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

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class ExceptionListHist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String complaintType,
            imei,
            modeType,
            requestType,
            txnId,
            userId,
            userType,
            operatorId,
            operatorName,
            actualImei,
            tac,
            remarks,
            imsi,
            msisdn,
            source,actionRemark;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expiryDate;

    public ExceptionListHist(String complaintType, String imei, String modeType, String requestType, String txnId, String userId, String userType, String operatorId, String operatorName, String actualImei, String tac, String remarks, String imsi, String msisdn, String source, LocalDateTime expiryDate,String actionRemark) {
        this.complaintType = complaintType;
        this.imei = imei;
        this.modeType = modeType;
        this.requestType = requestType;
        this.txnId = txnId;
        this.userId = userId;
        this.userType = userType;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.actualImei = actualImei;
        this.tac = tac;
        this.remarks = remarks;
        this.imsi = imsi;
        this.msisdn = msisdn;
        this.source = source;
        this.expiryDate = expiryDate;
        this.actionRemark =actionRemark;
    }
}
