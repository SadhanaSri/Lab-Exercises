package soapdemo;

import java.net.InetAddress;
import java.net.NetworkInterface;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "soapdemo.MacAddressValidator")
@HandlerChain(file = "soapdemo/handler-chain.xml")

public class MacAddressValidatorImpl implements MacAddressValidator {
	@WebMethod
	@Override
	public String getMacAddress() {
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			NetworkInterface ni = NetworkInterface.getByInetAddress(localHost);
			byte[] hardwareAddress = ni.getHardwareAddress();
			String[] hexadecimal = new String[hardwareAddress.length];
			for (int i = 0; i < hardwareAddress.length; i++) {
			    hexadecimal[i] = String.format("%02X", hardwareAddress[i]);
			}
			String macAddress = String.join("-", hexadecimal);
			return macAddress;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
