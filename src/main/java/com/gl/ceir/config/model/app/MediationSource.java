package com.gl.ceir.config.model.app;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import io.swagger.annotations.ApiModel;

@ApiModel
@Entity
public class MediationSource implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private MobileOperator mobileOperator;
	private String fileFormat;
	private String filePath;
	private String fileNameFormat;
	private int poolingFrequency;

	public MediationSource() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MobileOperator getMobileOperator() {
		return mobileOperator;
	}

	public void setMobileOperator(MobileOperator mobileOperator) {
		this.mobileOperator = mobileOperator;
	}

	public String getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileNameFormat() {
		return fileNameFormat;
	}

	public void setFileNameFormat(String fileNameFormat) {
		this.fileNameFormat = fileNameFormat;
	}

	public int getPoolingFrequency() {
		return poolingFrequency;
	}

	public void setPoolingFrequency(int poolingFrequency) {
		this.poolingFrequency = poolingFrequency;
	}

}
