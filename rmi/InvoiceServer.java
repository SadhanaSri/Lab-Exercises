package day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class InvoiceServer extends UnicastRemoteObject implements Invoice {

	private static final long serialVersionUID = 1L;
	Object obj;
	int invNo;
	
	public InvoiceServer() throws RemoteException {
		
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
	
	@Override
	public void startInvoiceApp(int choice) throws RemoteException {
		obj = new InvoiceServer();
		obj = Proxy.newProxyInstance(InvoiceServer.class.getClassLoader(),  new Class[] {Converter.class, OrderTracker.class, ReportGenerator.class},  new MyServiceHandler( new Object[] {new InvoiceConverter(), new InvoiceGenerator(), new TrackerDemo()}));	
	
			switch(choice) {
			case 1:
				try {
					ReportGenerator report = (ReportGenerator)obj; 
					report.generateInvoice();
				} catch(Exception e) {
					e.printStackTrace();
				}
			break;
			case 2:
				System.out.println("Enter invoice no");
				try {
					BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
					invNo = Integer.parseInt(br.readLine());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				OrderTracker tracker = (OrderTracker)obj;
				tracker.trackOrder(invNo);
			break;
			case 3:
				obj = new InvoiceConverter();
				System.out.println("Enter invoice no");
				try {
					BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
					invNo = Integer.parseInt(br.readLine());
					Converter conv = (Converter)obj;
					conv.doPDFConversion(invNo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			break;
			case 4:
				System.out.println("Enter invoice no");
				try {
					BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
					invNo = Integer.parseInt(br.readLine());
					Converter conv = (Converter)obj;
					conv.doExcelConversion(invNo);
				} catch (Exception e) {
//					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			}
	}
	
	
}
