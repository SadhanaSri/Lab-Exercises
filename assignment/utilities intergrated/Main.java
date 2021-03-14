package day15.component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
	public static void main(String[] args) throws Exception {
		Object obj = new Main();
		obj = Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[] {XMLToPDF.class, XMLToExcel.class, EmailServiceProvider.class, SMSServiceProvider.class},  new MyServiceHandler( new Object[] {new XMLToPDFConverter(), new WriteToExcel(), new EmailService(), new SMSService()}));
		
		XMLToPDF pdfConverter = (XMLToPDF)obj;
		pdfConverter.convertToPDF(args[0]);
		
		XMLToExcel xlsConverter = (XMLToExcel)obj;
		xlsConverter.convertToExcel(args[0]);
		
		EmailServiceProvider emailSender = (EmailServiceProvider)obj;
		emailSender.sendMail(args[0]);
		
		SMSServiceProvider smsSender = (SMSServiceProvider)obj;
		smsSender.sendSMS(args[0]);
		
	}
}

class MyServiceHandler implements InvocationHandler {
	Object obj[];
	
	public MyServiceHandler(Object obj[]) {
		this.obj = obj;
	}
		
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object object = null;
		
		for(Object o: obj) {
			Method methods[] = o.getClass().getDeclaredMethods();
			for(Method m: methods) {
				if(m.getName().equals(method.getName())) {
					m.setAccessible(true);
					object = method.invoke(o, args);
				}
			}
		}
		return object;
	}
}
