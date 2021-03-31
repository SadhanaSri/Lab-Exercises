package model;

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmailGenerationAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		final String host = "smtp.gmail.com";
    	final int port = 587;
    	final String username = "sadhanasri182@gmail.com";
    	final String password = "iypibckvwpmstpro";
        
    	HttpSession se = request.getSession();
		InvoiceMasterDTO invoiceDTO = (InvoiceMasterDTO)se.getAttribute("invoiceDTO");
		
		
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
                email.append(invoiceDTO.getCustName()+"</th>");
                email.append("<th>Invoice No: ");
                email.append(invoiceDTO.getInvNo()+"</th>");
                email.append("<th>Date: ");
                email.append(invoiceDTO.getInvDate()+"</th>");
                email.append("</tr>");
                
                email.append("<tr bgcolor=\"#33CC99\">");
                email.append("<th>Item No</th>");
                email.append("<th>Item Name</th> ");
                email.append("<th>Price</th>");
                email.append("<th>Qty</th>");
                email.append("<th>Amount</th>");
                email.append("</tr>");
                
                List<ItemMasterDTO> list = invoiceDTO.getItemList();
                int total=0;
                
                for(int i=0; i<list.size(); i++) {
                	 email.append("<tr bgcolor=\"#33CC99\">");
                	 email.append("<td>");
                     email.append(list.get(i).getItemCode());
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
                     email.append(list.get(i).getPrice()*list.get(i).getQty());
                     email.append("</td>");
                     email.append("</tr>");
                     total += list.get(i).getPrice()*list.get(i).getQty();
                }
                email.append("<tr bgcolor=\"#33CC99\">");
                email.append("<th colspan='5'>Total &emsp;");
                email.append(total+"</th>");
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
		return "email.success";
	}
}
