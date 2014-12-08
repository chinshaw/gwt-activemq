package com.google.gwt.activemq.client.api;

import java.util.List;

import org.fusesource.restygwt.client.JsonEncoderDecoder;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.jolokia.client.JolokiaReadResponse;

public class Topics extends JolokiaReadResponse {

	public interface Codec extends JsonEncoderDecoder<Topics> {

		public static final Codec INSTANCE = GWT.create(Codec.class);
	}

	private List<Topic> value;

	public List<Topic> getValue() {
		return value;
	}

	public void setValue(List<Topic> value) {
		this.value = value;
	}
}
