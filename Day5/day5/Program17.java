package day5;

class Base {}
class Sub extends Base {}
class Sub2 extends Base {}

public class Program17{
	public static void main(String argv[]){
		Base b=new Base();
		Sub s=(Sub) b;
//		Baseclass object cannot be converted to subclass object
//		Exception in thread "main" java.lang.ClassCastException: class day5.Base cannot be cast to class day5.Sub
	} 
}
