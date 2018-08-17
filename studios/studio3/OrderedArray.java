package studio3;

public class OrderedArray<T extends Comparable<T>> implements PriorityQueue<T> {

	public T[] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public OrderedArray(int maxSize) {
		array = (T[]) new Comparable[maxSize];
		size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		//
		// FIXME
		//
		if(this.array.length == 0) {
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public void insert(T thing) {
		//
		// FIXME
		//
		T[] newarray = (T[]) new Comparable[this.array.length+1];
		for(int i = 0; i < this.array.length; i++) {
			newarray[i] = this.array[i];
		}
//		//ascend
//		int index = 0;
//		if(this.array[0].compareTo(this.array[1]) < 0) {
//			for(int i = 0; i < newarray.length; i++) {
//				if(thing.compareTo(newarray[i]) <= 0) {
//					index = i;
//					for(int j = newarray.length-1; j > index; j--) {
//						newarray[j] = newarray[j-1];
//					}
//					newarray[index] = thing;
//				}
//			}
//		}
//		else { //descend
//			for(int i = 0; i < newarray.length; i++) {
//				if(thing.compareTo(newarray[i]) >= 0) {
//					index = i;
//					for(int j = newarray.length-1; j > index; j--) {
//						newarray[j] = newarray[j-1];
//					}
//				}
//			}
//		}
//		this.array = newarray;
		if(this.isEmpty()) {
			newarray[0] = thing;
			this.array = newarray;
		}
		else {
			for(int i = 0; i < newarray.length; i++) {
				if(thing.compareTo(newarray[i]) <= 0) {
					 int index = i;
					 if(index != newarray.length-1) {
							for(int j = newarray.length-1; j > index; j--) {
								newarray[j] = newarray[j-1];
							}
							newarray[index] = thing;
					 }
					 else {
						 newarray[index+1] = newarray[index];
						 newarray[index] = thing;
					 }
				}
			}
		}
		this.array = newarray;
	}
	
	@Override
	public T extractMin() {
		//
		// FIXME
		//
//		T min = this.array[0];
//		int index = 0;
//		for(int i = 0; i < this.array.length; i++) {
//			if(this.array[i].compareTo(min) < 0) {
//				min = this.array[i];
//				index = i;
//			}
//		}
//		for(int i = index+1; i < this.array.length; i++) {
//				this.array[i-1] = this.array[i];
//		}
//		return min;
		T min = this.array[0];
		for(int i = this.array.length-1; i > 0; i--){
			this.array[i-1] = this.array[i];
		}
		return min;
	}

}
