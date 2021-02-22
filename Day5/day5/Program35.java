package day5;

public class Program35 {
	public static void main(String argv[]){
		Program35 c=new Program35();
		String s=new String("ello");
		c.amethod(s);
	}
	
	public void amethod(String s){
		 char c='H';
		 //c+=s; illegal operator for char,String
//		 c = c+s; Type mismatch
//		 Compile time error
		 System.out.println(c);
	} 

}
