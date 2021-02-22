package day1;
import java.util.Scanner;

public class Program10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		int mat[][] = new int[row][col];
		
		for(int i=0; i<row; i++) { 
			for(int j=0; j<col; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		Util10 obj = new Util10();
		obj.printMatrix(mat, row, col);
		sc.close();
	}

}

class Util10 {
	void printMatrix( int mat[][], int row, int col) {
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
}
