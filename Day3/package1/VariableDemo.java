package package1;

public class VariableDemo {
	public static void main(String[] args) {
		TrainingRoom room1 = new TrainingRoom();
		TrainingRoom room2 = new TrainingRoom();
	}
}

/*
 * constructor- a special method that is called when the object of the class is created
 * the properties needed for the mere survival of the object are initialized here
 * default constructor - Object class constructor - Object class is extended by all the classes by default 
 */

class Chalk {
	public Chalk() {
		System.out.println("Chalk object is created");
	}
}

class Canteen {
	Canteen() { // constructor
		System.out.println("Canteen object is created");
	}
}

class Projector {
	Projector() {
		System.out.println("Projector object is created");
	}
}

class TrainingRoom {
	TrainingRoom() {
		System.out.println("Training room object is created");
	}
	Projector projector = new Projector();
	//to restrict the number of objects created, make use of static which means only a single instance is created 
	static Canteen canteen = new Canteen(); 
}

/* a non-static variable inside a class outside a method is an instance variable
*  a non-static variable inside a class inside a method is a local variable
*  a static variable inside a class inside a method is illegal
*  a static variable inside a class outside a method is a class variable
*  static variable are instantiated by the JVM, only one copy is created
*/

