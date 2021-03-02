package day11;

import java.util.Scanner;

public class Program7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num;
		String den;
		int result;
		
			do {
				System.out.println("Numerator: ");
				num = sc.next();
				System.out.println("Denominator: ");
				den = sc.next();
				try {
					result = Integer.parseInt(num)/Integer.parseInt(den);
					System.out.println("Result: "+result);
					
				} catch(ArithmeticException ae) {
					System.out.println("Enter number greater than 0");
				} catch(NumberFormatException ne) {
					if(num.charAt(0) == 'q' || num.charAt(0) == 'Q')
						System.exit(0);
					System.out.println("Enter a valid input");
				}
			} while(true);
			
	}
}
