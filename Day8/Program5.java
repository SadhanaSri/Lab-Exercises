package inheritance;

public class Program5 {
	public static void main(String[] args) {
		Util obj1 = new Util();
		Util obj2 = new Util();
		Util obj3 = new Util();
		Util obj4 = new Util();
		Util obj5 = new Util();
		
		System.out.println("Count of objects created: "+obj5.getCount());
	}
}

class Util {
	static int count=0;
	
	Util() {
		count++;
	}
	
	int getCount() {
		return count;
	}
}
