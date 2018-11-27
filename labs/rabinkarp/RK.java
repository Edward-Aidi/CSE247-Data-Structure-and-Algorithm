package rabinkarp;

public class RK {
	
	//
	// Be sure to look at the write up for this assignment
	//  so that you get full credit by satisfying all
	//  of its requirements
	//
	private int prime;
	char[] circularbuff;
	int pointer;
	int hash;
	

	/**
	 * Rabin-Karp string matching for a window of the specified size
	 * @param m size of the window
	 */
	public RK(int m) {
		this.prime = 511;
		this.circularbuff = new char[m];
		this.pointer = 0;
		this.hash = 0;
	}

	/**
	 * Compute the rolling hash for the previous m-1 characters with d appended.
	 * @param d the next character in the target string
	 * @return
	 */
	public int nextCh(char d) {
		// original return of nextCh += -
		if(pointer < circularbuff.length) {
			circularbuff[pointer] = d;
			hash = (31 * hash + d) % this.prime;
			this.pointer += 1;
		}
		else {
			this.pointer = this.pointer % circularbuff.length;
			char c = circularbuff[pointer];
			while(pointer < circularbuff.length - 1) {
				circularbuff[pointer] = circularbuff[pointer + 1];
				this.pointer += 1;
			}
			circularbuff[this.pointer] = d;
			this.pointer += 1;
			int middle = 31 % this.prime;
			for(int m = 0; m < circularbuff.length-1; m++) {
				middle = middle * 31 % this.prime;
			}
			middle = middle * c % this.prime % this.prime;
			hash = Math.floorMod(31 * hash - middle + (int)d, this.prime);
			
		}
		// last elemnt circularbuff[pointer+circularbuff.length-1]
		// first element circularbuff[0]
		
		// c is the character about to leave the window and d is the character that appends to the window
		return hash;
	}

}
