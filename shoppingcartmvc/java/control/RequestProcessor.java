package control;

import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;

public class RequestProcessor {
	public void process(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServletContext sc = request.getServletContext();
			String path = (String)sc.getAttribute("path");
			
			Properties prop = new Properties();
			prop.load(new FileInputStream(path));
			
			String form = request.getParameter("formid");
			String action = prop.getProperty(form); 
			
			model.Action actionclass = (Action)Class.forName(action).getConstructor().newInstance();
		
			String result = actionclass.execute(request, response);
			String nextpage = prop.getProperty(result);
			
			RequestDispatcher rd = request.getRequestDispatcher(nextpage);
			rd.forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
