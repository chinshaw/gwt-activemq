package com.google.gwt.activemq.client.jmx;

import com.google.gwt.activemq.client.api.IActiveMQAttributes;
import com.google.gwt.activemq.client.api.Queues;
import com.google.gwt.activemq.client.api.Topics;
import com.google.gwt.activemq.client.api.TransportConnectors;
import com.google.gwt.jolokia.client.JolokiaReadRequest;
import com.google.gwt.jolokia.client.UserCredentials;
import com.google.gwt.jolokia.client.rest.JolokiaRestRequest;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ActiveMQAttributes implements IActiveMQAttributes {

	public String getBrokderId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBrokerVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBrokerName() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean getPersistent() {
		// TODO Auto-generated method stub
		return false;
	}

	public TransportConnectors getTransportConnectors() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean getSlave() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getCurrentConnectionsCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getTotalConnectionsCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getTotalDequeueCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getTotalConsumerCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getTotalProducerCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getTotalMessageCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getAverageMessageSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getMaxMessageSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getMinMessageSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getMemoryLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getStoreLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getStorePercentageUsed() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getTempLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getTempPercentageUsed() {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getJobSchedulerStoreLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getJobSchedulerStorePercentUsage() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean getStatisticsEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getOpenwireURL() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getStompURL() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSslURL() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getVMURL() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDataDirectory() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getTotalEnqueueCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void getQueues(final AsyncCallback<Queues> callback) {
		UserCredentials.INSTANCE.setUserName("admin");
		UserCredentials.INSTANCE.setPassword("admin");
		JolokiaRestRequest<Queues> memoryRequest = new JolokiaRestRequest<Queues>();
		
		JolokiaReadRequest queuesRequest = new JolokiaReadRequest();
		queuesRequest.setMbean("org.apache.activemq:type=Broker,brokerName=localhost");
		queuesRequest.setAttribute("Queues");
		memoryRequest.read(queuesRequest,Queues.Codec.INSTANCE, new AsyncCallback<Queues>() {
			
			public void onSuccess(Queues response) {
				callback.onSuccess(response);
			}
			
			public void onFailure(Throwable exception) {
				callback.onFailure(exception);
			}
		});
	}

	public void getTopics(final AsyncCallback<Topics> callback) {
		
	}

	public int getMemoryPercentUsage() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getUptime() {
		// TODO Auto-generated method stub
		return null;
	}

}
