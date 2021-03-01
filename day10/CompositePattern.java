package day7;

public class CompositePattern { // Client
	public static void main(String[] args) throws Exception {
		Vanilla vanilla = Vanilla.createObject();
		Chocolate chocolate = Chocolate.createObject();
		Nuts nuts = Nuts.createObject();
		
		IceCream cream1 = vanilla.getClone(chocolate.getClone(nuts));
		
		System.out.println(cream1.cost());
	}
}

abstract class IceCream implements Cloneable {  //Component
	public abstract int cost();
	public abstract IceCream getClone() throws Exception;
	public abstract IceCream getClone(IceCream iceCream) throws Exception;
}

abstract class IceCreamIngredients extends IceCream{
	
}

abstract class Cream extends IceCream {
	
}

class Vanilla extends Cream { //Leaf
	IceCream iceCream;
	private static Vanilla vanilla;
	
	public Vanilla() {
		
	}
	
	@Override
	public IceCream getClone() throws Exception {
		return (Vanilla)super.clone();
	}
	
	@Override
	public IceCream getClone(IceCream iceCream) throws Exception {
		this.iceCream = iceCream;
		return (Vanilla)super.clone();
	}
	
	public Vanilla(IceCream iceCream) {
		this.iceCream = iceCream;
	}
	
	@Override
	public int cost() {
		if(this.iceCream == null)
			return 20;
		else
			return 20+this.iceCream.cost();
	}
	
	public static Vanilla createObject() {
		if(vanilla == null)
			vanilla = new Vanilla();
		return vanilla;
	}
}

class Chocolate extends Cream {
	IceCream iceCream;
	private static Chocolate chocolate;
	
	public Chocolate(IceCream iceCream) {
		this.iceCream = iceCream;
	}
	
	public Chocolate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IceCream getClone() throws Exception {
		return (Chocolate)super.clone();
	}
	
	@Override
	public IceCream getClone(IceCream iceCream) throws Exception {
		this.iceCream = iceCream;
		return (Chocolate)super.clone();
	}
	
	@Override
	public int cost() {
		if(this.iceCream == null)
			return 30;
		else
			return 30+this.iceCream.cost();
	}
	
	public static Chocolate createObject() {
		if(chocolate == null)
			chocolate = new Chocolate();
		return chocolate;
	}
} 

class Nuts extends IceCreamIngredients {
	IceCream iceCream;
	private static Nuts nuts; 
	
	public Nuts() {
	}
	
	public Nuts(IceCream iceCream) {
		this.iceCream = iceCream;
	}
	
	@Override
	public IceCream getClone() throws Exception {
		return (Nuts)super.clone();
	}
	
	@Override
	public IceCream getClone(IceCream iceCream) throws Exception {
		this.iceCream = iceCream;
		return (Nuts)super.clone();
	}
	
	@Override
	public int cost() {
		if(this.iceCream == null)
			return 10;
		else
			return 10+this.iceCream.cost();
	}
	
	public static Nuts createObject() {
		if(nuts == null)
			nuts = new Nuts();
		return nuts;
	}
}

class HotChoc extends IceCreamIngredients {
	IceCream iceCream;
	private static HotChoc hotChoc;
	
	public HotChoc(IceCream iceCream) {
		this.iceCream = iceCream;
	}
	
	public HotChoc() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IceCream getClone() throws Exception {
		return (HotChoc)super.clone();
	}
	
	@Override
	public IceCream getClone(IceCream iceCream) throws Exception {
		this.iceCream = iceCream;
		return (HotChoc)super.clone();
	}
	
	@Override
	public int cost() {
		if(this.iceCream == null)
			return 20;
		else
			return 20+this.iceCream.cost();
	}
	
	public static HotChoc createObject() {
		if(hotChoc == null)
			hotChoc = new HotChoc();
		return hotChoc;
	}
}