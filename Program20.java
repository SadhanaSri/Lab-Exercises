package day1;

import java.util.Scanner;

public class Program20 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int mat[][] = new int[row][col];
				
		for(int i=0; i<row; i++)
			for(int j=0; j<col; j++)
				mat[i][j] = sc.nextInt();
		
		sc.close();
	}
}

class Util20 {
	void largestInEachRow(int mat[][], int row, int col) {
		int largest;
		
		for(int i=0; i<row; i++) {
			largest = Integer.MIN_VALUE;
			
			for(int j=0; j<col; j++) {
				if(mat[i][j] > largest) {
					largest = mat[i][j];
				}
			}
			
			System.out.println("The largest element in row "+(i+1)+" : "+largest);
		}
	}
}
