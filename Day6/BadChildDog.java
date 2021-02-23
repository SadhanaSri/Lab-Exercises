package day6;

public class BadChildDog {
	public static void main(String[] args) throws Exception {
		BullDog dog = NaughtyChild.getItem(args[0]);
		dog.play();
	}
}

class BullDog {
	ItemToPlay item;
	public void play() {
		item.playwithdog();
	}
}

class NaughtyChild {
	public static BullDog getItem(String name) throws Exception{
		BullDog dog = new BullDog();
		ItemToPlay item = (ItemToPlay)Class.forName(name).newInstance();
		dog.item = item;
		return dog;
	}
}

abstract class ItemToPlay {
	public abstract void playwithdog();
}

class Stone extends ItemToPlay {
	public void playwithdog() {
		System.out.println("Stone..You hit I bark...");
	}
}

class Stick extends ItemToPlay {
	public void playwithdog() {
		System.out.println("Stick..You beat I bite...");
	}
}
