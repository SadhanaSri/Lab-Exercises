package model;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class UserName extends TagSupport {
	private static final long serialVersionUID = 1L;
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	@Override
	public int doEndTag() throws JspException {
		HttpSession session = pageContext.getSession();
		JspWriter out = pageContext.getOut();
		String value = (String)session.getAttribute("uname");
		
		try {
			out.print(value);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return super.doEndTag();
	}
}
