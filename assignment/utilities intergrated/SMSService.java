package utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

interface SMSServiceProvider {
	public void sendSMS(String filename) throws Exception;
}

class SMSService implements SMSServiceProvider {
	private Parser invoice  = new InvoiceParser();
	
	@Override
	public void sendSMS(String filename) throws Exception {
		invoice = invoice.parseData(filename);
		this.sendSMSUtil((InvoiceParser) invoice);
	}
	
	private void sendSMSUtil(InvoiceParser invoice) throws Exception {
		invoice = invoice.getInvoice();
		try {
	            String apiKey = "apikey=" + "Zjg1ZjhhZGQwOWYzM2M1NTY1ZGY1YjAzYjU0Yjg2OTU=";
	            String message = "&message=" + "Hi there! Please find your invoice details." + "Name: "+invoice.getCustName() +"Bill no: "+invoice.getInvNo();
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
	}
}
