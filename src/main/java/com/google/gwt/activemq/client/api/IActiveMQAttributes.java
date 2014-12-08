package com.google.gwt.activemq.client.api;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IActiveMQAttributes {

	String getBrokderId();

	String getBrokerVersion();

	String getBrokerName();

	boolean getPersistent();

	TransportConnectors getTransportConnectors();

	boolean getSlave();

	int getCurrentConnectionsCount();

	long getTotalConnectionsCount();

	long getTotalDequeueCount();

	long getTotalConsumerCount();

	long getTotalProducerCount();

	long getTotalMessageCount();

	long getAverageMessageSize();

	long getMaxMessageSize();

	long getMinMessageSize();

	long getMemoryLimit();

	long getStoreLimit();

	int getStorePercentageUsed();

	int getTempLimit();

	long getTempPercentageUsed();

	long getJobSchedulerStoreLimit();

	int getJobSchedulerStorePercentUsage();

	boolean getStatisticsEnabled();

	String getOpenwireURL();

	String getStompURL();

	String getSslURL();

	String getVMURL();

	String getDataDirectory();

	long getTotalEnqueueCount();

	void getQueues(AsyncCallback<Queues> callback);

	void getTopics(AsyncCallback<Topics> callbackO);

	int getMemoryPercentUsage();

	String getUptime();

}
