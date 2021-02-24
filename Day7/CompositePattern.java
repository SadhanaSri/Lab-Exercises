package day7;

public class CompositePattern {
	public static void main(String[] args) {
		IceCream cream = new Vanilla(new Chocolate(new Nuts()));
		System.out.println(cream.cost());
	}
}

abstract class IceCream {
	public abstract int cost();
}

abstract class IceCreamIngredients extends IceCream{
	
}

abstract class Cream extends IceCream {
	
}

class Vanilla extends Cream {
	IceCream iceCream;
	
	public Vanilla(IceCream iceCream) {
		System.out.println("Vanilla called");
		this.iceCream = iceCream;
	}
	
	@Override
	public int cost() {
		if(this.iceCream == null)
			return 20;
		else
			return 20+this.iceCream.cost();
	}
}

class Chocolate extends Cream {
	IceCream iceCream;
	
	public Chocolate(IceCream iceCream) {
		System.out.println("Choc called");
		this.iceCream = iceCream;
	}
	
	@Override
	public int cost() {
		if(this.iceCream == null)
			return 30;
		else
			return 30+this.iceCream.cost();
	}
} 

class Nuts extends IceCreamIngredients {
	IceCream iceCream;
	public Nuts() {
		System.out.println("Nuts called");
	}
	public Nuts(IceCream iceCream) {
		this.iceCream = iceCream;
	}
	
	@Override
	public int cost() {
		if(this.iceCream == null)
			return 10;
		else
			return 10+this.iceCream.cost();
	}
}

class HotChoc extends IceCreamIngredients {
	IceCream iceCream;
	
	public HotChoc(IceCream iceCream) {
		this.iceCream = iceCream;
	}
	
	@Override
	public int cost() {
		if(this.iceCream == null)
			return 20;
		else
			return 20+this.iceCream.cost();
	}
}