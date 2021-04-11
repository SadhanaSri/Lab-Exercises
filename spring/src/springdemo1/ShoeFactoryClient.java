package springdemo1;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShoeFactoryClient {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
		//new FileSystemXmlApplicationContext();
		
		ShoeSeller seller=ctx.getBean("shop",ShoeSeller.class);
		
		Customer customer=ctx.getBean("name", ShoeCustomer.class);
	
		Shoe shoe=seller.sellShoe(customer);
		
		System.out.println(shoe);
	}
}
