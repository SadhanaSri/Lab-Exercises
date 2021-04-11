package soapdemo;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloService {
	@WebMethod
	public String helloService(String name);
}
