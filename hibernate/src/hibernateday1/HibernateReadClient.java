package hibernateday1;

import org.hibernate.classic.Session;

public class HibernateReadClient {
	public static void main(String[] args) {
		Session session = HibernateUtility.getSession();
		
		BookDTO bookObj=(BookDTO)session.get(BookDTO.class, Integer.valueOf(1));
		
        System.out.println(bookObj);
		
		Comment comm=bookObj.getComment();
		
		System.out.println(comm.getMsg());
	}
}
