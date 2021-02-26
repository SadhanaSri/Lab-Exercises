package day9;
import java.util.Scanner;

public class Program32 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		PrimeOrNot obj = new PrimeOrNot();
		
		if(obj.isPrime(num)) {
			System.out.println("Prime number");
		}		
		else {
			System.out.println("Not a prime number");
		}
	}
}

class PrimeOrNot {
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
