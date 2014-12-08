package com.google.gwt.activemq.client.api;

public interface IActiveMQOperations {

	void enableStatistics();
	
	String addConnector(String discoveryAddress);
	
	boolean removeConnector(String connectorName);
	
	String addNetworkConnector(String discoveryAddress);
	
	boolean removeNetworkConnector(String connectorName);
	
	void stopGracefully(String p1, String p2, long p3, long p4);
	
	void restart();
	
	void resetStatistics();
	
	void disableStatistics();
	
	void addTopic(String name);
	
	void addQueue(String name);
	
	void removeQueue(String name);
	
	void removeTopic(String name);
	
	void destroyDurableSubscriber(String clientId, String subscriberName);
	
	void reloadLog4jProperties();
	
	/**
	 * The url of transport by it's type e.g. tcp, stomp, ssl, etc.
	 * @return
	 */
	String getTransportConnectorByType();
	
}
