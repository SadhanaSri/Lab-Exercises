package day5;

public class ClassesAndObjectsDemo1 {
	public static void main(String args[]) {
		Pepsi pepsico = new Pepsi();
		Kalimark annachi = new Kalimark();
		
		pepsico.makePepsiCola();
		annachi.makeBovotoCola();
	}
}

abstract class Cola {
	public abstract void makeCola();
}


class Pepsi {
	public void makePepsiCola() {
//		Cola cola = new CampaCola();
//		Cola cola = new Kalimark().getColaTrojan();
//		cola.makeCola();
//		System.out.println("Pepsi sells CampaCola in Pepsi bottle");
	} 
}

class Kalimark {
	int money;
	
	public void makeBovontoCola() {
		//anonymous inner class
		new Cola() {
			
			@Override
			public void makeCola() {
				System.out.println("CampaCola now belongs to Kalimark");
				
			}
		}.makeCola();
	}
//	public void makeBovotoCola() {
//		class CampaCola extends Cola { //local inner class, cannot be accessed by outside members-strong encapsulation
//			int campamoney;
//			public void makeCola() {
//				System.out.println("Cola made by CampaCola");
//			}
//		}
//		Cola cola = new CampaCola();
//		cola.makeCola();
//		System.out.println("Kalimark sells CampaCola in Bovonto bottle"+new CampaCola().campamoney);
//	}
	//inner class can access the properties of parent class directly. but, parent class has to create object of child class to access it.
//	class CampaCola extends Cola { 
//		int campamoney;
//		public void makeCola() {
//			System.out.println("Cola made by CampaCola");
//		}
//	}
	
//	public Cola getColaTrojan() {
//		return new CampaCola();
//	}
}