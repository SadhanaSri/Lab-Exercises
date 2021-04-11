package soapdemo;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class MacAddressClient {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:8888/ws/mac?wsdl");
		QName qname = new QName("http://soapdemo/", "MacAddressValidatorImplService" );
		
		Service service = Service.create(url, qname);
		MacAddressValidator obj = service.getPort(MacAddressValidator.class);
		
		System.out.println(obj.getMacAddress());
	}
}
