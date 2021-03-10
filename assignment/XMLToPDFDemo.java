package day15.component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XMLToPDFDemo {
	public static void main(String[] args) throws Exception {
		Object obj = new XMLToPDFDemo();
		obj = Proxy.newProxyInstance(XMLToPDFDemo.class.getClassLoader(), new Class[] {XMLToPDF.class},  new MyHandler(new XMLToPDFConverter()));
		InvoiceParser invoice;
		SAXParserFactory spf=SAXParserFactory.newInstance(); 
		SAXParser sp=spf.newSAXParser(); 
		sp.parse("invoices.xml", invoice = new InvoiceParser());
		invoice = invoice.getInvoice();
		XMLToPDF converter = (XMLToPDF)obj;
		converter.convert(invoice);
	}
}

class MyHandler implements InvocationHandler {
	Object obj;

	MyHandler(Object obj) {
		this.obj=obj;		
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object o = method.invoke(obj, args);
		return o;
	}
}

