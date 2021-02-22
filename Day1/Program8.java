package day1;
import java.util.Scanner;

public class Program8 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int arr[] = new int[size];
		
		for(int i=0; i<size; i++) {
			arr[i] = sc.nextInt();
		}
		
		int key = sc.nextInt();
		sc.close();
		Util8 obj = new Util8();
		int loc = obj.searchLocation(arr, key);
		
		if(loc == -1) 
			System.out.println("Key not found");
		
		System.out.println("First location of "+key+" is "+loc);
	}
}

class Util8 {
	int searchLocation(int arr[], int key) {
		
		for(int i=0; i<arr.length; i++) {
			if(key == arr[i]) {
				return i+1; 
			}
		}
		
		return -1;
	}
}