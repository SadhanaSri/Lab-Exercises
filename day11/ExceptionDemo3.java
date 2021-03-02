package day11;

public class ExceptionDemo3 {
	public static void main(String[] args) throws Exception {
		Dog dog = Child.getItem(args[0]);
		Child child = new Child();
		child.playWithDog(dog);
	}
}

abstract class DogExceptions extends Exception {	

}

class DogBarkException extends DogExceptions {
	String msg;
	public DogBarkException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "DogBarkException rised: "+msg;
	}
}

class DogBiteException extends DogExceptions {
	String msg;
	public DogBiteException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "DogBiteException rised: "+msg;
	}
}

class DogHappyException extends DogExceptions {
	String msg;
	public DogHappyException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "DogHappyException rised: "+msg;
	}
}

abstract class Item {
	public abstract void execute() throws DogExceptions;
}

class Stone extends Item {
	public Stone() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute() throws DogExceptions {
		throw new DogBarkException("You throw...I bark...");		
	}
}

class Stick extends Item {
	public Stick() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute() throws DogExceptions {
		throw new DogBiteException("You beat...I bite...");		
	}
}

class Bone extends Item {
	public Bone() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute() throws DogExceptions {
		throw new DogHappyException("You feed...I eat...");	
	}
}

class Child {
	public static Dog getItem(String itemName) throws DogExceptions, Exception {
		Item item = (Item)Class.forName(itemName).getConstructor().newInstance();
		Dog dog = new Dog();
		dog.item = item;
		return dog;
	}
	
	public void playWithDog(Dog dog) throws Exception {
		dog.play(dog.item);
	}
}

class Dog {
	Item item;
	public void play(Item item) throws DogExceptions {
		item.execute();
	}
}