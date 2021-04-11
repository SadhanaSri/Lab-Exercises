package soapdemo;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MacAddressValidator {
	@WebMethod
	public String getMacAddress();
}
