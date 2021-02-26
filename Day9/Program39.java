package day9;

import java.util.Scanner;

public class Program39 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Tables obj = new Tables();
		obj.printTables(num);
	}
}

class Tables {
	void printTables(int num) {
		int i=1;
		do {
			System.out.println(num+"*"+i+"="+(num*i));
			i++;
		}while(i<=10);
	}
}
