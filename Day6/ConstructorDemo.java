package day6;

public class ConstructorDemo {

	public static void main(String[] args) {
		Parent obj = new Child();
		obj.method();
	}

}

class Parent {
	public Parent() {
		System.out.println("ParentClass con invoked..");
	}
	
	public Parent(int i) {
		System.out.println("Parent parameterized constructor called");
	}
	
	public void method() {
		System.out.println("Parent method..");
	}
}

class Child extends Parent {
	public Child() {
		super(10);
		System.out.println("ChildClass con invoked");
	}
	
	public void method() {
		super.method();
		System.out.println("Child method");
	}
}
