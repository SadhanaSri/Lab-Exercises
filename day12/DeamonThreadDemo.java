package day12;

public class DeamonThreadDemo {
	public DeamonThreadDemo() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					System.out.println("child thread 1......");
				}
			}
		}).start();
	}
	
	public static void main(String[] args) {
		new DeamonThreadDemo();
		System.out.println("main thread started......");
		Thread.currentThread().setDaemon(true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.exit(1);
	}
}

