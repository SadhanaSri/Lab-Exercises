package soapdemo;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface UserService {
	@WebMethod
	public String getWelcomeMessage();
}
