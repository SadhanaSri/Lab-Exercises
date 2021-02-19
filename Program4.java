package day1;
import java.util.Scanner;

public class Program4 {

	public static void main(String[] args) {
		Util4 obj = new Util4();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if(obj.isPrime(num)) {
			System.out.println(num+ " is a Prime Number");
		}
		else {
			System.out.println(num+ " is not a Prime Number");
		}
		sc.close();
	}

}

class Util4 {
	boolean isPrime(int num) {
		if(num <= 1) 
			return false;
		
		if(num<=3)
			return true;
		
		for(int var=2; var<=num/2; var++) {
			if(num%var == 0) {
				return false;
			}
		}
		
		return true;
	}
}
