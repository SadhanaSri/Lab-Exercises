package annospring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShoeClient {
	public static void main(String[] args) {
		try {
			ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("annoconfig.xml");
			ShoeShop shop = (ShoeShop)ctx.getBean("gokulShoeShop", GokulShoeShop.class);
			Customer cust = new ShoeCustomer("sadhana");
			Shoe shoe = shop.sellShoe(cust);
			
			System.out.println(shoe);
			ctx.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
