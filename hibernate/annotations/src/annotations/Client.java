package annotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class Client {
	public static void main(String[] args) {
		
		SessionFactory factory =
			new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Employee employee1 = new Employee();
		employee1.setId(200);
		employee1.setName("Sadhana");
		employee1.setJoiningDate(LocalDate.now());
		employee1.setJoiningTime(LocalTime.now());
		employee1.setJoiningDateTime(LocalDateTime.now());
		employee1.setSalary(new BigDecimal(10000));
		employee1.setSsn("a1");
		
		session.save(employee1);	
		
		tx.commit();
		session.close();
	}
}	
