package day8;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StackDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Fixed Stack 2.Dynamic Stack");
		Stack fixedStack = new FixedStack(5);
		int flag=0;
		int ch;
		
		while(flag != 1) {
			System.out.println("=============FIXED STACK============\n1.Push\n2.Pop\n3.Exit");
			ch = sc.nextInt();
			
			switch(ch) {
			case 1:	
				System.out.println("Enter element to push: ");
				int val = sc.nextInt();
				if(fixedStack.push(val))
					System.out.println("Element pushed.");
				else
					System.out.println("Stack full.");
				break;
			case 2:
				int ele = fixedStack.pop();
				System.out.println("Element "+ele+" popped");
				break;
			case 3:
				flag=1;
			}
		}
		flag=0;
		
		
		while(flag != 1) {
			System.out.println("=============DYNAMIC STACK==========\n1.Push\n2.Pop\n3.Exit");
			Stack dynamicStack = new DynamicStack();
			ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter element to push: ");
				int val = sc.nextInt();
				dynamicStack.push(val);
				System.out.println("Element pushed.");
				break;
			case 2:
				int ele = dynamicStack.pop();
				System.out.println("Element "+ele+" popped");
				break;
			case 3:
				flag=1;
			}
		}
		sc.close();
	}
}

interface Stack {
	boolean push(int val);
	int pop();
}

class FixedStack implements Stack {
	int size;
	int top;
	int stack[];
	
	public FixedStack(int size) {
		this.size = size;
		this.top = -1;
		stack = new int[size];
	}
	
	@Override
	public int pop() {
		if(isEmpty())
			System.out.println("Stack is Empty");
		else
			return stack[top--];
		return 0;
	}
	
	boolean isEmpty() {
		if(top <= -1)
			return true;
		return false;
	}
	
	boolean isFull() {
		if(top >= size-1)
			return true;
		return false;
	}
	
	public boolean push(int val) {
		if(isFull())
			return false;
		stack[++top] = val;
		return true;
	}
	
}

class DynamicStack implements Stack {

	List<Integer> stack;
	int top;
	
	public DynamicStack() {
		stack = new ArrayList<>();
		top=-1;
	}
	
	@Override
	public int pop() {
		if(isEmpty())
			System.out.println("Stack is empty");
		else
			return stack.get(top--); 
		return -1;
	}
	
	boolean isEmpty() {
		return top<=-1;
	}
	
	public boolean push(int val) {
		stack.add(val);
		top++;
		return true;
	}
}
