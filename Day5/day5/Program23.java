package day5;

class Base1{
	 public void amethod(int i) { }
}

public class Program23 extends Base1{
	 public static void main(String argv[]){
	 }
	 //Method Here
//	 Exception Exception is not compatible with throws clause in Base.amethod(int).
//	 void amethod(int i) throws Exception {} 
	 
//	 No error
//	 void amethod(long i)throws Exception {}

	 //   No error
//	 void amethod(long i){}
	 
//	 Exception Exception is not compatible with throws clause in Base.amethod(int).
//	 public void amethod(int i) throws Exception {} 

} 
