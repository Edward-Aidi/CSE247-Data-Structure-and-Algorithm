package studio2.lists;

import timing.Ticker;

/**
 * Your assignment is to modify this class so it uses a tail reference
 * 
 * @author roncytron and Di Ai
 *
 * @param <T>
 */
public class LinkedListWithTail<T> implements List<T> {
	
	private ListNode<T> head;
	private Ticker ticker;
	private ListNode<T> tail;
	private int sizelist;
	
	public LinkedListWithTail(Ticker ticker) {
		this.head = null;   // nothing in our list yet
		this.ticker = ticker;
		this.tail = null; // nothing in the list, so the tail points to null
		this.sizelist = 0;
	}

	/**
	 * Modify this method for studio 2 so that it uses an instance
	 * variable for the tail reference, and modify code in this class
	 * so that the tail reference
	 * that always points to the end of the list.
	 * 
	 * Use that tail reference to add to the end of the list, instead
	 *   of looping to find the end.
	 */
	@Override
	public void addLast(T thing) {
		if (tail == null) { // empty list, slide 176
			ListNode<T> p = new ListNode<T>();
			p.value = thing;
			tail = p;
			head = p;
			p.next = tail;
			ticker.tick(4);  // for the 4 statements above
		}
		else {
			ListNode<T> q = new ListNode<T>();
			q.value = thing;
			//
			// As given, this
			// searches for the end of the list
			// Modify this code using your new tail reference
			//  and get rid of this loop!
			tail.next = q;
			tail = q;
//			while (p.next != null) {
//				ticker.tick();
//				p = p.next;
//			}
//			//  p is where it needs to be slide 201
//			p.next = q;
			ticker.tick(4);  // for the 5 statements not in the loop
		}
		
		sizelist = sizelist + 1;
	}
	
	/**
	 * Modify this method so that getting the size of this list
	 * takes Theta(1) (constant) time.
	 */
	@Override
	public int getSize() {
//		int ans = 0;
//		for (ListNode<T> p = this.head; p != null; p = p.next) {
//			ans = ans + 1;
//			ticker.tick();
//		}
//		return ans;
		ticker.tick();
		return sizelist;
	}

	/**
	 * 
	 * @param n which time, 0 is the first item
	 * @return
	 */
	@Override
	public T getItemAt(int n) {
		ListNode<T> p = head;
		for (int i=0; i < n; ++i) {
			p = p.next;
			ticker.tick();
		}
		return p.value;
	}
	
	public String toString() {
		String ans = "[ ";
		for (ListNode<T> p = head; p != null; p = p.next) {
			ans = ans + p.value + " ";
		}
		ans = ans + "]";
		return ans;
	}
	
}
