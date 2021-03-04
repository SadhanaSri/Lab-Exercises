package day13;

public class GenericsDemo {

	public static void main(String[] args) {
		PaintBrush<Water> brush1 = new PaintBrush<>();
		brush1.setObject(new Water());
		Water water = brush1.getObject();
		System.out.println(water);
		
		PaintBrush<Paint> brush2 = new PaintBrush<>();
		brush2.setObject(new RedPaint());
		Paint paint = brush2.getObject();
		System.out.println(paint);
	}

}

class PaintBrush<T> {
	T obj;
	
	public T getObject() {
		return obj;
	}
	
	public void setObject(T obj) {
		this.obj = obj;
	}
}

abstract class Paint {
	
}

class RedPaint extends Paint {
	
}


class Water {
	
}