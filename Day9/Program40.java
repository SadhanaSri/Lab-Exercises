package day9;

import java.util.Scanner;

public class Program40 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Prime obj = new Prime();
		
		if(obj.isPrime(num)) {
			System.out.println("Prime number");
		}		
		else {
			System.out.println("Not a prime number");
		}
		sc.close();
	}
}

class Prime {
	boolean isPrime(int num) {
		if(num <= 0) {
			return false;
		}
		else {
			for(int i=2; i<num/2; i++) {
				if(num % i == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
