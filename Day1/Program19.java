package day1;
import java.util.Scanner;

public class Program19 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int mat[][] = new int[row][col];
						
		for(int i=0; i<row; i++)
			for(int j=0; j<col; j++)
				mat[i][j] = sc.nextInt();
		
		Util19 obj = new Util19();
		obj.reverseElements(mat, row, col);
		sc.close();
	}
}

class Util19 {
	void reverseElements(int mat[][], int row, int col) {
		int first;
		int last;
		int temp;
		
		for(int i=0; i<row; i++) {
			first = 0;
			last = col-1;
			while(first<last) {
				temp = mat[i][first];
				mat[i][first] = mat[i][last];
				mat[i][last] = temp;
				first++;
				last--;
			}
		}
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}

}
