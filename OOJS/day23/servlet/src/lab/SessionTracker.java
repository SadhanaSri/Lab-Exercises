package lab;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionTracker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		Integer count = (Integer)session.getValue("tracker.count");
		if(count == null) {
			count = new Integer(1);
		} else {
			count=new Integer(count.intValue()+1);
		}
		session.putValue("tracker.count", count);
		out.println("You have visited the page "+count+" time(s)");
		
		out.println("<H2>Here is your session data:</H2>"); 
		
		String[] names = session.getValueNames(); 
		
		for (int i = 0; i < names.length; i++) { 
			out.println(names[i] + ": " + session.getValue(names[i]) + "<BR>"); 
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
