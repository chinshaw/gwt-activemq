package com.google.gwt.activemq.client.api;


public interface IBrokerAttributes {

	String getBrokderId();

	String getBrokerVersion();

	String getBrokerName();

	boolean getPersistent();

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
	
	int getMemoryPercentUsage();

	String getUptime();





}
