package com.google.gwt.activemq.client.api;

public class TransportConnectors {

	private String amqp;
	
	private String mqtt;
	
	private String openwire;
	
	private String ws;
	
	private String stomp;

	public String getAmqp() {
		return amqp;
	}

	public void setAmqp(String amqp) {
		this.amqp = amqp;
	}

	public String getMqtt() {
		return mqtt;
	}

	public void setMqtt(String mqtt) {
		this.mqtt = mqtt;
	}

	public String getOpenwire() {
		return openwire;
	}

	public void setOpenwire(String openwire) {
		this.openwire = openwire;
	}

	public String getWs() {
		return ws;
	}

	public void setWs(String ws) {
		this.ws = ws;
	}

	public String getStomp() {
		return stomp;
	}

	public void setStomp(String stomp) {
		this.stomp = stomp;
	}
	
}
