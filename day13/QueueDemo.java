package day13;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {
	public static void main(String[] args) {
		Queue<Worker> q = new PriorityQueue<Worker>();
		
		Worker w1 = new Worker(1, "ramu");
		Worker w2 = new Worker(2, "raja");
		Worker w3 = new Worker(3, "somu");
		Worker w4 = new Worker(4, "rajesh");

		q.add(w1);
		q.add(w2);
		q.add(w3);
		q.add(w4);
		
		for(Worker w: q) {
			System.out.println(w.id +":"+w.name);
		}
		
		System.out.println("Removed worker..."+q.remove(w1));
		System.out.println("Head of the queue removed using poll()..."+q.poll());
		System.out.println("Head of the queue retrieved, not removed..."+q.element());
		System.out.println("Head of the queue retrieved, not removed..."+q.peek());
		
		Iterator iter = q.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}

class Worker implements Comparable<Worker>{
	int id;
	String name;
	
	public Worker(int id, String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public int compareTo(Worker o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String toString() {
		return "id:" + id + " name:" + name;
	}	
}


