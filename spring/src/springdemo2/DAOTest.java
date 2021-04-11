package springdemo2;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DAOTest {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		DBDao dao = ctx.getBean("dao", DBDao.class);
		
		dao.firstTest();
		dao.secondTest();
	}
}
