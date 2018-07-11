package leo.yang;

import java.util.Arrays;

public class CountingSort {
	private static int[] countSorting(int[] a) {
		int max = ArrayPlayground.getMaxValue(a);
		int min = ArrayPlayground.getMinValue(a);
		int[] sorted = new int[a.length];
		int[] index = new int[max-min+1];
		
		//System.out.println("min: " + min + ", max: " + max);
		
		for(int i = 0; i < a.length; i++) {
			index[a[i]-min]++;
			//System.out.println("i: " + i + ", a[i]: " + a[i] + ", index[a[i]-min]: "  + index[a[i]-min]);
		}
		
		for(int i = 1; i < index.length; i++) {
			index[i] += index[i-1];
		}
		//ArrayPlayground.print(index);
		
		for(int i = a.length-1; i >= 0; i--) {
			int value = a[i];
			sorted[index[value - min]-1] = value;
			index[value-min]--;
		}
		
		return sorted;
		
	}
	
	public static void sort(int[] a, int n, int bound) {
		int output[] = new int[n]; 
		int count[] = new int[10];
		Arrays.fill(count, 0);


		for (int i = 0; i < n; i++)
			count[(a[i] / bound) % 10]++;


		for (int i = 1; i < 10; i++)
			count[i] += count[i - 1];


		for (int i = n - 1; i >= 0; i--) {
			output[count[(a[i] / bound) % 10] - 1] = a[i];
			count[(a[i] / bound) % 10]--;
		}


		for (int i = 0; i < n; i++)
			a[i] = output[i];
	}
	
	public static void sort(int[] a) {
		int[] x = countSorting(a);
		for(int i = 0; i < a.length; i++) {
			a[i] = x[i];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = new int[100];
		ArrayPlayground.fillRandom(x, 100);
		ArrayPlayground.print(x);
		//ArrayPlayground.shuffle(x);
		//ArrayPlayground.print(x);
		//countSort(x);
		sort(x);
		ArrayPlayground.print(x);
		System.out.println(ArrayPlayground.checkOrder(x));
	}

}
