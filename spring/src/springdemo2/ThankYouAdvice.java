package springdemo2;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class ThankYouAdvice implements AfterReturningAdvice {
	@Override
	public void afterReturning(Object methodreturn, Method method, Object[] arguments, Object bean) throws Throwable {
		System.out.println("Order processing........"+methodreturn);
		System.out.println("Thank You! Visit Again!");
	}
}
