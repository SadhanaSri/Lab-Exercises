package day1;
import java.util.Scanner;

public class Program6 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[5];
		
		System.out.println("Size of the array: "+arr.length);
		System.out.println("Enter the array elements");
		
		for(int i=0; i<5; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Enter new array size");
		int size = sc.nextInt();
		sc.close();
		arr = new int[size];
		System.out.println("New size of the array: "+arr.length);
	}
}
