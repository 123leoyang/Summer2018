package leo.yang;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
//hi
public class ArrayPlayground {
	public static void fill(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}
	}

	public static void print(int[] a) {
		System.out.println(Arrays.toString(a));
	}

	public static void shuffle(int[] a) {
		ThreadLocalRandom random = ThreadLocalRandom.current();
		for (int i = 0; i < a.length; i++) {
			int randomIndex = i + random.nextInt(a.length - i);
			int temp = a[i];
			a[i] = a[randomIndex];
			a[randomIndex] = temp;
		}
	}

	public static void sort(int[] a, int l, int r) {
		if(l < r-1) {
			int m = (l + r) / 2;
			//`System.out.println(m + " " + l + " " + r);
			sort(a, l, m);
			sort(a, m, r);
			merge(a, l, m, r);
		}
	}

	public static void merge(int[] a, int l, int m, int r) {
		int leftCounter = 0;
		int rightCounter = 0;
		int[] left = Arrays.copyOfRange(a, l, m);
		int[] right = Arrays.copyOfRange(a, m, r);
		int markerA = l;
		while ((leftCounter < left.length) && (rightCounter < right.length)) {
			if(left[leftCounter] >= right[rightCounter]) {
				a[markerA] = left[leftCounter];
				markerA++;
				leftCounter++;
			} else if(left[leftCounter] < right[rightCounter]) {
				a[markerA] = right[rightCounter];
				markerA++;
				rightCounter++;
			}
		}
		while(leftCounter  < left.length) {
			a[markerA] = left[leftCounter];
			markerA++;
			leftCounter++;
		}
		while(rightCounter < right.length) {
			a[markerA] = right[rightCounter];
			markerA++;
			rightCounter++;
		}
		
	}

	public static void mergeSort(int[] a) {
		sort(a, 0, a.length);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = new int[10];
		fill(x);
		print(x);
		shuffle(x);
		print(x);
		mergeSort(x);
		print(x);
	}

}
