package hibernateday1;

import java.io.Serializable;

public class Comment implements Serializable {
	private String msg;

	public Comment() {
		// TODO Auto-generated constructor stub
	}
	
	public Comment(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
