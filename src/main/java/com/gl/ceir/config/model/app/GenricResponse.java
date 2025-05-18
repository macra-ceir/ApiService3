package com.gl.ceir.config.model.app;

public class GenricResponse {

    private int errorCode;
    private String message;
    private String txnId;
    private Object response;
    private String data;

    public GenricResponse(int errorCode) {
        this.errorCode = errorCode;
    }

    public GenricResponse(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public GenricResponse(int errorCode, String message, String data) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public GenricResponse(int errorCode, String message, String txnId, Object response) {
        this.errorCode = errorCode;
        this.message = message;
        this.txnId = txnId;
        this.response = response;
    }

    public Object getResponse() {
        return response;
    }

//	public GenricResponse(int errorCode, String message, String txnId, Object data) {
//		this.errorCode = errorCode;
//		this.message = message;
//		this.txnId = txnId;
//		this.data = data;
//	}
    public void setResponse(Object response) {
        this.response = response;
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

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public Object getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GenricResponse [errorCode=");
        builder.append(errorCode);
        builder.append(", message=");
        builder.append(message);
        builder.append(", txnId=");
        builder.append(txnId);
        builder.append(", data=");
        builder.append(data);
        builder.append("]");
        return builder.toString();
    }

}
