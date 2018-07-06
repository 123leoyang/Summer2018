package leo.yang;

public class QuickSort {
	private static void swap(int[] a, int x, int y) {
		if (x == y) {
			return;
		}
		int temp = a[y];
		a[y] = a[x];
		a[x] = temp;
	}
	private static int partition(int[] a, int start, int end) {
		end--;
		int pivot = a[end];
		int smallestIndex = start - 1;
		for(int i = start; i < end; i++) {
			if(a[i] <= pivot) {
				smallestIndex++;
				swap(a, smallestIndex, i);
			}
		}
		swap(a, smallestIndex +1, end);
        
        return smallestIndex+1;
	}
        
	private static void sort(int[] a, int start, int end) {
		if (start < end-1) {
			int p = partition(a, start, end);
			sort(a, start, p);
			sort(a, p+1, end);
		}
	}
	public static void quickSort(int[] a) {
		sort(a, 0, a.length);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = new int[10];
		ArrayPlayground.fill(x);
		ArrayPlayground.print(x);
		ArrayPlayground.shuffle(x);
		ArrayPlayground.print(x);
		quickSort(x);
		ArrayPlayground.print(x);
	}
}
