package soapdemo;

import javax.xml.ws.Endpoint;

public class UserServicePublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8888/ws/user", new UserServiceImpl());
		System.out.println("Published.....");
	}
}
