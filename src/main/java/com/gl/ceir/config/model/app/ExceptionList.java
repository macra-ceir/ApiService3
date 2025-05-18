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

public class ExceptionList implements Serializable {
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
            source;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expiryDate;


}
