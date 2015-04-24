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
	
	/**
	 * This is used to retrieve a queue by it's distingished object name. The queueObject name is the
	 * verbatim objectName you would get back from the {@link #getQueues(String, AsyncCallback)} method.
	 * 
	 * @param queueObjectName
	 * @param callback
	 * @throws RequestException
	 */
	public void getQueue(final String queueObjectName, final AsyncCallback<Queue> callback) throws RequestException {
		client.getAttribute(queueObjectName, null, null, null, new AsyncCallback<JolokiaReadResponse>() {

					public void onFailure(Throwable caught) {
						callback.onFailure(caught);
					}

					public void onSuccess(JolokiaReadResponse result) {
						if (result.getStatus() != 200) {
							callback.onFailure(new RequestException("Unable to retrieve queues, Cause:" + result.getError()));
						} else {
							callback.onSuccess((Queue)result.cast());
						}
					}
				});
	}
	
	public void getQueueByQueueName(final String brokerName, final String destinationName, final AsyncCallback<Queue> callback) throws RequestException {
		final String queueObjectName = ActiveMQConstants.Templates.QueueObjectNameTemplate(brokerName, destinationName).asString();
		getQueue(queueObjectName, callback);
	}
}
