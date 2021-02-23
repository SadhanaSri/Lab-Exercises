package day6;

public class PaintDemo {
	public static void main(String[] args) throws Exception {
		PaintBrush brush = Container.getBrush(args[0]);
		brush.doPaint();
	}
}

//Container class provides loose coupling
//creates object dynamically and inject the dependencies and return the fully created objects
//Open for modification

class Container {
	public static PaintBrush getBrush(String PaintClassName) throws Exception {
		PaintBrush brush = new PaintBrush();
		Paint paint = (Paint)Class.forName(PaintClassName).newInstance();
		//dependency injection
		brush.paint = paint;
		return brush;
	}
}

//class PaintBrush {
//	void doPaint(int i) {
//		if(i == 1) {
//			System.out.println("Red Paint");
//		}
//		else if(i == 2) {
//			System.out.println("Blue paint");
//		}
//	}
//	
//}

/*
 * Wherever the if-else-if is founf, and the code is dynamic then
 * 1. Convert the conditions to classes.
 * 2. Group them under hierarchy.
 * 3. Create association between them.
 */
class PaintBrush {
	Paint paint;
	public void doPaint() {
		System.out.println(paint);
	}
}

abstract class Paint {
	
}

class RedPaint extends Paint {
	
}

class BluePaint extends Paint {
	
}

