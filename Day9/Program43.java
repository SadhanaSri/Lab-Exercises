package day9;

import java.util.Scanner;

public class Program43 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a[] = new int[5];
		
		for(int i=0; i<5; i++) {
			a[i] = sc.nextInt();
		}
		
		int biggest=Integer.MIN_VALUE;
		int lowest=Integer.MAX_VALUE;
		
		for(int i=0; i<5; i++) {
			if(a[i] > biggest)
				biggest=a[i];
			if(a[i] < lowest)
				lowest = a[i];
		}
		
		System.out.println("Biggest: "+biggest);
		System.out.println("Lowest: "+lowest);
		sc.close();
	}

}
