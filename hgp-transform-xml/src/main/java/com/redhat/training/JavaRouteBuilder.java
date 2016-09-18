package com.redhat.training;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JaxbDataFormat;

public class JavaRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		JaxbDataFormat dataFormat = new JaxbDataFormat();
		dataFormat.setContextPath("com.redhat.training");
		from("file:in?noop=true")
		.unmarshal(dataFormat)
		.to("jms:queue:orders");
	}

}
