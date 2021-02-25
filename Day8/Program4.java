package inheritance;

import java.util.Scanner;

public class Program4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		
		Stack stack = new Stack();
		System.out.println("1.Push 2.Pop 3.Display");
		int ch = sc.nextInt();
		
		switch(ch) {
		case 1:
			stack.push(sc.nextInt());
			break;
		case 2:
			stack.pop();
			break;
		case 3:
			stack.display();
			break;
		}
					
		sc.close();
	}
	
	
}

class Stack {
	int top;
	int arr[] = new int[5];
	
	Stack() {
		top = -1;
	}
	
	boolean push(int val) {
		if(top >= 5) {
			System.out.println("Overflow");
			return false;
		} 
		else {
			arr[top++] = val;
			System.out.println("Value pushed");
			return true;
		}
	}
	
	boolean pop() {
		if(top == -1) {
			System.out.println("Underflow");
			return false;
		}
		else {
			top--;
			System.out.println("Value popped");
			return true;			
		}
	}
	
	void display() {
		for(int i=top; i>=0; i--) {
			System.out.println(arr[i]);
		}
	}
}