package day5;

public class Program45 {
	public static void main(String argv[]){
		Program45 r = new Program45();
		r.amethod(r);
	}
	
	public void amethod(Program45 r){
		 int i=99;
		 multi(r);
		 System.out.println(i);
	}
		 
	public void multi(Program45 r){
//		 r.i = r.i*2; Compile Time Error
	}
	
//	Since i is a local or instance variable and is not a class variable.
}
