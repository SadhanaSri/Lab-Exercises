package day8;
import java.util.Scanner;

public class ShoeExercise2 {
	public static void main(String[] args) throws Exception{
		System.out.println("Shop Class Name: ");
		Scanner sc = new Scanner(System.in);
		String shopClass = sc.next();
		System.out.println("Factory Class Name: ");
		String factoryClass = sc.next();
		ShoeShop shop = Container.getShoeShop(shopClass, factoryClass);
		Shoe shoe = shop.sellShoe(new ShoeCustomer("Sadhana"));
		System.out.println(shoe);
	}
}

class Container {
	public static ShoeShop getShoeShop(String shopClass, String factoryClass) throws Exception {
		ShoeFactory factory = (ShoeFactory)Class.forName(factoryClass).newInstance();
		ShoeShop shop = (ShoeShop)Class.forName(shopClass).newInstance();
		shop.setFactory(factory);
		return shop;
	}
}

interface Manufacturer {
	
}

interface ShoeManufacturer extends Manufacturer {
	abstract Shoe makeShoe();
}

abstract class ShoeFactory implements ShoeManufacturer {
	
}

class BataShoeFactory extends ShoeFactory {
	@Override
	public Shoe makeShoe() {
		return new LeatherShoe();
	}
}

class NikeShoeFactory extends ShoeFactory {
	@Override
	public Shoe makeShoe() {
		return new SportsShoe();
	}
}

abstract class Shoe {
}

class LeatherShoe extends Shoe {
	@Override
	public String toString() {
		return "Leather Shoe bought";
	}
}

class SportsShoe extends Shoe {
	@Override
	public String toString() {
		return "Sports Shoe bought";
	}
}

interface Seller {
	
}

interface ShoeSeller extends Seller {
	public Shoe sellShoe(Customer customer);
}

abstract class ShoeShop implements ShoeSeller {
	private ShoeFactory factory;
	
	public final ShoeFactory getFactory() {
		return factory;
	}
	
	public final void setFactory(ShoeFactory factory) {
		this.factory = factory;
	}
}

class BataShop extends ShoeShop {
	@Override
	public Shoe sellShoe(Customer customer) {
		System.out.println("Customer: "+customer.getName());
		return getFactory().makeShoe();
	}
}

abstract class Customer {
	private String name;
	
	public Customer(String name) {
		this.name = name;
	}
	
	String getName() {
		return this.name;
	}
}

class ShoeCustomer extends Customer {
	public ShoeCustomer(String name) {
		super(name);
	}
}
