package leo.yang;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {

	public static void sort(int[] a) {
		if (a.length == 0) {
			return;
		}
		int minVal = ArrayPlayground.getMinValue(a);
		int maxVal = ArrayPlayground.getMaxValue(a);
		// System.out.printf("Min: %d, Max %d \n", minVal, maxVal);

		int numberOfBuckets = 10;
				
		int interval = (maxVal - minVal) / numberOfBuckets + 1;
		List[] buckets = new ArrayList[numberOfBuckets];
//		ArrayList<Integer>[] buckets = new ArrayList<Integer>[maxVal - minVal + 1];

		// initialize each bucket
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>();
		}

		// add elements to each bucket by interval
		for (int i = 0; i < a.length; i++) {
			int curr = a[i];
			int insertedIndex = (curr - minVal) / interval;
//			System.out.printf("Current: %d, Inserted Index: %d , Number of Buckets, %d"
//					+ "\n", curr, insertedIndex, numberOfBuckets);
			List bucket = buckets[insertedIndex];
				boolean inserted = false;
				for (int j = 0; j < bucket.size(); j++) {
					if (((int) bucket.get(j)) > curr) {
						bucket.add(j, curr);
						inserted = true;
						break;
					//} else if (j==bucket.size()-1) {
					//	bucket.add(curr);
					}
				}
				if (!inserted) {
					bucket.add(curr);
				}

		}

		// run through each bucket
		int index = 0;
		for (int i = 0; i < numberOfBuckets; i++) {
			// extract elements from each bucket
			for (int l = 0; l < buckets[i].size(); l++) {
				// System.out.printf("index: %d, a[%d]: %d \n", index, index, a[index]);
				a[index] = (int) buckets[i].get(l);
				index++;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCount = 100000;
		int[] x = new int[numCount];
		ArrayPlayground.fillRandom(x, Integer.MAX_VALUE);
		//ArrayPlayground.print(x);
		
		long start = System.currentTimeMillis();
		sort(x);
		System.out.println("\n---\n" +(System.currentTimeMillis()-start)+ "ms");
	//	ArrayPlayground.print(x);
		System.out.println(ArrayPlayground.checkOrder(x));
	}

}
