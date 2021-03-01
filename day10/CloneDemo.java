package day10;

public class CloneDemo {
	public static void main(String[] args) throws Exception {
		Sheep sheep1 = new Sheep();
		sheep1.name = "sheep 1";
		Sheep sheep2 = sheep1.getSheepClone();
		sheep2.name = "sheep 2";
		
		System.out.println("Sheep 1 name: "+sheep1.name);
		System.out.println("Sheep 2 name: "+sheep2.name);
		
		Test1 test1=sheep1.getTestClone();
		test1.amount=10000;
		Test1 test2 = sheep2.getTestClone();
		test2.amount=20000;
		
		System.out.println("Test1 amount...:"+test1.amount);		
		System.out.println("Test2 amount...:"+test2.amount);
	}
}

class Sheep implements Cloneable {
	String name; //primitive type will be unique
	Test1 test; //complex type not unique.has to be cloned.
	
	public Sheep() {
		System.out.println("Sheep constructor...");
	}
	
	public Sheep getSheepClone() throws Exception {
		return (Sheep)super.clone();
	}
	
	public Test1 getTestClone() throws Exception {
		return Test1.getTestObj().getTestClone();
	}
}

abstract class Parent {
	public Test1 getTestClone() throws Exception {
		return (Test1)super.clone();
	}
}

class Test1 implements Cloneable {
	int amount;
	public Test1 getTestClone() throws Exception {
		return (Test1)super.clone();
	}
	
	private static Test1 test;
	
	public static Test1 getTestObj() {
		if(test == null) 
			test = new Test1();
		return test;
	}
	
	private Test1() {
		System.out.println("Test class");
	}
}