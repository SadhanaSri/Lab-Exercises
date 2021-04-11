package onetomany;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.classic.Session;

import hibernateday1.HibernateUtility;

public class OneToManyReadCLient {
	public static void main(String[] args) {
		Session session = HibernateUtility.getSession();
		Employee emp = (Employee) session.get(Employee.class, Integer.valueOf(1));
		
		System.out.println(emp.getEmpname());
		
		Set<Address> set = emp.getAddresses();
		Iterator<Address> iter = set.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next().toString());
		}
		
		HibernateUtility.closeSession(null);
	}
}
