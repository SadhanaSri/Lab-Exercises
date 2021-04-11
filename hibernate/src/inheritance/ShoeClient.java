package inheritance;

import org.hibernate.classic.Session;

import hibernateday1.HibernateUtility;

public class ShoeClient {
	public static void main(String[] args) {
		Session session = HibernateUtility.getSession();
		ShoeFactory factory = new ShoeFactory();
		factory.setFactoryName("ShoeFactory");
		
		BataShoeFactory bsf = new BataShoeFactory();
		bsf.setFactoryName("Bata Shoe Factory");
		bsf.setBSFShoeName("Bata Shoe");
		
		NikeShoeFactory nsf = new NikeShoeFactory();
		nsf.setFactoryName("Nike Shoe Factory");
		nsf.setNSFShoeName("Nike Shoe");

		session.save(factory);
		session.save(bsf);
		session.save(nsf);
		
		HibernateUtility.closeSession(null);
	}
}
