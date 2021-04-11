package manytomany;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.classic.Session;

import hibernateday1.HibernateUtility;

public class ManyToManyClient {
	public static void main(String[] args) {
		Session session = HibernateUtility.getSession();
		
		Student student = new Student();
		student.setSname("sadhana");
		student.setMarks(1190);
		
		Training training1 = new Training();
		training1.setTname("java training");
		training1.setTstartdate(LocalDate.now().plusDays(3));
		
		Training training2 = new Training();
		training2.setTname("sql training");
		training2.setTstartdate(LocalDate.now().plusDays(4));
		
		Set<Training> set = new HashSet<Training>();
		
		set.add(training1);
		set.add(training2);
		
		student.setTrainings(set);
		
		session.save(student);
		session.save(training1);
		session.save(training2);
		
		HibernateUtility.closeSession(null);
	}
}
