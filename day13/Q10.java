package day13;

import java.util.PriorityQueue;

public class Q10 {
public static void main(String[] args) {
	 PriorityQueue<String> pq = new PriorityQueue<String>(); 
	 pq.add("2"); 
	 pq.add("4"); 
	 System.out.print(pq.peek() + " "); //2
	 pq.offer("1"); 
	 pq.add("3"); 
	 pq.remove("1"); 
	 System.out.print(pq.poll() + " "); //2
	 if(pq.remove("2")) System.out.print(pq.poll() + " "); //3 
	 System.out.println(pq.poll() + " " + pq.peek()); //4
}
}
