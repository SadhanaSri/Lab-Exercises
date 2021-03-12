package day15.component;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

interface EmailServiceProvider {
	public void sendMailUtil(InvoiceParser invoice) throws Exception;
	public void sendMail(String filename) throws Exception;
}

class EmailService implements EmailServiceProvider {
	
	private Parser invoice  = new InvoiceParser();
	
	public void sendMail(String filename) throws Exception {
		invoice = invoice.parseData(filename);
		this.sendMailUtil((InvoiceParser) invoice);
	}
	
	public void sendMailUtil(InvoiceParser invoice) throws Exception {
		invoice = invoice.getInvoice();
    	
    	final String host = "smtp.gmail.com";
    	final int port = 587;
    	final String username = "sadhanasri182@gmail.com";
    	final String password = "sadhanakalyan1822";
        
        
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);
        prop.put("mail.smtp.ssl.trust", host);

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("s.sadhanasri18@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("sadhanasri182@gmail.com"));
                message.setSubject("Invoice Details");
                                
                StringBuilder email = new StringBuilder();
                email.append("Hi there! Please find your invoice details.");
                email.append("<html><body>"
                        + "<br><br><table style='border:2px solid black'>");
                
                email.append("<tr bgcolor=\"#33CC99\">");
                email.append("<th colspan='3'>Name: ");
                email.append(invoice.getCustName()+"</th>");
                email.append("<th>Invoice No: ");
                email.append(invoice.getInvNo()+"</th>");
                email.append("<th>Date: ");
                email.append(invoice.getDate()+"</th>");
                email.append("</tr>");
                
                email.append("<tr bgcolor=\"#33CC99\">");
                email.append("<th>Item No</th>");
                email.append("<th>Item Name</th> ");
                email.append("<th>Price</th>");
                email.append("<th>Qty</th>");
                email.append("<th>Amount</th>");
                email.append("</tr>");
                
                List<Items> list = invoice.getItemList();
                
                for(int i=0; i<list.size(); i++) {
                	 email.append("<tr bgcolor=\"#33CC99\">");
                	 email.append("<td>");
                     email.append(list.get(i).getItemNo());
                     email.append("</td>");
                     email.append("<td>");
                     email.append(list.get(i).getItemName());
                     email.append("</td>");
                     email.append("<td>");
                     email.append(list.get(i).getPrice());
                     email.append("</td>");
                     email.append("<td>");
                     email.append(list.get(i).getQty());
                     email.append("</td>");
                     email.append("<td>");
                     email.append(list.get(i).getAmount());
                     email.append("</td>");
                     email.append("</tr>");
                }
                email.append("<tr bgcolor=\"#33CC99\">");
                email.append("<th colspan = '3'>GST &emsp;");
                email.append(invoice.getGst()+"</th>");
                email.append("<th colspan='2'>Total &emsp;");
                email.append(invoice.getNet()+"</th>");
                email.append("</tr>");
                
                email.append("</table></body></html>");
               
                
                MimeBodyPart mimeBodyPart = new MimeBodyPart();
                mimeBodyPart.setContent(email.toString(), "text/html");

                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(mimeBodyPart);

                message.setContent(multipart);

                Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
