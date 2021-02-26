package day9;

import java.util.Scanner;

public class Program33 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Even numbers upto "+n);
		for(int i=1; i<=n; i++) {
			if(i%2 == 0) {
				System.out.println(i+"  ");
			}
		}
		sc.close();
	}

}
