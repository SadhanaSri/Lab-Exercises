package day9;

import java.util.Scanner;

public class Program38 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Fibonacci obj = new Fibonacci();
		obj.printFibonacci(n);
	}
}

class Fibonacci {
	void printFibonacci(int n) {
		int a=0;
		int b=1;
		int c=a+b;
		System.out.print(a+" "+b+" "+c+" ");
		
		for(int i=1; i<=n-3; i++) {
			a=b;
			b=c;
			c=a+b;
			System.out.print(c+" ");
		}
		
	}
}