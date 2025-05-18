package com.gl.ceir.config.model.app;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gl.ceir.config.model.constants.FileDumpType;
import com.gl.ceir.config.model.constants.FileType;;

@Entity
public class FileDumpMgmt  implements Serializable{

	
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@CreationTimestamp
	private Date createdOn;

	@JsonIgnore
	@UpdateTimestamp
	private Date modifiedOn;
	
	private String dumpType;
	
	@Transient
	private String dumpTypeInterp;
	
	@Transient
	private String fileTypeInterp;
	
	private Integer serviceDump;
	
	private String fileName;
	
	private Integer fileType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getDumpType() {
		return dumpType;
	}

	public void setDumpType(String dumpType) {
		this.dumpType = dumpType;
	}

	public Integer getServiceDump() {
		return serviceDump;
	}

	public void setServiceDump(Integer serviceDump) {
		this.serviceDump = serviceDump;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getFileType() {
		return fileType;
	}

	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}

	public String getFileTypeInterp() {
		return fileTypeInterp;
	}

	public void setFileTypeInterp(String fileTypeInterp) {
		this.fileTypeInterp = fileTypeInterp;
	}
	
	public String getDumpTypeInterp() {
		return dumpTypeInterp;
	}

	public void setDumpTypeInterp(String dumpTypeInterp) {
		this.dumpTypeInterp = dumpTypeInterp;
	}

	@PostLoad
    public void postLoad() {
        if(fileTypeInterp == null || fileTypeInterp.isEmpty()) {
        	this.fileTypeInterp = FileType.getActionNames( this.fileType ).toString();
        }
        if(dumpTypeInterp == null || dumpTypeInterp.isEmpty()) {
        	this.dumpTypeInterp = FileDumpType.getActionNames( this.serviceDump ).toString();
        }
    }
	
}
