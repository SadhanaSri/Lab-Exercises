package day11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program8 {
	
	public static void main(String[] args) {
		int n=1;
		int mark;
		int sum=0;
		
		Program8 obj = new Program8();
		
			do {
				try {
					n++;
					mark = obj.getInput();
					sum += mark;
				} catch(InputMismatchException e) {
					n = n-1;
					System.out.println("Enter a valid integer value");
					continue;
				}
			} while(n <= 10);	
			
		System.out.println("Average mark of 10 students: "+sum/10);
	}
	
	int getInput() {
		Scanner sc = new Scanner(System.in);
		int num =  sc.nextInt();
		return num;
	}
}

	
