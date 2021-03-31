package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SMSGenerationAction extends Action {
@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	try {
		
		HttpSession se = request.getSession();
		InvoiceMasterDTO invoiceDTO = (InvoiceMasterDTO)se.getAttribute("invoiceDTO");
		
        String apiKey = "apikey=" + "Zjg1ZjhhZGQwOWYzM2M1NTY1ZGY1YjAzYjU0Yjg2OTU=";
        String message = "&message=" + "Hi there! Please find your invoice details." + "Name: "+invoiceDTO.getCustName() +"Bill no: "+invoiceDTO.getInvNo();
        String sender = "&sender=" + "TXTLCL";
        String numbers = "&numbers=" + "9790007600";

        HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
        String data = apiKey + numbers + message + sender;
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
        conn.getOutputStream().write(data.getBytes("UTF-8"));
         
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            stringBuffer.append(line).append("\n");
        }
        System.out.println(stringBuffer.toString());
        rd.close();


    } catch (Exception e) {
       e.printStackTrace();
    }
		return "sms.success";
	}
}
