package kwaymergesort;

import timing.Ticker;

public class KWayMergeSort {
	
	/**
	 * 
	 * @param K some positive power of 2.
	 * @param input an array of unsorted integers.  Its size is either 1, or some other power of 2 that is at least K
	 * @param ticker call .tick() on this to account for the work you do
	 * @return
	 */
	public static Integer[] kwaymergesort(int K, Integer[] input, Ticker ticker) {
		int n = input.length;
		//
		// FIXME
		// Following just copies the input as the answer
		//
		// You must replace the loop  below with code that performs
		// a K-way merge sort, placing the result in ans
		//
		// The web page for this assignment provides more detail.
		//
		// Use the ticker as you normally would, to account for
		// the operations taken to perform the K-way merge sort.
		//
		if(n/K == 1) {
			return input;
		}
		Integer split[][] = new Integer[K][n/K];
		for(int i = 0; i < split.length; i++) {
			for(int j = 0; j < split[0].length; j++) {
				split[i][j] = input[i*split[0].length + j];
			}
		}
		for(int h = 0; h < K; h++) {
			kwaymergesort(K, split[h], ticker);
		}
		
		Integer[] ans = new Integer[n];
//		for (int i=0; i < n; ++i) {
//			ans[i] = input[i];
//			ticker.tick();
//		}
		ans = merge(split);
		return ans;
	}
	
	// Merge all the sub-arrarys
	/**
	 * 
	 * @param two-dimensional array, which is the outcome of the splitting
	 * @return merged sorted array
	 */
	private static Integer[] merge(Integer[][] array) {
		  int K = array.length;
		  int n = array[0].length;

		  Integer[] mergedArray = new Integer[K*n];
		  int[] indices = new int[K];
		  for (int i = 0; i < mergedArray.length; ++i) { 
		    int value = -1;
		    int position = -1;
		    for (int j = 0; j < indices.length; ++j) { 
		      int ind = indices[j];
		      // keep the minimum among the all the value from several sub-arraies comparison
		      if (ind < n && value == -1 || array[j][ind] < value) { 
		        value = array[j][position];
		        position = j;
		      } 
		    } 
		    mergedArray[i] = value;
		    indices[position] += 1;
		  }
		  return mergedArray;
	}
}
