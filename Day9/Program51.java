package day9;

public class Program51 {

	public static void main(String[] args) {
		Child c = new Child();
		c.method();
	}
}

class Parent {
	int i;
	
	void method() {
		i=10;
		System.out.println("Value of i in Parent: "+i);
	}
}

class Child extends Parent {
	void method() {
		super.method();
		System.out.println("Value of i in Child: "+i); 
		System.out.println("Value of i using super: "+super.i);
		//cannot access the value of parent class variable
	}
}