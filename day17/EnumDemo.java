package day17;

public class EnumDemo {
	public static void main(String[] args) {
		Cars car;
		car = Cars.maruti;
		met(car);
	}
	
	public static void met(Cars car) {
		if(car == Cars.maruti) {
			System.out.println("Maruti");
		} else if(car == Cars.fiat) {
			System.out.println("Fiat");
		}
		switch(car) {
		case maruti:
			System.out.println("switch case - maruti....");
			break;
		case fiat:
			System.out.println("switch case- fiat....");
			break;
		default:
			System.out.println("unknown");
		}
		
		Cars c[]=Cars.values();
		for(Cars cc:c) {
			System.out.println(cc.getPrize());
		}
		System.out.println("maruti prize..:"+Cars.maruti.getPrize());
	}
}

enum Cars {
	maruti(10000), suzuki(20000), fiat(40000), tata(30000);
	
	private int prize;
	Cars(int prize) {
		this.prize = prize;
	}
	
	public int getPrize() {
		return this.prize;
	}
}
