import java.util.Random;
public class Tester {

	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<>();
		
		list = randomList(list);
		
		System.out.println("unsorted list");
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i) + " ");
		}
		System.out.println();
		System.out.println("sorting");
		TreeSort.sort(list);
		/**for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}**/
		System.out.println();
	}
	
	public static MyArrayList<Integer> randomList(MyArrayList<Integer> list){
		Random r = new Random();
		
		for(int i = 0; i < 100; i++){
			Integer rand = (Integer)r.nextInt(100) + 1000;
			list.add(new Integer(rand));
		}
		
		return list;
	}
}
