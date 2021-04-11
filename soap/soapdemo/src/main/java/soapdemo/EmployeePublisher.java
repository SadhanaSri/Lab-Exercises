package soapdemo;

import javax.xml.ws.Endpoint;

public class EmployeePublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:2080/soapdemo/employee", new EmployeeServiceImpl());
		System.out.println("Published");
	}
}
