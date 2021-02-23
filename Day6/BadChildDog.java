package day6;

public class BadChildDog {
	public static void main(String args[]) throws Exception {
		NaughtyChild child = new NaughtyChild();
		BullDog dog = ContainerClass.get(args[0]);
		child.playwith(dog);
	}
}

class ContainerClass
{
	public static BullDog get(String p) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	BullDog dog = new BullDog();
	ItemToPlay play = (ItemToPlay)Class.forName(p).newInstance();
	dog.play = play;
	return dog;
	}
}

class BullDog {
	ItemToPlay play;
	public void get() {
		play.playwithdog();
	}
}

class NaughtyChild {
	public void playwith(BullDog dog)
	{
		dog.get();
	}
}

abstract class ItemToPlay
{
	public abstract void playwithdog(); 
	
}

class Stick extends ItemToPlay{
	@Override
	public void playwithdog() {
		System.out.println("You beat I bite");
	}
}

class Stone extends ItemToPlay
{
	@Override
	public void playwithdog() {
		System.out.println("You hit I bark");
	}
}


