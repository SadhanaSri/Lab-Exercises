package day5;

public class ArrayDemo1 {

	public static void main(String[] args) {
		int arr[] = new int[5];
		int []arr2 = {1,2,3,4};
		//by default arrays are initialised to 0
		//Array is an object and hence has its own properties
		//normally local variables are not initialized but arrays are initialized
		//Arrays are strongly typed
		//resizing array is not possible
		//ArrayIndexOutOfBoundsException - accessing a wrong index
		//Array resides in continous memory location
		int arr3[][] = new int[4][5];
		int arr4[][] = {
				{1, 2, 3, 4},
				{5, 6, 7, 8}
		};
		//uneven multidimensional array - jagged array
		
		int arr5 [][] = new int[3][]; //initializing row is must
		arr5[0] = new int[2];
		arr5[1] = new int[3];
		arr5[2] = new int[4];
		
		int arr6[][] = { {1,2}, {1,2,3}, {1,2,3,4} };
		
	}

}
