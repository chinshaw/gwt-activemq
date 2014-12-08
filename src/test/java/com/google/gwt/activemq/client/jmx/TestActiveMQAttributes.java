package com.google.gwt.activemq.client.jmx;
import org.junit.Test;

import com.google.gwt.activemq.client.api.Queues;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;


public class TestActiveMQAttributes extends GWTTestCase {

	@Override
	public String getModuleName() {
		return "com.google.gwt.activemq.ActiveMQ";
	}

	
	@Test
	public void testGetQueues() {
		delayTestFinish(2000);
		ActiveMQAttributes ama = new ActiveMQAttributes();
		ama.getQueues(new AsyncCallback<Queues>() {

			public void onFailure(Throwable caught) {
				fail(caught.getMessage());
			}

			public void onSuccess(Queues result) {
				System.out.println("Queues size " + result.getValue().size());
				System.out.println("Queues size " + result.getValue().get(0).getObjectName());
				finishTest();
			}
		});
		
	}
	
	
	
}
