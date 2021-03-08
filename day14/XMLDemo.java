package day14;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLDemo {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setValidating(true);
		
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse("books.xml");
		
		System.out.println(doc.getDocumentElement().getNodeName());
		System.out.println(doc.getDocumentElement().getChildNodes().getLength());
		
		Element root = doc.getDocumentElement();
		
		for(int i=0; i<root.getChildNodes().getLength(); i++) {
			for(int j=0; j<root.getChildNodes().item(i).getChildNodes().getLength(); j++) {
				System.out.println(root.getChildNodes().item(i).getChildNodes().item(j).getNodeName()+" : "+root.getChildNodes().item(i).getChildNodes().item(j).getTextContent());
			}
		}
		
		System.out.println();
		System.out.println(root.getChildNodes().item(0));
		System.out.println(root.getFirstChild().getFirstChild().getNodeType());
		System.out.println(root.getFirstChild().getFirstChild().getTextContent());
	}
}
