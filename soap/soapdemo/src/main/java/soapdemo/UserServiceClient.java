package soapdemo;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

public class UserServiceClient {
	private static final String WS_URL = "http://localhost:8888/ws/user?wsdl";
	
	public static void main(String[] args) throws Exception {
		URL url = new URL(WS_URL);
		QName qname= new QName("http://soapdemo/", "UserServiceImplService");
		
		Service service = Service.create(url, qname);
		UserService user =  service.getPort(UserService.class);
		
		Map<String, Object> req_ctx = ((BindingProvider)user).getRequestContext();
		
		req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);
		
		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		headers.put("Username", Collections.singletonList("sadhana"));
		headers.put("Password", Collections.singletonList("secret"));
		
		req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		
		System.out.println(user.getWelcomeMessage());
	}
}
