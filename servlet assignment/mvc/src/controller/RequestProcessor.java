package controller;

import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Action;

public class RequestProcessor {
	RequestDispatcher rd;
	String result;
	
	public void process(HttpServletRequest request, HttpServletResponse response) {
		String val = request.getParameter("type");
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream("C:\\eclipse-workspace\\mvc\\config.properties"));
			String className = "model."+prop.getProperty(val);
			
			Action action = (Action)Class.forName(className).getConstructor().newInstance();
			result = action.execute(request, response);
			
			String file = prop.getProperty(result);
			rd = request.getRequestDispatcher(file);
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
