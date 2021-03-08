package day7_revision;

import java.util.Scanner;

public class ShoeExercise {
	public static void main(String[] args)throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Shop Class Name: ");
		String shopClass = sc.next();
		System.out.println("Shoe Class Name: ");
		String shoeClass = sc.next();
		System.out.println("Factory Class Name: ");
		String factoryClass = sc.next();
		System.out.println("Customer Name: ");
		String name = sc.next();
		Customer customer = Container.processOrder(factoryClass, shopClass, shoeClass, name);
		System.out.println("\n=================INVOICE=================");	
		System.out.println("Name: "+customer.name);
		System.out.println("Item: "+customer.shoe);
		System.out.println("Shop: "+customer.shop);
		System.out.println("Factory: "+customer.factory);
		sc.close();
	}
}

class Container {
	public static Customer processOrder(String factoryClass, String shopClass, String shoeClass, String name) throws Exception {
		ShoeShop shoeShop = (ShoeShop)Class.forName(shopClass).getConstructor().newInstance();
		ShoeFactory factory = (ShoeFactory)Class.forName(factoryClass).getConstructor().newInstance();
		shoeShop.setFactory(factory);
		Shoe shoe = shoeShop.sellShoe(shoeClass);
		Customer customer = new ShoeCustomer(name, shoeShop.getShopName(), factory.getFactoryName(), shoe.getShoeName());
		return customer;
	}
}

abstract class Customer {
	String name;
	String shoe;
	String shop;
	String factory;
	
	public Customer(String name, String shop, String factory, String shoe) {
		this.name = name;
		this.shoe = shoe;
		this.shop = shop;
		this.factory = factory;
	}
}

class ShoeCustomer extends Customer {
	public ShoeCustomer(String name, String shop, String factory, String shoe) {
		super(name, shop, factory, shoe);
	}
}

interface Manufacturer {
	
}

interface ShoeManufacturer extends Manufacturer  {
	public Shoe makeShoe(String shoeClass) throws Exception;
	public String getFactoryName();
}

abstract class ShoeFactory implements ShoeManufacturer {
	
}

class BataShoeFactory extends ShoeFactory {
	public BataShoeFactory() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Shoe makeShoe(String shoeClass) throws Exception {
		return (Shoe)Class.forName(shoeClass).getConstructor().newInstance();
	}
	
	public String getFactoryName() {
		return "Bata shoe factory";
	}
}

class NikeShoeFactory extends ShoeFactory {
	public NikeShoeFactory() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Shoe makeShoe(String shoeClass)throws Exception {
		return (Shoe)Class.forName(shoeClass).getConstructor().newInstance();
	}
	
	public String getFactoryName() {
		return "Nike shoe factory";
	}
}

interface Seller {
	
}

interface ShoeSeller extends Seller {
	public Shoe sellShoe(String shoeClass) throws Exception;
}

abstract class ShoeShop implements ShoeSeller {
	public abstract String getShopName();

	protected abstract void setFactory(ShoeFactory factory);
	
}

class BataShop extends ShoeShop {
	
	private ShoeFactory factory;

	public BataShop() {
		System.out.println("Welcome to Bata Shop");
	}
	
	@Override
	public Shoe sellShoe(String shoeClass) throws Exception {
		return factory.makeShoe(shoeClass);
	}
	
	public String getShopName() {
		return "Bata shop";
	}
	
	public final void setFactory(ShoeFactory factory) {
		this.factory = factory;
	}
}

class NikeShop extends ShoeShop {
	private ShoeFactory factory;
	
	public NikeShop() {
		// TODO Auto-generated constructor stub
	}
	
	public NikeShop(ShoeFactory factory) {
		System.out.println("Welcome to Nike Shop");
		this.factory = factory;
	}
	
	@Override
	public Shoe sellShoe(String shoeClass) throws Exception {		
		return factory.makeShoe(shoeClass);
	}
	
	public String getShopName() {
		return "Nike shop";
	}
	
	public final void setFactory(ShoeFactory factory) {
		this.factory = factory;
	}
}

abstract class Shoe {
	public abstract String getShoeName();
}

class LeatherShoe extends Shoe {
	public LeatherShoe() {
		System.out.println("Leather shoe ordered...\nOrder processing...");
	}
	public String getShoeName() {
		return "Leather shoe";
	}
}

class SportsShoe extends Shoe {
	public SportsShoe() {
		System.out.println("Sports shoe ordered...\nOrder processing...");
	}
	@Override
	public String getShoeName() {
		return "Sports shoe";
	}
}