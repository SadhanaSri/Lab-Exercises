package day1;
import java.util.Scanner;

public class Program7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int arr[] = new int[size];
		
		for(int i=0; i<size; i++)
			arr[i] = sc.nextInt();
		
		Util7 obj = new Util7();
		obj.SortAscending(arr, size);
		obj.SortDescending(arr, size);
		
		sc.close();
	}
}

class Util7 {
	int temp;
	void SortAscending(int arr[], int size) {
		for(int var1=0; var1<size; var1++) {
			for(int var2=var1+1; var2<size; var2++) {
				if(arr[var1] > arr[var2]) {
					temp = arr[var1];
					arr[var1] = arr[var2];
					arr[var2] = temp;
				}
			}
		}
		System.out.println("Elements in Ascending Order:");
		for(int var1=0; var1<size; var1++)
			System.out.print(arr[var1]+" ");
	}
	
	void SortDescending(int arr[], int size) {
		for(int var1=0; var1<size; var1++) {
			for(int var2=var1+1; var2<size; var2++) {
				if(arr[var1] < arr[var2]) {
					temp = arr[var1];
					arr[var1] = arr[var2];
					arr[var2] = temp;
				}
			}
		}
		System.out.println("\nElements in Descending Order:");
		for(int var1=0; var1<size; var1++)
			System.out.print(arr[var1]+" ");
	}
}
