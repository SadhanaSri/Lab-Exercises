package day19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import day19.InvoiceServer.MyServiceHandler;


public class InvoiceClient {
	public static void main(String[] args) throws Exception, RemoteException, NotBoundException {
		Invoice inv = (Invoice)Naming.lookup("rmi://localhost:1099/myinvoiceapp");
		while(true) {
			System.out.println("Enter your choice");
			System.out.println("1.Generate new invoice");
			System.out.println("2.Calculate delivery date and time");
			System.out.println("3.Generate PDF of invoice");
			System.out.println("4.Generate Excel of invoice");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int choice = Integer.parseInt(br.readLine());
			inv.startInvoiceApp(choice);
			
		}
		
	}
}
