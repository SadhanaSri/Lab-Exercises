package springaop;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	public static void main(String[] args) throws Exception {
		 ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("aopconfig.xml");
		 CustomerBo customer = (CustomerBo) ctx.getBean("customerBo"); 

		 customer.addCustomer();
		 customer.addCustomerReturnValue();
//		 customer.addCustomerThrowException();
		 customer.addCustomerAround("sadhana");
		 ctx.close();
	}
}
