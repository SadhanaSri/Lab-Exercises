package day9;

import java.util.Scanner;

public class Program31 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int ans;
		
		char op = sc.next().charAt(0);
		
		switch(op) {
		case '+':
			ans = num1+num2;
			System.out.println(num1+"+"+num2+"="+ ans);
			break;
		case '-':
			ans = num1-num2;
			System.out.println(num1+"-"+num2+"="+ ans);
			break;
		case '*':
			ans = num1*num2;
			System.out.println(num1+"*"+num2+"="+ ans);
			break;
		case '/':
			ans = num1/num2;
			System.out.println(num1+"/"+num2+"="+ ans);
			break;
		}
		
	}

}
