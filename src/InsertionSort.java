
public final class InsertionSort {
	
	public static void sort(MyArrayList<Integer> list){
		int sortedIndex = 0;
		int unsortedIndex = 1;
		for(int i = 0; i < list.size(); i++){
			if(unsortedIndex < list.size()){
				if(list.get(sortedIndex) < list.get(unsortedIndex) || list.get(sortedIndex) == list.get(unsortedIndex)){
					sortedIndex++;
					unsortedIndex++;
				}
				else if(list.get(sortedIndex) > list.get(unsortedIndex)){
					int insertIndex = searchForInsertIndex(sortedIndex, list.get(unsortedIndex), list);
					list.add(insertIndex, list.get(unsortedIndex));
					list.remove(unsortedIndex+1);
					sortedIndex++;
					unsortedIndex++;
				}
			}
		}
	}
	
	private static int searchForInsertIndex(int sortedUpperBound, Integer ele, MyArrayList<Integer> list){
		int insertIndex = sortedUpperBound;
		
		if(list.get(sortedUpperBound) > ele){
			if(sortedUpperBound-1 >= 0){
				System.out.println("entered at : " + sortedUpperBound);
				searchForInsertIndex(sortedUpperBound-1, ele, list);
			}
		}
		System.out.println(insertIndex + ": ");
		return insertIndex;
	}
	
}
