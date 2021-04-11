package inheritance;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import hibernateday1.HibernateUtility;

public class ReadClient {
	public static void main(String[] args) {
		Session session = HibernateUtility.getSession();
		
		Query query = session.createQuery("from ShoeFactory");
		
		List<ShoeFactory> list = query.list();
		
		Iterator<ShoeFactory> iter = list.iterator();
		
		while(iter.hasNext()) {
			ShoeFactory fac = iter.next();
			fac.visit();
		}
		
		HibernateUtility.closeSession(null);
	}
}
