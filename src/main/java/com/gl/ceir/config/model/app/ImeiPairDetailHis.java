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

public class ImeiPairDetailHis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int allowedDays;

    private String
            imei,
            imsi,
            msisdn,
            fileName,
            gsmaStatus,
            pairMode,
            operator,
            action,actionRemark;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime pairingDate, recordTime, expiryDate;


    public ImeiPairDetailHis(int allowedDays, String imei, String imsi, String msisdn, String fileName, String gsmaStatus, String pairMode, String operator, String action, LocalDateTime pairingDate, LocalDateTime recordTime, LocalDateTime expiryDate,String actionRemark) {
        this.allowedDays = allowedDays;
        this.imei = imei;
        this.imsi = imsi;
        this.msisdn = msisdn;
        this.fileName = fileName;
        this.gsmaStatus = gsmaStatus;
        this.pairMode = pairMode;
        this.operator = operator;
        this.action = action;
        this.pairingDate = pairingDate;
        this.recordTime = recordTime;
        this.expiryDate = expiryDate;
        this.actionRemark =actionRemark;
    }
}
