package com.gl.ceir.config.model.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class AttachedFileInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fileName;
	
	private Long messageId;
	
	private String grievanceId;
	
	private String docType;
	
	@Transient
	private String docTypeInterp;
	
	@Transient
	private String url;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public String getGrievanceId() {
		return grievanceId;
	}

	public void setGrievanceId(String grievanceId) {
		this.grievanceId = grievanceId;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocTypeInterp() {
		return docTypeInterp;
	}

	public void setDocTypeInterp(String docTypeInterp) {
		this.docTypeInterp = docTypeInterp;
	}

}
