package soapdemo;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(endpointInterface = "soapdemo.UserService")
public class UserServiceImpl implements UserService {
	@Resource
	WebServiceContext wsctx;
	
	@Override
	@WebMethod
	public String getWelcomeMessage() {
		MessageContext mctx = wsctx.getMessageContext();
		
		Map http_headers = (Map)mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
		List userList = (List)http_headers.get("Username");
		List passList = (List)http_headers.get("Password");
		
		String username = "";
		String password = "";
		
		if(userList != null) {
			username = userList.get(0).toString();
		}
		
		if(passList != null) {
			password = passList.get(0).toString();
		}
		
		if(username.equals("sadhana") && password.equals("secret")) {
			return "Welcome - valid user!";
		} else {
			return "Unknown user!";
		}
	}
}
