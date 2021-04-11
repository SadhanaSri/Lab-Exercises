package soapdemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "soapdemo.EmployeeService")
@HandlerChain(file = "soapdemo/handler-chain.xml")
public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDTO emp;
	List<EmployeeDTO> list=new ArrayList<>();
	
	public EmployeeServiceImpl() {
		emp=new EmployeeDTO(1,"ramu",1000);
		list.add(emp);
		emp=new EmployeeDTO(2,"somu",2000);
		list.add(emp);
	}
	
	@WebMethod
	@Override
	public void setEmployee(EmployeeDTO emp) {
		this.emp=emp;
		list.add(emp);
		
	}

	
	@Override
	public String toString() {
		return "EmployeeServiceImpl [emp=" + emp + ", list=" + list + "]";
	}

	@WebMethod
	@Override
	public EmployeeDTO getEmployee(String eid) {
		Iterator<EmployeeDTO> iter=list.iterator();
		int eidnum=Integer.parseInt(eid);
		while(iter.hasNext()) {
			EmployeeDTO e=iter.next();
			if(e.getEid()==eidnum) {
				return e;
			}
			else {
				return null;
			}
		}
		return null;
	}

	@WebMethod
	@Override
	public List<EmployeeDTO> getAllEmployees() {
		return this.list;
	}
}
