package day9;

public class Program50 {
	public static void main(String args[]){  
		Puppy pup=new Puppy();  
	    pup.weep();  
		pup.bark();  
		pup.eat();  
	}
}

class Animal{  
	void eat() {
		System.out.println("eating...");
	}  
}  
class Dog extends Animal{  
	void bark() {
		System.out.println("barking...");
	}  
}  
class Puppy extends Dog{  
	void weep(){
		System.out.println("weeping...");
	}
}