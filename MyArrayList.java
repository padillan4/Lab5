/**
 * 
 */

/**
 * @author serranod7
 *
 */
public class MyArrayList<T> implements MyList<T> {
	
	
	private int arraySize = 1500000;
	@SuppressWarnings("unchecked")
	private T[] listArray = (T[])new Object[arraySize];
	private int numEntries = 0;
	
	public boolean add(int index, T o) throws IndexOutOfBoundsException{
		IndexOutOfBoundsException e = new IndexOutOfBoundsException();
		if (numEntries + 1 >= arraySize){
			resize((numEntries + 1)*2);
		}
		if(index < numEntries & index >= 0){
			@SuppressWarnings("unchecked")
			T[] temp = (T[])new Object[arraySize];
			for(int i = 0; i < numEntries + 1; i++){
				if(i < index){
					temp[i] = listArray[i];
				}
				else if(i == index){
					temp[index] = o;
				}
				else{
					temp[i] = listArray[i - 1];
				}
			} 
			listArray = temp;
			numEntries++;
			return true;
		}
		throw e;
		
	}
	
	public boolean add (T o){
		if (numEntries + 1 >= arraySize){
			resize((numEntries + 1)*2);
		}
		listArray[numEntries] = o;
		numEntries++;
		return true;	
	}
	
	public boolean clear(){
		numEntries = 0;
		arraySize = 1500000;
		@SuppressWarnings("unchecked")
		T[] temp = (T[])new Object[arraySize];
		listArray = temp;
		return false;
	}
	
	public boolean contains(T o){
		return indexOf(o) != -1;
	}
	
	public T get(int index){
		return listArray[index];
	}
	
	public int indexOf(T o){
		for (int i = 0; i <= numEntries; i++){
			if (listArray[i] == o){
				return i;
			}
		}
		return -1;
	}
	
	public boolean isEmpty(){
		return this.size() == 0;
	}
	
	public T remove(int index) throws IndexOutOfBoundsException{
		IndexOutOfBoundsException e = new IndexOutOfBoundsException();
		if((numEntries-1)*2 < arraySize){
			resize((numEntries)*2);
		}
		if(index < numEntries & index >=0){
			if(index <= numEntries-1 && index>0){
			numEntries--;
			@SuppressWarnings("unchecked")
			T[] temp = (T[])new Object[arraySize];
			
			for(int i = 0; i <= numEntries; i++){
				if(i >= index){
					temp[i] = listArray[i + 1];
				}
				else{
					temp[i] = listArray[i];
				}
			}
			T foundObject = listArray[index];
			listArray = temp;
			return foundObject;
			}
		}
		throw e;
	}
	
	public T remove(T o){
		if((numEntries-1)*2 < arraySize){
			resize((numEntries)*2);
		}
		T foundObject = null;
		
		@SuppressWarnings("unchecked")
		T[] temp = (T[])new Object[arraySize];
		
		for(int i = 0; i <= numEntries; i++){
			if (listArray[i] == o){
				temp[i] = listArray[i+1];
				foundObject = o;
			}
			else if(foundObject != null){
				temp[i] = listArray[i+1];
			}
			else{
				temp[i] = listArray[i];
			}
		}
		if(foundObject != null){
			numEntries--;
			listArray = temp;
			return foundObject;
		}
		else{
			return null;
		}
	}
	
	public boolean set(int index, T element) throws IndexOutOfBoundsException{
		IndexOutOfBoundsException e = new IndexOutOfBoundsException();
		if(index < numEntries & index >= 0){
			listArray[index] = element;
		return true;
		}
		throw e;
	}
	
	public int size(){
		return numEntries;
	}
	
	public MyArrayList<T> subList(int fromIndex, int toIndex) throws IndexOutOfBoundsException{
		IndexOutOfBoundsException e = new IndexOutOfBoundsException();
		MyArrayList<T> temp = new MyArrayList<T>();
		if(toIndex < numEntries & fromIndex >= 0 & toIndex >= 0 & fromIndex < numEntries){
			for(int i = fromIndex; i <= toIndex; i++){
				temp.add(listArray[i]);
			}
			return temp;
		}
		throw e;
	}
	
	public T[] toArray(){
		return listArray;
	}
	
	public boolean swap(int position1, int position2) throws IndexOutOfBoundsException{
		IndexOutOfBoundsException e = new IndexOutOfBoundsException();
		if(position1 >= 0 && position1 < size() && position2 >= 0 && position2 < size()){
			T temp = listArray[position2];
			listArray[position2] = listArray[position1];
			listArray[position1] = temp;
			return true;
		}
		throw e;
	}
	
	public boolean shift(int positions){
		@SuppressWarnings("unchecked")
		T[] temp =(T[])new Object[arraySize];
		
		for(int i = 0; i < numEntries; i++){
			if (positions < 0){
				if (i + positions < 0){
					temp[numEntries + positions + i] = listArray[i];
				}
				else{
					temp[i + positions ] = listArray[i];
				}
			}
			else{
				if(i + positions >= numEntries){
					temp[i + positions - numEntries] = listArray[i];
				}
				else{
					temp[i + positions] = listArray[i];
				}
			}
		}
		listArray = temp;
		return true;
	}
	

	private void resize(int newSize){
		@SuppressWarnings("unchecked")
		T[] temp =(T[])new Object[newSize];
		for(int i = 0; i<=numEntries-1; i++){
			temp[i] = listArray[i];
		}
		arraySize = newSize;
		listArray = temp;
	}
}