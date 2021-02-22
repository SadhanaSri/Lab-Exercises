package package1;

public class MethodDemo {
	int i=1;
	float f=1.1f;
	double d=2.2;
	String s = "hello";
	char c = 'a';
	boolean b = true;
	public static void main(String args[]) {
		MethodDemo obj = new MethodDemo();
		obj.method(1,2,3,4);
		String s = obj.method2("world");
		System.out.println(s);
		obj.method1(3);
	}
	public void method(int... i) { //method with no return //var args-variable arguments
		for(int x: i) {
			System.out.println(x);
		}
//		public void test() {} illegal method declaration
		class Inner { //local inner class
			public void test() {} //legal
		}
	}
	
	public int method1() { //method with return type
		return 1;
	}
	
	public int method1(int i) { //method overloading-polymorphism
		return 1;
	}
	
	public String method2(String s) {
		return "hello"+s;
	}
	
	public Hello method3() { //complex return type
		return new Hello();
	}
}

class Hello {
	
}
