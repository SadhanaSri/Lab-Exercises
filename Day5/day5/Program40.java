package day5;

class Base2{
	 Base2(int i){
	    System.out.println("base constructor");
	 }
	 Base2(){
	 }
} 

public class Program40 extends Base2{
	 public static void main(String argv[]){
		 Program40 s= new Program40();
		 Base2 b = new Base2(1);
	 //One
	 }
	 Program40()
	 {
	     Base2 b = new Base2(1);
	 }
	 public void derived()
	 {
	 //Three
//		 Base2 b = new Base2(1);
	 }
	} 

