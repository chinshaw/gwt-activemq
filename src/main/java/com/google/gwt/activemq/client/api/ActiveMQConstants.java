package com.google.gwt.activemq.client.api;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;

public class ActiveMQConstants {

	
	public static final AmqTemplates Templates = GWT.create(AmqTemplates.class);
	
	public interface AmqTemplates extends SafeHtmlTemplates {
		
		@Template("org.apache.activemq:type=Broker,brokerName={0},destinationType=Queue,destinationName={1}")
		SafeHtml QueueObjectNameTemplate(String broker, String destinationName);
	}
	
	
	public static final String Queues = "Queues";
	
	public static final String Topics = "Topics";
	
}
