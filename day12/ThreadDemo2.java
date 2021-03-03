package day12;

public class ThreadDemo2 {
	public static void main(String[] args) {
		System.out.println("First line");
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				met();
			}
		}).start(); 
//   since main thread is still running, this gets executed after main thread does its job
		
		System.out.println("Third line");
	}
	
	public static void met() {
		try {
			Thread.sleep(1000); 
		} catch(Exception e) {
		}
		
		System.out.println("Second line");
	}
}
