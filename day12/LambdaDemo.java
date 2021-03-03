package day12;

public class LambdaDemo {

	public static void main(String[] args) {
		display(new MyInterImpl());
		
		display(new MyInter() {
			@Override
			public void met() {
				System.out.println("Anonymous inner class implementation...");				
			}
		}); 
		
		display(() -> {System.out.println("Lambda implementation - met method called");});
		
		display2((name, i) -> {
			System.out.println(name+":"+i);
		});
		
		String result=display3((name,i)->{ 
			 name=name+"hello world"; 
			 return name+":"+i; 
		}); 
		
		System.out.println("The result is...:"+result); 
	}

	public static void display(MyInter obj) {
		obj.met();
	}
	
	public static void display2(MyInter2 obj2) {
		obj2.met2("hello", 10);
	}
	
	public static String display3(MyInter3 obj3) {
		return obj3.met3("hello", 10);
	}
}

interface MyInter {
	public void met();
}

interface MyInter2 {
	public void met2(String s, int i);
}

interface MyInter3 {
	public String met3(String s, int i);
}

class MyInterImpl implements MyInter {
	@Override
	public void met() {
		System.out.println("Outer class implementation...");		
	}
}