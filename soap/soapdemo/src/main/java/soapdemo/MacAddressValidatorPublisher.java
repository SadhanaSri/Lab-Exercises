package soapdemo;

import javax.xml.ws.Endpoint;

public class MacAddressValidatorPublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8888/ws/mac", new MacAddressValidatorImpl());
		System.out.println("Published.......");
	}
}
