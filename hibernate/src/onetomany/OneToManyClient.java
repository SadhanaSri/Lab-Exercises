package onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.classic.Session;

import hibernateday1.HibernateUtility;

public class OneToManyClient {
	public static void main(String[] args) {
		Session session = HibernateUtility.getSession();
		
		Employee emp = new Employee();
		emp.setEmpname("sadhana");
		emp.setEid(1);
		emp.setEmpsal(200000);
		
		Employee emp2 = new Employee();
		emp2.setEmpname("sadhu");
		emp2.setEid(1);
		emp2.setEmpsal(205000);
		
		Address add1 = new Address();
		add1.setStreet("SK Street");
		add1.setCity("Pollachi");
		add1.setEmp(emp);
		add1.setEmp(emp2);
		
		Address add2 = new Address();
		add2.setStreet("KS Street");
		add2.setCity("Bangalore");
		add2.setEmp(emp);
		add2.setEmp(emp2);
		
		Set<Address> set = new HashSet<Address>();
		
		set.add(add1);
		set.add(add2);
		
		emp.setAddresses(set);
		emp2.setAddresses(set);
		
		session.save(emp);
//		session.save(emp2);
		
		HibernateUtility.closeSession(null);

	}
}
