package day6;

public class OverridingDemo {

	public static void main(String[] args) {
		ParentClass obj = new ChildClass();
		obj.method();
		obj.myMethod();
	}

}

class ParentClass {
	public void method() {
		System.out.println("Parent method invoked");
	}
	final void myMethod() {
		System.out.println("myMethod cannot be overridden.");
	}
}

class ChildClass extends ParentClass {
	public void method() {
		System.out.println("Child method invoked");
	}
//	void myMethod() {};
	
}
