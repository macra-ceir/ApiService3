package com.gl.ceir.config.model.app;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import com.gl.ceir.config.model.constants.DocumentType;

import io.swagger.annotations.ApiModel;

@ApiModel
@Entity
public class Documents implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String filename;

	private String filepath;

	private String fileUri;

	private String fileType;

	private DocumentType documentType;

	private long size;

	private DocumentStatus status;

	private String approvedBy;

	private Date approvalDate;

	private String rejectedReason;

	@NotNull
	private Long imei;

	@NotNull
	private Long msisdn;

	private String ticketId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getFileUri() {
		return fileUri;
	}

	public void setFileUri(String fileUri) {
		this.fileUri = fileUri;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public DocumentStatus getStatus() {
		return status;
	}

	public void setStatus(DocumentStatus status) {
		this.status = status;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getRejectedReason() {
		return rejectedReason;
	}

	public void setRejectedReason(String rejectedReason) {
		this.rejectedReason = rejectedReason;
	}

	public Long getImei() {
		return imei;
	}

	public void setImei(Long imei) {
		this.imei = imei;
	}

	public Long getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(Long msisdn) {
		this.msisdn = msisdn;
	}

	
	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	@Override
	public String toString() {
		return "Documents [" + (id != null ? "id=" + id + ", " : "")
				+ (filename != null ? "filename=" + filename + ", " : "")
				+ (filepath != null ? "filepath=" + filepath + ", " : "")
				+ (fileUri != null ? "fileDownloadUri=" + fileUri + ", " : "")
				+ (fileType != null ? "fileType=" + fileType + ", " : "")
				+ (documentType != null ? "documentType=" + documentType + ", " : "") + "size=" + size + ", "
				+ (status != null ? "status=" + status + ", " : "")
				+ (approvedBy != null ? "approvedBy=" + approvedBy + ", " : "")
				+ (approvalDate != null ? "approvalDate=" + approvalDate + ", " : "")
				+ (rejectedReason != null ? "rejectedReason=" + rejectedReason + ", " : "")
				+ (imei != null ? "imei=" + imei + ", " : "") + (msisdn != null ? "msisdn=" + msisdn : "") + "]";
	}

}
