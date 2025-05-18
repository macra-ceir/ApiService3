package com.gl.ceir.config.model.app;

public class CheckDevice {

	private Integer deviceIdType;
	private Integer deviceId;
	public Integer getDeviceIdType() {
		return deviceIdType;
	}
	public void setDeviceIdType(Integer deviceIdType) {
		this.deviceIdType = deviceIdType;
	}
	public Integer getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	@Override
	public String toString() {
		return "CheckDevice [deviceIdType=" + deviceIdType + ", deviceId=" + deviceId + "]";
	}
}
