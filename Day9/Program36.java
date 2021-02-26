package day9;

public class Program36 {
	public static void main(String[] args) {
		Palindrome obj = new Palindrome();
		if(obj.isNumberPalindrome(123))
			System.out.println("Palindrome Number");
		else
			System.out.println("Not a palindrome number");
		
		
		if(obj.isStringPalindrome("madam")) 
			System.out.println("Palindrome string");
		else
			System.out.println("Not a palindrome string");
	}
}

class Palindrome {
	
	boolean isNumberPalindrome(int num) {
		int temp = num;
		int dig;
		int rev=0;
		
		while(num > 0) {
			dig = num%10;
			rev = (rev*10)+dig;
			num=num/10;
		}
		
		if(temp == rev) 
			return true;
		
		return false;
	}
	
	boolean isStringPalindrome(String str) {
		int first=0;
		int last = str.length()-1;
		char ch[] = str.toCharArray();
		
		while(first < last) {
			if(ch[first] != ch[last])
				return false;
			first++;
			last--;
		} 
		return true;
	}
}
