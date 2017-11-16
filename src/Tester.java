
public class Tester {

	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<>();
		
		list.add(new Integer(2));
		list.add(new Integer(4));
		list.add(new Integer(1));
		list.add(new Integer(7));
		list.add(new Integer(15));
		list.add(new Integer(6));
		
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
		System.out.println("sorting");
		InsertionSort.sort(list);
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}

}
