package soapdemo;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class EmployeeClient {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:2080/soapdemo/employee?wsdl");
		QName qname = new QName("http://soapdemo/", "EmployeeServiceImplService");
		
		Service service = Service.create(url, qname);

		EmployeeService emp = service.getPort(EmployeeService.class);
		System.out.println(emp.getEmployee("1").toString());
		
		EmployeeDTO emp1 = new EmployeeDTO();
		emp1.setEid(4);
		emp1.setEname("raj");
		emp1.setEsal(6789);
		
		emp.setEmployee(emp1);
		
		System.out.println(emp.getAllEmployees().toString());
	}
}
