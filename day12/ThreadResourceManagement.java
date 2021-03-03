package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadResourceManagement {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		es.execute(() -> {
			Laptop laptop = EYOffice.getLaptopFromLockerRoom("ramu");
			EYOffice.closeLaptop();
		});
		
		es.execute(() -> {
			Laptop laptop = EYOffice.getLaptopFromLockerRoom("somu");
			EYOffice.closeLaptop();
			Laptop laptop2 = EYOffice.getLaptopFromLockerRoom("somu");
		});
	}
}

class EYOffice {
	private static ThreadLocal locker = new ThreadLocal();
	
	public static Laptop getLaptopFromLockerRoom(String name) {
		Laptop laptop = (Laptop)locker.get();
		
		if(laptop == null) {
			laptop = new Laptop();
			locker.set(laptop);
		}
		
		return laptop;
	}
	
	public static void closeLaptop() {
		Laptop laptop = (Laptop)locker.get();
		
		if(laptop != null) {
			locker.remove();
		}
	}
}

class Laptop {
	String name;
	public Laptop() {
		System.out.println("Laptop created...");
		this.name = name;
	}
	@Override
	public String toString() {
		return "Laptop belongs to : " + name;
	}
}
