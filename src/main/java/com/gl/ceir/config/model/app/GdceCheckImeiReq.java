package com.gl.ceir.config.model.app;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class GdceCheckImeiReq implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int failCount;

    private int successCount;

    private String status;

    private String remark;
    private String requestId;
    private int imeiCount;

    private String fileName;

    public GdceCheckImeiReq() {
    }


    public GdceCheckImeiReq(String status, String remark, String requestId, int imeiCount) {
        this.status = status;
        this.remark = remark;
        this.requestId = requestId;
        this.imeiCount = imeiCount;
    }

    public GdceCheckImeiReq(String status, String remark, String requestId, int imeiCount, String fileName) {
        this.status = status;
        this.remark = remark;
        this.requestId = requestId;
        this.imeiCount = imeiCount;
        this.fileName = fileName;
    }






    public GdceCheckImeiReq(String status, String remark) {
        this.status = status;
        this.remark = remark;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getImeiCount() {
        return imeiCount;
    }

    public void setImeiCount(int imeiCount) {
        this.imeiCount = imeiCount;
    }

    public int getFailCount() {
        return failCount;
    }

    public void setFailCount(int failCount) {
        this.failCount = failCount;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public String toString() {
        return "GdceCheckImeiReq{" +
                "id=" + id +
                ", failCount=" + failCount +
                ", successCount=" + successCount +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", requestId='" + requestId + '\'' +
                ", imeiCount=" + imeiCount +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
