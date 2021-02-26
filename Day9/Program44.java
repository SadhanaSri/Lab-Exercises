package day9;

import java.util.Scanner;

public class Program44 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int arr1[] = new int[5];
		int arr2[] = new int[5];
		
		for(int i=0; i<5; i++) {
			arr1[i] = sc.nextInt();
		}

		
		for(int i=0; i<5; i++) {
			arr2[i] = sc.nextInt();
		}
		
		System.out.println("Array1 before swapping: ");
		for(int i=0; i<5; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println("\nArray2 before swapping: ");
		for(int i=0; i<5; i++) {
			System.out.print(arr2[i]+" ");
		}
		
		for(int i=0; i<5; i++) {
			arr1[i] = arr1[i]+arr2[i];
			arr2[i] = arr1[i]-arr2[i];
			arr1[i] = arr1[i]-arr2[i];
		}
		
		System.out.println("Array1 after swapping: ");
		for(int i=0; i<5; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println("\nArray2 after swapping: ");
		for(int i=0; i<5; i++) {
			System.out.print(arr2[i]+" ");
		}
	}

}
