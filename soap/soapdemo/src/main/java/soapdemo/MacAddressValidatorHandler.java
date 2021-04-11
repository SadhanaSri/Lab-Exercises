package soapdemo;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;


public class MacAddressValidatorHandler implements SOAPHandler<SOAPMessageContext>{

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println("Server: handleMessage()");
		Boolean isReq = (Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		
		if(!isReq) {
			try {
				SOAPMessage msg = context.getMessage();
				SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
				SOAPHeader header = env.getHeader();
				
				if(header == null) {
					header = env.addHeader();
					generateSOAPErrMessage(msg, "No SOAP Header");
				}
				
				Iterator it = header.extractHeaderElements(SOAPConstants.URI_SOAP_ACTOR_NEXT);
				
				if(it == null || !it.hasNext()) {
					generateSOAPErrMessage(msg, "No header block for next actor");
				}
				
				Node mac = (Node)it.next();
				String macValue = (mac == null)? null: mac.getValue();
				
				if(macValue == null) {
					generateSOAPErrMessage(msg, "No mac address in header block.");
				}
				
				msg.writeTo(System.out);
				
			} catch(Exception e) {
				
			}
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("Server : handleFault()......");
		return true;
	}

	@Override
	public void close(MessageContext context) {
		System.out.println("Server : close()......");		
	}

	@Override
	public Set<QName> getHeaders() {
		System.out.println("Server : getHeaders()......");
		return null;
	}
	
	private void generateSOAPErrMessage(SOAPMessage msg, String reason) {
		try {
			SOAPBody soapBody =	msg.getSOAPPart().getEnvelope().getBody();
			SOAPFault soapFault = soapBody.addFault();
			soapFault.setFaultString(reason);
			throw new SOAPFaultException(soapFault);
		}
		catch(SOAPException e) {
			e.printStackTrace();
		}

	}
}