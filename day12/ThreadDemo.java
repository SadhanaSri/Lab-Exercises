package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {
	public ThreadDemo() {
//		Thread t = new Thread((new ThreadJob()));  //new thread created
//		t.start();                                //calls the run() method
		ExecutorService es=Executors.newFixedThreadPool(1); //creating thread through executor framework
		es.execute(new ThreadJob());
		es.shutdown();
	}
	public static void main(String[] args) throws InterruptedException {
		new ThreadDemo();
		
		for(int i=0; i<5; i++) {
			System.out.println(i);
			Thread.sleep(1000); //main thread waits for 1s and child thread runs
		}
	}
}

//runnable - to create a job for the thread
class ThreadJob implements Runnable {
	@Override
	public void run() { //resides in the semaphore when main thread is running
		System.out.println("Child thread...");	
		run2();
	}
	
	public void run2() {
		System.out.println("Child thread method called......");
	}
}