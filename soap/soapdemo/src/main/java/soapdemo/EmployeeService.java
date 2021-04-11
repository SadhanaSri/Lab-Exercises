package soapdemo;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface EmployeeService {
	@WebMethod
	public void setEmployee(EmployeeDTO emp);
	@WebMethod
	public EmployeeDTO getEmployee(String eid);
	@WebMethod
	public List<EmployeeDTO> getAllEmployees();
}

