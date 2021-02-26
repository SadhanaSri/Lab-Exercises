package inheritance;

public class Program12 {
	public static void main(String[] args) {
		Haaris haaris[] = new Haaris[4];
		haaris[0] = new Haaris();
		haaris[1] = new HaarisPharma();
		haaris[2] = new HaarisInfotech();
		haaris[3] = new HaarisTechnologies();
		
		for(int i=0; i<4; i++)
			haaris[i].method();
	}
}

abstract class Person {
	abstract void method();
}

class Haaris extends Person {
	@Override
	void method() {
		System.out.println("Hi. I am Haaris");		
	}
}

class HaarisPharma extends Haaris {
	void method() {
		System.out.println("I own Haaris Pharma.");		
	}
}

class HaarisInfotech extends Haaris {
	void method() {
		System.out.println("I own Haaris Infotech.");		
	}
}

class HaarisTechnologies extends Haaris {
	void method() {
		System.out.println("I own Haaris Technologies.");		
	}
}
