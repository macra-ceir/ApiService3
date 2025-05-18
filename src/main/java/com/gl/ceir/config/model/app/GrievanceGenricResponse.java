package com.gl.ceir.config.model.app;

public class GrievanceGenricResponse {
	private int errorCode;
	private String message;
	private String grievanceId;


	public GrievanceGenricResponse(int errorCode, String message, String grievanceId) {
		this.errorCode = errorCode;
		this.message = message;
		this.grievanceId = grievanceId;
	}


	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getGrievanceId() {
		return grievanceId;
	}


	public void setGrievanceId(String grievanceId) {
		this.grievanceId = grievanceId;
	}


	@Override
	public String toString() {
		return "GenricResponse [errorCode=" + errorCode + ", message=" + message + ", grievanceId=" + grievanceId + "]";
	}
}
