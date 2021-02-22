package package1;

public class PbvPbrDemo {
	public static void main(String args[]) {
		Laddu obj = new Laddu();
		obj.setSize(10);
		System.out.println("Original size of Laddu..."+obj.getSize());
		
		Pbv pbv = new Pbv();
		pbv.met(obj.getSize());
		System.out.println("Size of Laddu after passing by value..."+obj.getSize());
		
		Pbr pbr = new Pbr();
		pbr.met(obj);
		System.out.println("Size of Laddu after passing by reference..."+obj.getSize());
	}
}

class Pbv {
	public void met(int size) {
		size = size-5;
	}
}

class Pbr {
	public void met(Laddu obj) {
		obj.setSize(5);
	}
}

class Laddu {
	private int size;
	
	public void setSize(int size) {
		this.size = size; //this refers to the current instance
	}
	
	public int getSize() {
		return size;
	}
}
