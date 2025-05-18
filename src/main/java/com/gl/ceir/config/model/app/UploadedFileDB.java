package com.gl.ceir.config.model.app;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@Setter
@NoArgsConstructor

@DynamicInsert
@Table(name = "file_to_sync")

public class UploadedFileDB implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @ColumnDefault("''")
    String destServerName,destFilePath,sourceServerName, sourceFilePath, sourceFileName, appName, serverName, remarks,txnId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestServerName() {
        return destServerName;
    }

    public void setDestServerName(String destServerName) {
        this.destServerName = destServerName;
    }

    public String getDestFilePath() {
        return destFilePath;
    }

    public void setDestFilePath(String destFilePath) {
        this.destFilePath = destFilePath;
    }

    public String getSourceServerName() {
        return sourceServerName;
    }

    public void setSourceServerName(String sourceServerName) {
        this.sourceServerName = sourceServerName;
    }

    public String getSourceFilePath() {
        return sourceFilePath;
    }

    public void setSourceFilePath(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
    }

    public String getSourceFileName() {
        return sourceFileName;
    }

    public void setSourceFileName(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

}
