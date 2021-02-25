package inheritance;

public class Program6 {
	public static void main(String[] args) {
		Demo demo = new Demo();
	}
}

class Demo {
	Demo() {
		System.out.println("Constructor");
	}
	static {
		System.out.println("Static block 1");
	}
	
	static {
		System.out.println("Static block 2");
	}
}
