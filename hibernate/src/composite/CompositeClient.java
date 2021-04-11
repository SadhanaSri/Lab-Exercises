package composite;

import org.hibernate.classic.Session;

import hibernateday1.HibernateUtility;

public class CompositeClient {
	public static void main(String[] args) {
		Session session = HibernateUtility.getSession();
		
		CompKey comp1 = new CompKey();
		comp1.setInv_id(1);
		comp1.setItem_id(1);
		
		Invoice inv = new Invoice();
		inv.setCompkey(comp1);
		inv.setDetails("Invoice 1");
		
		session.save(inv);
//		session.save(comp1);
		
		HibernateUtility.closeSession(null);
	}
}
