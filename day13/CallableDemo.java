package day13;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(1);
		Future<String> future1 = es.submit(new MyCallable());
		Future<String> future2 = es.submit(() -> {
			return "Callable demo";
		});
		System.out.println(future1.get());
		System.out.println(future2.get());
		es.shutdown();
	}
}

class MyCallable implements Callable<String> {
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "Callable demo";
	}
}
