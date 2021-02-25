package inheritance;

public class Program15 {
	public static void main(String[] args) {
		Door door = new Door();
		Window window = new Window();
		House house = new House(20, 10);
		house.calculateCost(door, window);
		house.printCost();
	}
}

class House {
	float door_area;
	float window_area;
	static float door_cost;
	static float window_cost;
	
	public House() {
		
	}
	
	public House(float door_area, float window_area) {
		this.door_area = door_area;
		this.window_area = window_area;
	}
	
	public void calculateCost(Door door, Window window) {
		door_cost = door.doorCost(door_area);
		window_cost = window.windowCost(window_area);
	}
	
	public void printCost() {
		System.out.println("Door cost: "+door_cost);
		System.out.println("Window cost: "+window_cost);
	}
}

class Door extends House {
	public float doorCost(float door_area) {
		return door_area*20;
	}
}

class Window extends House {
	public float windowCost(float door_area) {
		return door_area*10;
	}
}