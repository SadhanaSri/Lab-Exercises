package day1;
import java.util.Scanner;

public class Program16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int arr[] = new int[size];
		
		for(int i=0; i<size; i++)
			arr[i] = sc.nextInt();
		
		int key = sc.nextInt();
		Util16 obj = new Util16();
		obj.search(arr, key, size);
		sc.close();
	}

}

class Util16 {
	void search(int arr[], int key, int size) {
		int count = 0;
		int val = 0;
		int loc[] = new int[size];
		int k=0;
		
		for(int i=0; i<size; i++) {
			if(key == arr[i]) {
				count++;
				val = 1;
				loc[k++] = i+1;
			}
		}
		
		if(val == 0)
			System.out.println(key+ " is not found");
		else
			System.out.println(key+" is found "+count+" times at the location(s)");
		
		for(int i=0; i<size; i++)
			if(loc[i] != 0)
				System.out.println(loc[i]+" ");
	}
}
