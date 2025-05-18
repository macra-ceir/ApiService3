package com.gl.ceir.config.model.app;

import java.io.Serializable;

public class TableActions implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer state;
	
	private Long stateId;

	private String view;

	private String downloadErrorFile;
	
	private String edit;
	
	private String downloadFile;
	
	private String delete;
	
	private String approve;
	
	private String reject;

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getDownloadErrorFile() {
		return downloadErrorFile;
	}

	public void setDownloadErrorFile(String downloadErrorFile) {
		this.downloadErrorFile = downloadErrorFile;
	}

	public String getEdit() {
		return edit;
	}

	public void setEdit(String edit) {
		this.edit = edit;
	}

	public String getDownloadFile() {
		return downloadFile;
	}

	public void setDownloadFile(String downloadFile) {
		this.downloadFile = downloadFile;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	public String getReject() {
		return reject;
	}

	public void setReject(String reject) {
		this.reject = reject;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TableActions [stateId=");
		builder.append(stateId);
		builder.append(", view=");
		builder.append(view);
		builder.append(", downloadErrorFile=");
		builder.append(downloadErrorFile);
		builder.append(", edit=");
		builder.append(edit);
		builder.append(", downloadFile=");
		builder.append(downloadFile);
		builder.append(", delete=");
		builder.append(delete);
		builder.append(", approve=");
		builder.append(approve);
		builder.append(", reject=");
		builder.append(reject);
		builder.append("]");
		return builder.toString();
	}

}
