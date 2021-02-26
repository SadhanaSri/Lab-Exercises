package day9;

public class Program23 {
	public static void main(String[] args) {
		float area;
		float energy;
		final float pi=3.14f;
		float radius=5;
		float height=5;
		float velocity=3;
		float mass=20;
		
		area=(pi*radius*radius)+(2*pi*radius*height);
		energy=mass*(9.8f*height+((velocity*velocity)/2));
		
		System.out.println(area);
		System.out.println(energy);
	}
}
