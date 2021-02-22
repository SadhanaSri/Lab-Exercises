package day1;

public class Program17b {
	public static void main(String args[]) {
		Demo obj = new Demo();
		obj.nonStaticMethod();
		Demo.staticMethod();
	} 
}

class Demo {
	static int var1 = 1;
	int var2 = 2;
	
	void nonStaticMethod() {
		System.out.println(var1);
	}
	
	/*
	 * 	Instance methods can access instance variables and instance methods directly.
		Instance methods can access class variables and class methods directly.
		Class methods can access class variables and class methods directly.
		Class methods cannot access instance variables or instance methods directly—they must use an object reference. 
		Class methods cannot use the this keyword as there is no instance for this to refer to.
	 */
	
	static void staticMethod() {
//		System.out.println(var2);
		Demo obj = new Demo();
		System.out.println(obj.var2);
	}

}
