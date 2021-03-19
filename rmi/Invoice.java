package day19;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Invoice extends Remote {
	public void startInvoiceApp(int choice) throws RemoteException;
}
