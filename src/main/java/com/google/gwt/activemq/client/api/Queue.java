package com.google.gwt.activemq.client.api;

import com.google.gwt.jolokia.client.JolokiaReadResponse;

public class Queue extends JolokiaReadResponse {
	
	protected Queue() {}
	
	public final int getMemoryUsageByteCount() {
		return getValuePropertyInt("MemoryUsageByteCount");
	}
	
	public final int getProducerCount() {
		return getValuePropertyInt("ProducerCount");
	}
	
	public final boolean getUseCache() {
		return getValuePropertyBool("UseCache");
	}
	
	public final boolean getProducerFlowControl() {
		return getValuePropertyBool("ProducerFlowControl");
	}
	
	public final int getMaxPageSize() {
		return getValuePropertyInt("MaxPageSize");
	}
	
	public final int getCursorMemoryUsage() {
		return getValuePropertyInt("CursorMemoryUsage");
	}
	
	public final int getMaxAuditDepth() {
		return getValuePropertyInt("MaxAuditDepth");
	}
	
	public final boolean getDLQ() {
		return getValuePropertyBool("DLQ");
	}
	
	public final boolean getAlwaysRetroactive() {
		return getValuePropertyBool("AlwaysRetroactive");
	}
	
	public final int getMemoryPercentUsage() {
		return getValuePropertyInt("MemoryPercentUsage");
	}
	
	public final boolean getPrioritizedMessages() {
		return getValuePropertyBool("PrioritizedMessages");
	}
	
	public final int getMaxEnqueueTime() {
		return getValuePropertyInt("MaxEnqueueTime");
	}
	
	public final boolean getCursorFull() {
		return getValuePropertyBool("CursorFull");
	}
	
	public final long getMemoryLimit() {
		return getValuePropertyLong("MemoryLimit");
	}
	
	public final int getDispatchCount() {
		return getValuePropertyInt("DispatchCount");
	}
	
	public final int getQueueSize() {
		return getValuePropertyInt("QueueSize");
	}
	
	public final long getBlockedProducerWarningInterval() {
		return getValuePropertyLong("BlockedProducerWarningInterval");
	}
	
	public final int getDequeueCount() {
		return getValuePropertyInt("DequeueCount");
	}
	
	public final double getAverageEnqueueTime() {
		return getValuePropertyDouble("AverageEnqueueTime");
	}
	
	public final int getTotalBlockedTime() {
		return getValuePropertyInt("TotalBlockedTime");
	}
	
	public final int getMinEnqueueTime() {
		return getValuePropertyInt("MinEnqueueTime");
	}
	
	public final boolean CacheEnabled() {
		return getValuePropertyBool("CacheEnabled");
	}
	
	public final String getMessageGroupType() {
		return getValuePropertyString("MessageGroupType");
	}
	
	public final int getEnqueueCount() {
		return getValuePropertyInt("EnqueueCount");
	}
	
	public final int getMaxMessageSize() {
		return getValuePropertyInt("MaxMessageSize");
	}
	
	public final int getConsumerCount() {
		return getValuePropertyInt("ConsumerCount");
	}
	
	public final String getName() {
		return getValuePropertyString("Name");
	}
}
