package day9;

public class Program24 {

	public static void main(String[] args) {
		Square s = new Square();
		Rectangle r = new Rectangle();
		System.out.println("Area of Square: "+s.area(5));
		System.out.println("Perimeter of Square: "+s.perimeter(5));
		System.out.println("Area of Rectangle: "+r.area(10, 5));
		System.out.println("Perimeter of Rectangle: "+r.perimeter(10, 5));
	}
}
class Square {
	public int area(int side) {
		return side*side;
	}
	
	public int perimeter(int side) {
		return 4*side;
	}
}

class Rectangle {
	public int area(int length, int breadth) {
		return length*breadth;
	}
	
	public int perimeter(int length, int breadth) {
		return 2*(length+breadth);
	}
}
