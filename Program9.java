package day1;
import java.util.Scanner;

public class Program9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int arr[] = new int[size];
		
		for(int i=0; i<size; i++)
			arr[i] = sc.nextInt();
		
		
		Util9 obj = new Util9();
		int rev[] = new int[size];
		rev = obj.reverseArray(arr, size);
		System.out.println("Reversed array: ");
		
		for(int var=0; var<size; var++) 
			System.out.print(rev[var]+" ");
		
		sc.close();
	}

}

class Util9 {
	int[] reverseArray(int arr[], int size) {
		int last=size-1;
		int first=0;
		int temp;
	
		while(first<last) {
			temp = arr[first];
			arr[first] = arr[last];
			arr[last] = temp;
			first++;
			last--;
		}
		return arr;
	}
}
