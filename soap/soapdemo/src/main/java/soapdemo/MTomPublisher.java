package soapdemo;

import javax.xml.ws.Endpoint;

public class MTomPublisher {
	public static void main(String[] args) {
		System.out.println("service ready....");
		Endpoint.publish("http://localhost:8888/ws/image", new MTomService());
	}
}
