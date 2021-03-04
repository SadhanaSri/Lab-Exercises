package day13;

import java.util.Iterator;
import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
			
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		boolean isEmpty = stack.empty();  
		System.out.println(isEmpty);
		
		int top = stack.peek();
		System.out.println("Top of the stack...."+top);
		
		int location = stack.search(1);
		System.out.println("Location of 1 : "+location);
		location = stack.search(2);
		System.out.println("Location of 2 : "+location);
		location = stack.search(3);
		System.out.println("Location of 3 : "+location);
		location = stack.search(4);
		System.out.println("Location of 4 : "+location);
		location = stack.search(5);
		System.out.println("Location of 5 : "+location);
		
		int i = stack.pop();
		System.out.println("Element popped: "+i);
	
		System.out.println("Total no. of elements: "+stack.size());
		
		Iterator iter = stack.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
}


