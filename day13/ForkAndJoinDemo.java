package day13;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkAndJoinDemo {

	public static void main(String[] args) {
		MyStringArray obj = new MyStringArray();
		ForkJoinPool pool = ForkJoinPool.commonPool();
		OurTask task1 = new OurTask(0, 3, obj.arr, "ramu");
		OurTask task2 = new OurTask(3, 6, obj.arr, "ramu");
		OurTask task3 = new OurTask(6, 8, obj.arr, "ramu");
		OurTask task4 = new OurTask(8, 11, obj.arr, "ramu");
		
		int result1 = pool.invoke(task1);
		int result2 = pool.invoke(task2);
		int result3 = pool.invoke(task3);
		int result4 = pool.invoke(task4);
		
		int result = result1+result2+result3+result4;
		
		System.out.println("Number of ramus: "+result);
	}

}

class OurTask extends RecursiveTask<Integer> {
	int start;
	int end;
	String arr[];
	String key;
	
	public OurTask(int start, int end, String[] arr, String key) {
		this.start = start;
		this.end = end;
		this.arr = arr;
		this.key = key;
	}
	
	@Override
	protected Integer compute() {
		int count=0;
		for(int i=start; i<end; i++) {
			if(arr[i].equalsIgnoreCase(key)) {
				count++;
			}
		}
		return count;
	}
}

class MyStringArray {
	String arr[] = {"ramu", "somu", "monu","nikki","ramu","maggi","khader","refayi","ramu",
			"mokarram", "riyas"};
}