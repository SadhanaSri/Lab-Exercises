package day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class IODemo7 {
	public static void main(String[] args) throws Exception {
		Laddu laddu = new Laddu();
		System.out.println("Size of original laddu..."+laddu.size);
		laddu.size = 5;
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("laddu.dat"));
		oos.writeObject(laddu);
		
		laddu.size = 2;
		
		System.out.println("Size now..."+laddu.size);
		System.out.println("Size of old laddu");
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("laddu.dat"));
		Laddu laddu2 = (Laddu)ois.readObject(); //deep copy
		
		System.out.println("Original laddu...:"+laddu2.size);
		System.out.println("modified laddu....:"+laddu.size);
	}
}

class Laddu implements Serializable {
	public Laddu() {
		System.out.println("Laddu object created...");
	}
	int size=10;
}
