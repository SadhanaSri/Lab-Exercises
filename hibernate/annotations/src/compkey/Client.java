package compkey;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class Client {
	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Invoice inv = new Invoice();
		CompKey ck = new CompKey();
		
		ck.setItem_id(1000);
		ck.setInv_id(100);
		
		inv.setCompkey(ck);
		inv.setDetails("Invoice 100");
		
		session.save(inv);
		session.beginTransaction().commit();
	}
}
