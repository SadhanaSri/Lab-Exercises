package day1;
import java.util.HashMap;
import java.util.Scanner;

public class Program18 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
			
		Program18 obj = new Program18();
		int rev = obj.reverse(num);
		System.out.println(obj.numberToWords(rev));
	}
	static int flag=0;
	int reverse(int num) {
		int digit;
		int rev=0;
				
		while(num > 0) {
			digit = num%10;
			if(digit == 0)
				flag=1;
			num = num/10;
			rev = rev*10+digit;
		}	
		return rev;
	}
	
	String numberToWords(int rev) {
		int n;
		
		HashMap<Integer, String> map = new HashMap<>();
		map.put(0, "zero ");
		map.put(1, "one ");
		map.put(2, "two ");
		map.put(3, "three ");
		map.put(4, "four ");
		map.put(5, "five ");
		map.put(6, "six ");
		map.put(7, "seven ");
		map.put(8, "eight ");
		map.put(9, "nine ");
		
		String ans ="";
		
		while(rev != 0) {
			n = rev%10;
			rev=rev/10;
			ans=ans+map.get(n);
		}
		
		if(flag == 1)
			ans+="zero";
		
		return ans;
	}

}
