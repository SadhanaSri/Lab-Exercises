package day8;

public class ShapeDemo {
	public static void main(String[] args) {
		Circle circle=new Circle(30);
		circle.calcArea();
		circle.calcVolume();
		Square square=new Square(20);
		square.calcArea();
		square.calcVolume();
		Triangle triangle=new Triangle(40,20,30);
		triangle.calcArea();
		triangle.calcVolume();
		Sphere sphere=new Sphere(70);
		sphere.calcArea();
		sphere.calcPerimeter();
		sphere.calcVolume();
		sphere.calcSurfaceArea();
	}
}

interface Shape {
	static final float pi = 3.14f;
	public void calcArea();
	public void calcVolume();
}

class Circle implements Shape {
	int radius;
	float area;
	float volume;
	
	public Circle(int radius) {
		this.radius=radius;
	}

	@Override
	public void calcArea() {
		area=(int)(3.14)*radius*radius;
		System.out.println("Area of Circle: "+area);		
	}
	
	@Override
	public void calcVolume() {
		volume=2*(int)(3.14)*radius;
		System.out.println("Volume of Circle: "+volume);		
	}
}

class Square implements Shape {
	int radius;
	float area;
	float volume;
	
	Square(int radius) {
		this.radius=radius;
	}
	
	@Override
	public void calcArea() {
		area=radius*radius;
		System.out.println("Area of Square: "+area);
	}

	@Override
	public void calcVolume() {
		volume=4*radius;
		System.out.println("Volume of square: "+volume);
		
	}
}

class Triangle implements Shape
{
	int a;
	int b;
	int c;
	float area;
	float volume;
	
	Triangle(int a,int b,int c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	@Override
	public void calcArea() {
		area=(a+b+c)/2;
		System.out.println("Area of Triangle: "+area);
	}

	@Override
	public void calcVolume() {
		volume=a+b+c;
		System.out.println("Volume of Triangle: "+volume);
		
	}
}

class Sphere implements Shape
{
	float radius;
	float area;
	float volume;
	float surfaceArea;
	float perimeter;
	
	public Sphere(int radius) {
		this.radius = radius;
	}
	@Override
	public void calcArea() {
		area=(int)(3.14)*radius*radius;
		System.out.println("Area of Sphere: "+area);
	}

	@Override
	public void calcVolume() {
		volume=2*(int)(3.14)*radius;
		System.out.println("Volume of Sphere: "+volume);
		
	}
	public void calcSurfaceArea()
	{
		surfaceArea=4*radius*radius;
		System.out.println("Surface Area of Sphere: "+surfaceArea);
	}
	public void calcPerimeter()
	{
		perimeter=(int)(4/3)*(int)(3.14)*radius*radius;
		System.out.println("Perimeter of Sphere: "+perimeter);
	}
}