package com;

import java.net.URL;
import java.net.URLConnection;

public class JavaClient {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:3000/restdemo/rest/test");
		URLConnection con = url.openConnection();
		con.getInputStream();
	}
}
