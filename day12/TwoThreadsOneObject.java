package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwoThreadsOneObject {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		RailwayReservation counter = new RailwayReservation();
		
		es.execute(() -> {
			Thread.currentThread().setName("ramu");
//   pessimistic lock - creates a monitor such that no other thread is allowed until the current thread job is completed
			synchronized(counter) { 
				counter.bookTicket(1000);
				counter.giveChange();
			}
		});
		
		es.execute(() -> {
			Thread.currentThread().setName("somu");
			synchronized(counter) {
				counter.bookTicket(500);
				counter.giveChange();
			}
		});

	}

}

class RailwayReservation {
	int amount;
//  optimistic lock - in case of any interruptions, allows other waiting thread to do its job
//	synchronized 
	public void bookTicket(int amount) {
		this.amount = amount;
		Thread t = Thread.currentThread();
		try {Thread.sleep(1000);} catch(Exception e) {}
		System.out.println("Ticket booked by "+t.getName()+" for " +amount);
	}
	
//	synchronized 
	public void giveChange() {
		Thread t = Thread.currentThread();
		System.out.println("Change given to "+t.getName()+" amount is "+(amount-100));
	}
}