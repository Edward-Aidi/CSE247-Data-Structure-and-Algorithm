package studio3;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class UnorderedList<T extends Comparable<T>> implements PriorityQueue<T> {

	public List<T> list;
	
	public UnorderedList() {
		list = new LinkedList<T>();
	}
	
	@Override
	public boolean isEmpty() {
		//
		// FIXME
		//
		if(this.list.size() == 0) {
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
		this.list.add(thing);
	}

	@Override
	public T extractMin() {
		//
		// FIXME
		//
		T min;
		if(this.list.isEmpty()) {
			min = null;
		}
		else {
//			ListIterator<T> itr = this.list.listIterator();
//			min = itr.next();
//			while(itr.hasNext()) {
//				T curr = itr.next();
//				if(curr.compareTo(min) < 0) {
//					min = curr;
//				}
//			}
			min = this.list.get(0);
			int index = 0;
			for(int i = 0; i < this.list.size(); i++) {
				if(this.list.get(i).compareTo(min) < 0) {
					min = this.list.get(i);
					index = i;
				}
			}
			this.list.remove(index);
		}
		return min;
	}

}
