package manytomany;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class Client1 {
	public static void main(String[] args) {
		SessionFactory factory = 
				new Configuration().
				configure("hibernate.cfg.xml").buildSessionFactory();
			
			Session session=factory.openSession();
			Transaction tx=session.beginTransaction();
			
			Employee emp=new Employee();
			emp.setEid(3);
			emp.setEname("sadhana");
			emp.setEsal(100000);
			
			Address add1=new Address();
			add1.setAid(102);
			add1.setStreet("SK Street");
			add1.setEmployee(emp);
			
			Address add2=new Address();
			add2.setAid(100);
			add2.setStreet("KS Street");
			add2.setEmployee(emp);
						
			Set<Address> aset=new HashSet<Address>();
			aset.add(add1);
			aset.add(add2);
			
			emp.setAddresses(aset);
		
			session.save(add1);
			session.save(add2);
			session.save(emp);
			
			tx.commit();
			
			emp=(Employee)session.get(Employee.class,Integer.valueOf(3));
			Collection col=emp.getAddresses();
			Iterator iter=col.iterator();
			
			while(iter.hasNext()) {
				Address add=(Address)iter.next();
				System.out.println(add.getStreet());
			}
	}
}
