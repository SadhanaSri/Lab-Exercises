package annospring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnoClient {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		
		System.out.println(ctx.getBean("getH"));
		ctx.close();
	}
}
