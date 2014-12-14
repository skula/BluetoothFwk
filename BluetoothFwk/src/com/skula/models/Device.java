package com.skula.models;

public class Device {
	private String name;
	private String mac;
	private boolean connected;

	public Device(String name, String mac, boolean connected) {
		this.name = name;
		this.mac = mac;
		this.connected = connected;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}
}
