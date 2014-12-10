package com.google.gwt.activemq.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.activemq.client.api.ActiveMQConstants;
import com.google.gwt.activemq.client.api.Queue;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.jolokia.client.JolokiaConstants;
import com.google.gwt.jolokia.client.JolokiaReadResponse;
import com.google.gwt.jolokia.client.rest.JolokiaClient;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class AMQClient  {

	private final JolokiaClient client;

	public AMQClient(final String url) {
		client = new JolokiaClient(url);
	}

	public AMQClient(final String url, final String username, final String password) {
		client = new JolokiaClient(url, username, password);
	}

	/*
	 * public String getBrokderId() { // TODO Auto-generated method stub return
	 * null; }
	 * 
	 * public String getBrokerVersion() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * public String getBrokerName() { // TODO Auto-generated method stub return
	 * null; }
	 * 
	 * public boolean getPersistent() { // TODO Auto-generated method stub
	 * return false; }
	 * 
	 * public TransportConnectors getTransportConnectors() { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * public boolean getSlave() { // TODO Auto-generated method stub return
	 * false; }
	 * 
	 * public int getCurrentConnectionsCount() { // TODO Auto-generated method
	 * stub return 0; }
	 * 
	 * public long getTotalConnectionsCount() { // TODO Auto-generated method
	 * stub return 0; }
	 * 
	 * public long getTotalDequeueCount() { // TODO Auto-generated method stub
	 * return 0; }
	 * 
	 * public long getTotalConsumerCount() { // TODO Auto-generated method stub
	 * return 0; }
	 * 
	 * public long getTotalProducerCount() { // TODO Auto-generated method stub
	 * return 0; }
	 * 
	 * public long getTotalMessageCount() { // TODO Auto-generated method stub
	 * return 0; }
	 * 
	 * public long getAverageMessageSize() { // TODO Auto-generated method stub
	 * return 0; }
	 * 
	 * public long getMaxMessageSize() { // TODO Auto-generated method stub
	 * return 0; }
	 * 
	 * public long getMinMessageSize() { // TODO Auto-generated method stub
	 * return 0; }
	 * 
	 * public long getMemoryLimit() { // TODO Auto-generated method stub return
	 * 0; }
	 * 
	 * public long getStoreLimit() { // TODO Auto-generated method stub return
	 * 0; }
	 * 
	 * public int getStorePercentageUsed() { // TODO Auto-generated method stub
	 * return 0; }
	 * 
	 * public int getTempLimit() { // TODO Auto-generated method stub return 0;
	 * }
	 * 
	 * public long getTempPercentageUsed() { // TODO Auto-generated method stub
	 * return 0; }
	 * 
	 * public long getJobSchedulerStoreLimit() { // TODO Auto-generated method
	 * stub return 0; }
	 * 
	 * public int getJobSchedulerStorePercentUsage() { // TODO Auto-generated
	 * method stub return 0; }
	 * 
	 * public boolean getStatisticsEnabled() { // TODO Auto-generated method
	 * stub return false; }
	 * 
	 * public String getOpenwireURL() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * public String getStompURL() { // TODO Auto-generated method stub return
	 * null; }
	 * 
	 * public String getSslURL() { // TODO Auto-generated method stub return
	 * null; }
	 * 
	 * public String getVMURL() { // TODO Auto-generated method stub return
	 * null; }
	 * 
	 * public String getDataDirectory() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * public long getTotalEnqueueCount() { // TODO Auto-generated method stub
	 * return 0; }
	 * 
	 * public int getMemoryPercentUsage() { // TODO Auto-generated method stub
	 * return 0; }
	 * 
	 * public String getUptime() { // TODO Auto-generated method stub return
	 * null; }
	 */

	/**
	 * Used to retrieve the list of queue objects.
	 * 
	 * 
	 * <p>
	 * 
	 * Example JolokiaReadResponse {"timestamp":1418227254, "status":200,
	 * "request"
	 * :{"mbean":"org.apache.activemq:brokerName=localhost,type=Broker",
	 * "attribute":"Queues", "type":"read"}, "value":[{"objectName":
	 * "org.apache.activemq:brokerName=localhost,destinationName=com.test.stomp,destinationType=Queue,type=Broker"
	 * },{"objectName":
	 * "org.apache.activemq:brokerName=localhost,destinationName=com.stomp.test,destinationType=Queue,type=Broker"
	 * }]}
	 * </p>
	 * 
	 * @param broker
	 * @param callback
	 * @throws RequestException
	 */
	public void getQueues(final String broker, final AsyncCallback<List<String>> callback) throws RequestException {
		client.getAttribute("org.apache.activemq:type=Broker,brokerName=" + broker, ActiveMQConstants.Queues, null,
				null, new AsyncCallback<JolokiaReadResponse>() {

					public void onFailure(Throwable caught) {
						callback.onFailure(caught);
					}

					public void onSuccess(JolokiaReadResponse result) {
						List<String> queues = new ArrayList<String>();
						JSONArray jsArray = new JSONArray(result.getValue());
						for (int i = 0; i < jsArray.size(); i++) {
							JSONObject value = jsArray.get(i).isObject();
							queues.add(value.get(JolokiaConstants.OBJECT_NAME).isString().stringValue());
						}

						callback.onSuccess(queues);
					}
				});
	}

	public void getTopics(final String broker, final AsyncCallback<List<String>> callback) throws RequestException {
		client.getAttribute("org.apache.activemq:type=Broker,brokerName=" + broker, ActiveMQConstants.Topics, null,
				null, new AsyncCallback<JolokiaReadResponse>() {

					public void onFailure(Throwable caught) {
						callback.onFailure(caught);
					}

					public void onSuccess(JolokiaReadResponse result) {
						List<String> queues = new ArrayList<String>();
						JSONArray jsArray = new JSONArray(result.getValue());
						for (int i = 0; i < jsArray.size(); i++) {
							JSONObject value = jsArray.get(i).isObject();
							queues.add(value.get(JolokiaConstants.OBJECT_NAME).isString().stringValue());
						}

						callback.onSuccess(queues);
					}
				});
	}
	
	public void getQueue(final String queueObjectName, final AsyncCallback<Queue> callback) throws RequestException {
		client.getAttribute(queueObjectName, null, null, null, new AsyncCallback<JolokiaReadResponse>() {

					public void onFailure(Throwable caught) {
						callback.onFailure(caught);
					}

					public void onSuccess(JolokiaReadResponse result) {
						System.out.println("Status is " + result.getStatus() + " Error is " + result.getError());
						if (result.getStatus() != 200) {
							callback.onFailure(new RequestException("Unable to retrieve queues, Cause:" + result.getError()));
						} else {
							callback.onSuccess((Queue)result.cast());
						}
					}
				});
	}
}
