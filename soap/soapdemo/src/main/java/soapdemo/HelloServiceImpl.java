package soapdemo;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "soapdemo.HelloService")
@HandlerChain(file = "soapdemo/handler-chain.xml")
public class HelloServiceImpl implements HelloService {
	@WebMethod
	@Override
	public String helloService(String name) {
		// TODO Auto-generated method stub
		return "Welcome "+name;
	}
}
