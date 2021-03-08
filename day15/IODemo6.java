package day15;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IODemo6 {
	public static void main(String[] args) throws IOException {
		PipedReader reader = new PipedReader();
		PipedWriter writer = new PipedWriter(reader);
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		es.execute(() -> {
			try {
				int data;
				
				while((data = reader.read()) != -1) {
					System.out.print((char)data);
				}
				System.out.println();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		});
		
		es.execute(() -> {
			try {
				int data;
				
				while(true) {
					writer.write("Hello world");
					try {
						Thread.sleep(1000);
					} catch(Exception e) {
						e.printStackTrace();
					}
					System.out.println();
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		});
		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					int data;
//					
//					while((data=reader.read())!=-1) {
//						System.out.print((char)data);
//					}
//					System.out.println();
//					
//				} catch(Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}).start();
//		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					while(true) {
//						writer.write("hello world");
//						try {
//							Thread.sleep(1000);
//						} catch(Exception e) {
//							e.printStackTrace();
//						}
//						System.out.println();
//					}
//					
//				} catch(Exception e) {
//					e.printStackTrace();
//				}		
//			}
//		}).start();
		
		
		
	}
}
