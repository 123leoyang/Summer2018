package leo.yang;

public class ArrayOperations {
	private static int findPivot(int[] a, int lowBound, int highBound) {
//		check basic cases
		if (highBound < lowBound) {
			return -1;
		}
//		check special case
		if (highBound == lowBound) {
			return lowBound;
		}
		
//		recursive find mid - check 2 sides every time
		int mid = (lowBound + highBound)/2;  
//		mid check for upper half
	       if (mid < highBound && a[mid] > a[mid + 1]) {
	           return mid;
	       }
//	      mid check for lower half
	       if (mid > lowBound && a[mid] < a[mid - 1]) {
	           return (mid-1);
	       }
//	       if mid is not on the separators
	       if (a[lowBound] >= a[mid]) {
	           return findPivot(a, lowBound, mid-1);
	       } else {
	    	   return findPivot(a, mid + 1, highBound);
	       }
	}
	public static int rotatedSearch(int a[], int bound, int x) {
		int pivot = findPivot(a, 0, bound-1);
//		no rotation in array
		if (pivot == -1) {
			return BinarySearch.search(a, x);
		}
//		pivot contains desired value
		if (a[pivot] == x) {
			return pivot;
		}
//		recursively call for two separate situations
//		pivot is above desired
		if(a[0] <= x) {
			return BinarySearch.search(a, 0, pivot-1, x);
		}
//		pivot is below desired
		else {
			return BinarySearch.search(a, pivot+1, bound-1, x);
		}
	}
	private static void swapSingleElement(int[] a) {
		int l = a.length;
		int[] temp = new int[l];
		temp[l-1] = a[0];
		for(int i = 1; i < l; i++) {
			temp[i-1] = a[i];
		} 
		for(int i = 0; i < l; i++) {
			a[i] = temp[i];
		}
	}
	public static void swapIterate(int[] a, int d) {
		for (int i = 0; i < d; i++) {
			swapSingleElement(a);
		}
	}
	private static void swap(int a[], int f, int l, int bound) {
		int temp = 0;
		for (int i = 0; i < bound; i++) {
			temp = a[l + i];
			a[l + i] = a[f + i];
			a[f + i] = temp;
		}
	}

	private static void bSRotate(int[] a, int start, int bound, int n) {
		// elements are already set in place (at boundaries)
		if (bound == 0 || bound == n)
			return;

		// swap half
		if (n - bound == bound) {
			swap(a, start, n - bound + start, bound);
			return;
		}

		// a is shorter
		if (bound < n - bound) {
			swap(a, start, n - bound + start, bound);
			bSRotate(a, start, bound, n - bound);
		}
		// b is shorter
		else {
			swap(a, start, start + bound, n - bound);
			bSRotate(a, n - bound + start, 2 * bound - n, bound);
		}
	}
	
	public static void blockSwapRotate(int[] a, int d) {
		bSRotate(a, 0, d, a.length);
	}

	public static void rotate(int[] a, int d) {
		int l = a.length;
		int[] inserted = new int[l];
		// fill rotated
		for (int i = l - d; i < l; i++) {
			inserted[i] = a[i - l + d];
		}
		// fill rest
		for (int i = 0; i < l - d; i++) {
			inserted[i] = a[i + d];
		}
		// refill a
		for (int i = 0; i < l; i++) {
			a[i] = inserted[i];
		}
	}

	public static void reverseRotate(int[] a, int d) {
		int l = a.length;
		int[] inserted = new int[l];
		// fill rotated
		for (int i = l - d; i < l; i++) {
			inserted[i - l + d] = a[i];
		}
		// fill rest
		for (int i = 0; i < l - d; i++) {
			inserted[i + d] = a[i];
		}
		// refill a
		for (int i = 0; i < l; i++) {
			a[i] = inserted[i];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCount = 10;
		int[] x = new int[numCount];
		ArrayPlayground.fill(x);
		swapIterate(x, 7);
		ArrayPlayground.print(x);
		System.out.println(rotatedSearch(x, x.length, 4));
	}

}
