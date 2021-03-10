package day15.component;

import java.lang.reflect.Proxy;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class XMLToExcelComponentDemo {
	public static void main(String[] args) throws Exception {
		Object obj = new XMLToExcelComponentDemo();
		obj = Proxy.newProxyInstance(XMLToExcelComponentDemo.class.getClassLoader(), new Class[] {XMLToExcel.class, XMLToPDF.class}, new MyInvocationHandler(new WriteToExcel()));
		
		InvoiceParser invoice;
		SAXParserFactory spf=SAXParserFactory.newInstance(); 
		SAXParser sp=spf.newSAXParser(); 
		sp.parse("invoices.xml", invoice = new InvoiceParser());
		invoice = invoice.getInvoice();
		
		XMLToExcel converter = (XMLToExcel)obj;
		converter.writeData(invoice);
	}
}

class MyInvocationHandler implements InvocationHandler {
	Object obj;

	MyInvocationHandler(Object obj) {
		this.obj=obj;		
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object o = method.invoke(obj, args);
		return o;
	}
}



