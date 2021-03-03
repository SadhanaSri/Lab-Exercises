package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadlockDemo {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		Crane crane = new Crane();
		Frog frog = new Frog();
		
		es.execute(() -> {
			crane.eatFrog(frog);
		});
		
		es.execute(() -> {
			frog.escape(crane);
		});
		es.shutdown();
	}
}

class Crane {
	synchronized public void eatFrog(Frog frog) {
		try{Thread.sleep(5000);}catch(Exception e) {} 
		System.out.println(" "); 
		frog.leaveCrane();
		System.out.println("Frog in crane tummy...");
	}
	synchronized public void leaveFrog() {
		System.out.println("leave frog");
	}
}

class Frog {
	synchronized public void escape(Crane crane) {
		crane.leaveFrog();
		System.out.println("Frog escaped...");
	}
	
	synchronized public void leaveCrane() {
		System.out.println("leave crane");
	}
}