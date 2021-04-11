package soapdemo;

import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class MTomSetClient {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:8888/ws/image?wsdl");
		QName qname = new QName("http://soapdemo/", "MTomServiceService");
		Service service = Service.create(url, qname);
		MTomInter mtom=service.getPort(MTomInter.class);
		
		BindingProvider bp = (BindingProvider) mtom;
		SOAPBinding binding = (SOAPBinding) bp.getBinding();
		binding.setMTOMEnabled(true);
		Image img = ImageIO.read(new File("nailpolish.jpg"));
		mtom.setImage(img,"nailpolish.jpg");
	}
}
