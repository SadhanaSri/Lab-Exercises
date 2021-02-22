package day5;

abstract class MineBase {
	 abstract void amethod();
	 static int i;
}
public abstract class Program11 extends MineBase {
	 public static void main(String argv[]){
		 int[] ar=new int[5];
	 	 for(i=0;i < ar.length;i++)
		 System.out.println(ar[i]);
	 }
	 
	 //Program11 must implement the inherited abstract method amethod,
	 //otherwise, Program11 must be made abstract
}
