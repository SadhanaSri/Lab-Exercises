package day15.component;

import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class ComponentDemo {
	public static void main(String[] args) throws Exception {
		Object obj = new ComponentDemo();
		obj = Proxy.newProxyInstance(ComponentDemo.class.getClassLoader(), new Class[] {XMLToExcel.class}, new MyInvocationHandler(new WriteToExcel()));
		XMLToExcel con = (XMLToExcel)obj;
		con.writeData();
	}
}

class MyInvocationHandler implements InvocationHandler {
	Object obj;

	MyInvocationHandler(Object obj) {
		this.obj=obj;
	}

	@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("invoke method called");
			Object o = method.invoke(obj, args);
			return o;
	}
}


