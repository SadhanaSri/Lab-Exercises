package day5;

//private class Base{
class Base7 {
Base7(){
 int i = 100;
 System.out.println(i);
 }
}
public class Program43 extends Base{
	static int i = 200;
	public static void main(String argv[]){
		Program43 p = new Program43();
		System.out.println(i);
	}
} 

//Error at compile time. Illegal modifier for class Base.
