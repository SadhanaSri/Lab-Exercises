package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwoThreadsOneObjectOneJob {
	public static void main(String[] args) {
		Gun gun = new Gun();
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		es.execute(() -> {
			for(int i=0; i<5; i++) {
				gun.fill();
			}
		});
		
		es.execute(() -> {
			for(int i=0; i<5; i++) {
				gun.fire();
			}
		});
		
		es.shutdown();
	}
}

class Gun {
	boolean flag;
	synchronized public void fill() {
		if(flag) {
			try {
				wait();
			} catch(Exception e) { }
		}
		System.out.println("Filling gun......");
		flag = true;
		notify();
	}
	
	synchronized public void fire() {
		if(!flag) {
			try {
				wait();
			} catch(Exception e) { }
		}
		System.out.println("Firing gun.......");
		flag=false;
		notify();
	}
}