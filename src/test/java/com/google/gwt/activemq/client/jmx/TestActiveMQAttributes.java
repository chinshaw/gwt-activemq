package com.google.gwt.activemq.client.jmx;
import java.util.List;

import org.junit.Test;

import com.google.gwt.activemq.client.AMQClient;
import com.google.gwt.activemq.client.api.Queue;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;


public class TestActiveMQAttributes extends GWTTestCase {

	@Override
	public String getModuleName() {
		return "com.google.gwt.activemq.ActiveMQ";
	}
	
	@Test
	public void testGetQueues() throws RequestException {
		delayTestFinish(2000);
		AMQClient ama = new AMQClient("/com.google.gwt.activemq.ActiveMQ.JUnit/api/jolokia", "admin", "admin");
		ama.getQueues("localhost", new AsyncCallback<List<String>>() {

			public void onFailure(Throwable caught) {
				fail(caught.getMessage());
			}

			public void onSuccess(List<String> result) {
				finishTest();
				assert(result.size() > 0);
				for (String queue : result) {
					System.out.println("Queue is " + queue);
				}
			}
		});
	}
	
	@Test
	public void testGetTopics() throws RequestException {
		delayTestFinish(2000);
		AMQClient ama = new AMQClient("/com.google.gwt.activemq.ActiveMQ.JUnit/api/jolokia", "admin", "admin");
		ama.getTopics("localhost", new AsyncCallback<List<String>>() {

			public void onFailure(Throwable caught) {
				fail(caught.getMessage());
			}

			public void onSuccess(List<String> result) {
				finishTest();
				assert(result.size() > 0);
				for (String queue : result) {
					System.out.println("Topic is " + queue);
				}
			}
		});
	}
	
	@Test
	public void testGetQueue() throws RequestException {
		delayTestFinish(2000);
		AMQClient ama = new AMQClient("/com.google.gwt.activemq.ActiveMQ.JUnit/api/jolokia", "admin", "admin");
		ama.getQueue("org.apache.activemq:brokerName=localhost,destinationName=com.stomp.test,destinationType=Queue,type=Broker", new AsyncCallback<Queue>() {

			public void onFailure(Throwable caught) {
				fail(caught.getMessage());
			}

			public void onSuccess(Queue result) {
				finishTest();
				assertTrue(result.getMemoryLimit() > 0);
			}
		});
	}
}
