package day13;

public class GenericsDemo3 {

	public <E> E[] getObject(E[] elements) {
		for(E element: elements) {
			System.out.print(element+" ");
		}
		System.out.println();
		return elements;
//		return null;
	}
	
	public static void main(String[] args) {
		GenericsDemo3 obj = new GenericsDemo3();
		String arr1[] = obj.getObject(new String[] {"a", "b", "c"});
		Integer arr2[] = obj.getObject(new Integer[] {1, 2, 3, 4});
		
		for(String ele: arr1) {
			System.out.print(ele+" ");
		}
		System.out.println();
		
		for(Integer element: arr2) {
			System.out.print(element+" ");
		}
		System.out.println();
	}

}
