//package com.gl.ceir.config.model.app;
//
//import java.io.Serializable;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import io.swagger.annotations.ApiModel;
//import javax.persistence.Entity;
//
//@ApiModel
//@Entity
//public class SmsAccount implements Serializable {
//	/**
//	 *
//	 */
//	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	private String ip;
//	private int port;
//	private String userName;
//	private String passWord;
//	private String url;
//	private int tps;
//	private boolean status;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getIp() {
//		return ip;
//	}
//
//	public void setIp(String ip) {
//		this.ip = ip;
//	}
//
//	public int getPort() {
//		return port;
//	}
//
//	public void setPort(int port) {
//		this.port = port;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getPassWord() {
//		return passWord;
//	}
//
//	public void setPassWord(String passWord) {
//		this.passWord = passWord;
//	}
//
//	public String getUrl() {
//		return url;
//	}
//
//	public void setUrl(String url) {
//		this.url = url;
//	}
//
//	public int getTps() {
//		return tps;
//	}
//
//	public void setTps(int tps) {
//		this.tps = tps;
//	}
//
//	public boolean isStatus() {
//		return status;
//	}
//
//	public void setStatus(boolean status) {
//		this.status = status;
//	}
//
//	@Override
//	public String toString() {
//		return "SmsAccount [iD=" + id + ", ip=" + ip + ", port=" + port + ", userName=" + userName + ", passWord="
//				+ passWord + ", url=" + url + ", tps=" + tps + ", status=" + status + ", getiD()=" + getId()
//				+ ", getIp()=" + getIp() + ", getPort()=" + getPort() + ", getUserName()=" + getUserName()
//				+ ", getPassWord()=" + getPassWord() + ", getUrl()=" + getUrl() + ", getTps()=" + getTps()
//				+ ", isStatus()=" + isStatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
//				+ ", toString()=" + super.toString() + "]";
//	}
//
//}
