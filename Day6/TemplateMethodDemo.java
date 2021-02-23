package day6;

public class TemplateMethodDemo {
	public static void main(String[] args) {
		DominoPizza dominos = new CoimbiDominos();
		dominos.makePizza();
	}
}

abstract class DominoPizza {
	final public void selectAtta() {
		System.out.println("Atta selected...");
	}
	
	final public void makeIngredients() {
		System.out.println("Ingredients selected...");
	}
		
	final public void packaging() {
		System.out.println("Packaging selected...");
	}
	
	final public void selectItemsForPizzaMaking() {
		selectAtta();
		makeIngredients();
	}
	
	public abstract void makePizza();
	public abstract void delivery();
}

class CoimbiDominos extends DominoPizza {

	@Override
	public void delivery() {
		System.out.println("Pizza delivered...");
		
	}
	
	@Override
	public void makePizza() {
		selectItemsForPizzaMaking();
		System.out.println("Cooking");
		packaging();
		delivery();
	}
}
