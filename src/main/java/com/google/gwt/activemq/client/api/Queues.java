package com.google.gwt.activemq.client.api;

import java.util.List;

import org.fusesource.restygwt.client.JsonEncoderDecoder;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.jolokia.client.JolokiaReadResponse;

public class Queues extends JolokiaReadResponse {

	public interface Codec extends JsonEncoderDecoder<Queues> {

		public static final Codec INSTANCE = GWT.create(Codec.class);
	}

	private List<Queue> value;

	public List<Queue> getValue() {
		return value;
	}

	public void setValue(List<Queue> value) {
		this.value = value;
	}
}
