package query;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import hibernateday1.HibernateUtility;
import manytomany.Student;
import onetomany.Address;
import onetomany.Employee;

public class EmployeeQueryClient2 {
	public static void main(String[] args) {
		EmployeeQueryClient2 obj=new EmployeeQueryClient2();
		obj.query3();
	}
	
	public static void display(Criteria criteria) {
		List<Employee> list = criteria.list();
		Iterator<Employee> iter = list.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next().getEmpname());
		}
	}
	
	public void query1() {
		Session session = HibernateUtility.getSession();
		Criteria criteria = session.createCriteria(Employee.class);
		display(criteria);
	}
	
	public void query11() {
		Session session = HibernateUtility.getSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.addOrder(Order.desc("empname"));
		display(criteria);
	}
	
	public void query2() {
		Session session = HibernateUtility.getSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Property.forName("empname").eq("sadhu"));
		Employee emp = (Employee)criteria.uniqueResult();
		System.out.println(emp.getEmpname());
	}
	
	public void query3() {
		Session session = HibernateUtility.getSession();
		Criteria criteria = session.createCriteria(Address.class);
		criteria.add(Property.forName("emp.empname").eq("sadhu"));
		List<Address> addresses = criteria.list();
		Iterator<Address> iter = addresses.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next().getCity());
		}
	}
	public void query4() {
		Session session = HibernateUtility.getSession();
		int f[] = {new Integer(20),new Integer(40)};
		Criteria criteria = session.createCriteria(Employee.class);
		
	}
//	public void query11() {
//		Session session = HibernateUtility.getSession();
//		Criteria criteria = session.createCriteria(Employee.class);
//	}
//	public void query11() {
//		Session session = HibernateUtility.getSession();
//		Criteria criteria = session.createCriteria(Employee.class);
//	}
//	public void query11() {
//		Session session = HibernateUtility.getSession();
//		Criteria criteria = session.createCriteria(Employee.class);
//	}
//	public void query11() {
//		Session session = HibernateUtility.getSession();
//		Criteria criteria = session.createCriteria(Employee.class);
//	}
}
