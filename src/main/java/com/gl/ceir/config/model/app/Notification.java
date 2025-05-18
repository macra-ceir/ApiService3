package com.gl.ceir.config.model.app;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity

@DynamicInsert
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @CreationTimestamp
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
//    private LocalDateTime createdOn;

//    @CreationTimestamp
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
//    private LocalDateTime modifiedOn;

    // @ColumnDefault(value = "")
    private String channelType;

    // @ColumnDefault(value = "")
    private String message;

    // @ColumnDefault(value = "0")
    private Long userId;

    // @ColumnDefault(value = "0")
    private Long featureId;

    // @ColumnDefault(value = "")
    private String featureTxnId;

    // @ColumnDefault(value = "")
    private String featureName;

    // @ColumnDefault(value = "")
    private String subFeature;

    // @ColumnDefault(value = "0")
    private Integer status;

    // @ColumnDefault(value = "")
    private String subject;

    // @ColumnDefault(value = "0")
    private Integer retryCount;

    // @ColumnDefault(value = "")
    private String referTable;

    // @ColumnDefault(value = "")
    private String roleType;

    // @ColumnDefault(value = "")
    private String receiverUserType;

    // @ColumnDefault(value = "")
    private String email;

    // @ColumnDefault(value = "")
    private String msisdn;

    // @ColumnDefault(value = "")
    private String operatorName;

//    private LocalDateTime notificationSentTime;

    // @ColumnDefault(value = "")
    private String corelationId;

    // @ColumnDefault(value = "")
    private String msgLang;

    // @ColumnDefault(value = "")
    private String deliveryStatus;

//    private LocalDateTime deliveryTime;

    // @ColumnDefault(value = "")
    private String sendSmsInterface;

    private Integer checkImeiId;

    public Notification(String channelType, String message, String featureName, Integer status, Integer retryCount, String msisdn, String operatorName, String msgLang, Integer checkImeiId) {
        this.channelType = channelType;
        this.message = message;
        this.featureName = featureName;
        this.status = status;
        this.retryCount = retryCount;
        this.msisdn = msisdn;
        this.operatorName = operatorName;
        this.msgLang = msgLang;
        this.checkImeiId = checkImeiId;
    }

    public Notification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  
    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Long featureId) {
        this.featureId = featureId;
    }

    public String getFeatureTxnId() {
        return featureTxnId;
    }

    public void setFeatureTxnId(String featureTxnId) {
        this.featureTxnId = featureTxnId;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getSubFeature() {
        return subFeature;
    }

    public void setSubFeature(String subFeature) {
        this.subFeature = subFeature;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public String getReferTable() {
        return referTable;
    }

    public void setReferTable(String referTable) {
        this.referTable = referTable;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getReceiverUserType() {
        return receiverUserType;
    }

    public void setReceiverUserType(String receiverUserType) {
        this.receiverUserType = receiverUserType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

  

    public String getCorelationId() {
        return corelationId;
    }

    public void setCorelationId(String corelationId) {
        this.corelationId = corelationId;
    }

    public String getMsgLang() {
        return msgLang;
    }

    public void setMsgLang(String msgLang) {
        this.msgLang = msgLang;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

  

    public String getSendSmsInterface() {
        return sendSmsInterface;
    }

    public void setSendSmsInterface(String sendSmsInterface) {
        this.sendSmsInterface = sendSmsInterface;
    }

    public Integer getCheckImeiId() {
        return checkImeiId;
    }

    public void setCheckImeiId(Integer checkImeiId) {
        this.checkImeiId = checkImeiId;
    }

    @Override
    public String toString() {
        return "Notification{" + "id=" + id + ", channelType=" + channelType + ", message=" + message + ", userId=" + userId + ", featureId=" + featureId + ", featureTxnId=" + featureTxnId + ", featureName=" + featureName + ", subFeature=" + subFeature + ", status=" + status + ", subject=" + subject + ", retryCount=" + retryCount + ", referTable=" + referTable + ", roleType=" + roleType + ", receiverUserType=" + receiverUserType + ", email=" + email + ", msisdn=" + msisdn + ", operatorName=" + operatorName + ", corelationId=" + corelationId + ", msgLang=" + msgLang + ", deliveryStatus=" + deliveryStatus + ", sendSmsInterface=" + sendSmsInterface + ", checkImeiId=" + checkImeiId + '}';
    }

    
}
