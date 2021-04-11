package hibernateday1;

import org.hibernate.classic.Session;

public class HibernateClient {
	public static void main(String[] args) {
		BookDTO bookDTO = new BookDTO(1, "java", "james", 350);
		
		Comment comm = new Comment();
		comm.setMsg("Comments....");
		
		bookDTO.setComment(comm);
		
//		SessionFactory factory = cfg.configure().buildSessionFactory();
		
		Session session = HibernateUtility.getSession();
		
		session.save(bookDTO);
		
		session.beginTransaction().commit();
	}
}
