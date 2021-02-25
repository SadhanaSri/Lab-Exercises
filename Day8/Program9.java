package inheritance;

public class Program9 {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		
//		a.method1();
		a.method2();
		a.method3();
		b.method();
	}
}

class A {
	private int i = 10;
	protected int j = 20;
	public int k = 30;
	
	private void method1() {
		System.out.println("Method 1");
	}
	
	protected void method2() {
		System.out.println("Method 2");
	}
	
	public void method3() {
		System.out.println("Method 3");
	}
}

class B extends A {
	void method() {
//		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
		method2();
		method3();
//		method1();
	}
}
