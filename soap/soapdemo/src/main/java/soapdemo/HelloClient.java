package soapdemo;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class HelloClient {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:2029/soapdemo/hello?wsdl");
		QName qname = new QName("http://soapdemo/", "HelloServiceImplService");
		
		Service service = Service.create(url, qname);
		
		HelloService hservice = service.getPort(HelloService.class);
		
		String result =hservice.helloService("sadhana");
		System.out.println(result);
	}
}
