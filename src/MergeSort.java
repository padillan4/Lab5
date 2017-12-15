
public final class MergeSort {
	
	public static void sort(MyArrayList<Integer> list){
		mergeSort(list, 0, list.size()-1);
	}
	
	private MyArrayList<Integer> mergeSort(MyArrayList<Integer> list, int leftIndex, int rightIndex){
		int mid = (leftIndex + rightIndex)/2;
		
		mergeSort(list, leftIndex, mid);
		mergeSort(list, mid + 1, rightIndex);
		merge(list, leftIndex, mid, rightIndex);
	}
	
	private MyArrayList<Integer> merge(MyArrayList<Integer> list, int leftIndex, int mid, int rightIndex){
		MyArrayList<Integer> sortedList = new MyArrayList<Integer>();
		
		while(leftIndex < list1.size() || rightIndex < list2.size()){
			if(leftIndex < list1.size() && rightIndex < list2.size()){
				if(list1.get(leftIndex) > list2.get(rightIndex)){
					sortedList.add(list2.get(rightIndex));
					rightIndex++;
				}
				else if(list1.get(leftIndex) < list2.get(rightIndex)){
					sortedList.add(list1.get(leftIndex));
					leftIndex++;
				}
				else {
					sortedList.add(list1.get(leftIndex));
					sortedList.add(list2.get(rightIndex));
					leftIndex++;
					rightIndex++;
				}
			}
			else if(leftIndex == list1.size() && rightIndex < list2.size()){
				sortedList.add(list2.get(rightIndex));
				rightIndex++;
			}
			else if(leftIndex < list1.size() && rightIndex == list2.size()){
				sortedList.add(list1.get(leftIndex));
				leftIndex++;
			}
		}
		
		return sortedList;
	}
}
