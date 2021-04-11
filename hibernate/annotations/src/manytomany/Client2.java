package manytomany;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class Client2 {
	public static void main(String[] args)throws Exception {
		SessionFactory factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee emp=new Employee();
		emp.setEid(1);
		emp.setEname("sadhu");
		emp.setEsal(130000);

		Set<Employee> set1=new HashSet();
		set1.add(emp);
		
		Training t1=new Training();
		t1.setTid(1);
		t1.setTname("java");
		t1.setEmployee(set1);
		
		Training t2=new Training();
		t2.setTid(2);
		t2.setTname("spring");
		t2.setEmployee(set1);
		
		Set<Training> set = new HashSet<>();
		set.add(t1);
		set.add(t2);		
		emp.setTrainings(set);
		
		session.saveOrUpdate(emp);
		session.save(t1);
		session.save(t2);
		
		tx.commit();
		
		emp=(Employee)session.get(Employee.class,new Integer(1));
		Collection col=emp.getTrainings();
		Iterator iter=col.iterator();
		while(iter.hasNext())
		{
			Training add=(Training)iter.next();
			System.out.println(add.getTname());
		}
	}
}
