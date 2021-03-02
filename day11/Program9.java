package day11;

import java.util.Scanner;

public class Program9 {
	
	public static void main(String[] args) {
		int n=1;
		int mark;
		int sum=0;
		
		Program9 obj = new Program9();
		
		do {
			n++;
			mark = obj.getInput();				
			
			try {
			    if(mark < 0)  
				throw new NegativeInputException("Please enter a positive number");
			    else if(mark > 100)
				throw new LimitExceededException("Please enter a value below 100");
			 } catch(Exception e) {
			     n = n-1;
			 }
		         
			 sum += mark;
		} while(n <= 10);	
			
		System.out.println("Average mark of 10 students: "+sum/10);
	}
	
	public int getInput() {
		Scanner sc = new Scanner(System.in);
		int num =  sc.nextInt();
		return num;
	}
}

class NegativeInputException extends Exception {
	public NegativeInputException(String msg) {
		System.out.println(msg);
	}
}

class LimitExceededException extends Exception {
	public LimitExceededException(String msg) {
		System.out.println(msg);
	}
}
