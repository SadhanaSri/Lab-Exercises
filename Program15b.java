package day1;
import java.util.Scanner;

public class Program15b {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		
		Test obj = new Test();
		
		if(obj.isArmstrong(num))		
			System.out.println(num+" is a Armstrong number");
		else
			System.out.println(num+" is not an Armstrong number");
		
		if(obj.isPerfectNumber(num))
			System.out.println(num+" is a Perfect number");
		else
			System.out.println(num+" is not a Perfect number");
		
		if(obj.isPalindrome(num))
			System.out.println(num+" is a Palindrome number");
		else
			System.out.println(num+" is not a Palindrome number");
			
	}

}

class Test {
	boolean isArmstrong(int num) {
		int temp=num;
		int digit;
		int sum=0;
		
		while(num > 0) {
			digit = num%10;
			num = num/10;
			sum += (digit*digit*digit);
		}
	
		if(sum == temp) 
			return true;
		
		return false;
	}
	
	boolean isPerfectNumber(int num) {
		int sum=0;
		
		for(int i=1; i<num; i++) {
			if(num % i == 0) {
				sum+=i;
			}
		}
		
		if(sum == num)
			return true;
		
		return false;
	}
	
	boolean isPalindrome(int num) {
		int rem;
		int sum=0;
		int temp=num;
		
		while(num > 0) {
			rem = num%10;
			sum = (sum*10)+rem;
			num = num/10;
		}
		
		if(temp == sum)
			return true;
		
		return false;
	}
}
