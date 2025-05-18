package com.gl.ceir.config.model.audit;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author maverick
 */
@Entity
public class ModulesAuditTrail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int executionTime;
    private int statusCode;
    private String status;
    private String errorMessage;
    private String moduleName;
    private String featureName;
    private String info;
    private String serverName;
    private int failureCount;
    private int count;

    public ModulesAuditTrail(int statusCode, String status, String errorMessage, String moduleName, String featureName, String info, String serverName, int failureCount, int count) {
        this.statusCode = statusCode;
        this.status = status;
        this.errorMessage = errorMessage;
        this.moduleName = moduleName;
        this.featureName = featureName;
        this.info = info;
        this.serverName = serverName;
        this.failureCount = failureCount;
        this.count = count;
    }

    public ModulesAuditTrail() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public int getFailureCount() {
        return failureCount;
    }

    public void setFailureCount(int failureCount) {
        this.failureCount = failureCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ModulesAuditTrail{" + "id=" + id + ", executionTime=" + executionTime + ", statusCode=" + statusCode + ", status=" + status + ", errorMessage=" + errorMessage + ", moduleName=" + moduleName + ", featureName=" + featureName + ", info=" + info + ", serverName=" + serverName + ", failureCount=" + failureCount + ", count=" + count + '}';
    }

}
