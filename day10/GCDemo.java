package day10;

import java.lang.ref.SoftReference;

public class GCDemo {

	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		System.out.println("Before object creation..."+r.freeMemory());
		GrandFather obj = new GrandFather();
		System.out.println("After object creation...."+r.freeMemory());
// 		PhantomReference phantomObj = new PhantomReference(obj);
// 		WeakReference weakObj = new WeakReference(obj);
		SoftReference softObj = new SoftReference(obj);
		obj = null;
		System.out.println("After nullifying...."+r.freeMemory());
		System.out.println(obj);
//		r.gc(); //unused, unreferred objects are cleared from memory
		System.gc();
		System.out.println("After garbage collection...."+r.freeMemory());
		obj = (GrandFather)softObj.get();
		System.out.println(obj);
//		weak reference - stamped for garbage collection
//		soft reference - has some space in memory. object can be retrieved later if needed.
//		phantom reference - do not manage the garbage collection for these objects
	}

}

class GrandFather {
	private String gold = "Locker";
	String space;
	
	public GrandFather() {
		for(int i=0; i<1000; i++) {
			space=new String(" "+i);
		}	
	}
	@Override
	protected void finalize() throws Throwable { //ensures the death of an object
		System.out.println("Gold is..."+gold); //called after garbage collector is called
	} //only if weak reference is called
}
