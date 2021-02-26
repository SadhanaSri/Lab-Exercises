package day9;

import java.util.Scanner;

public class Program37 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum=0;
		int temp = num;
		int dig;
		
		while(num > 0) {
			dig = num%10;
			sum+=dig;
			num=num/10;
		}
		
		System.out.println("Sum of digits of "+temp+" :"+sum);
	}
}
