package leo.yang;

public class HeapSort {
	
	public static void sort(int[] a) {
		int x = a.length;
		
		/*for(int i = 0; i <= x/2-1; i++) {
			heapify(a, x , x/2 - 1 -i);
		}*/
		
		for(int i = (x >> 1) - 1; i >= 0; i--) {
			heapify(a, x , i);
		}
		
		for (int i = x-1; i >= 0; i--) {

            QuickSort.swap(a, 0, i);


            heapify(a, i, 0);
        }
		
	}
	
	private static void heapify(int[] a, int x, int i) {
		// TODO Auto-generated method stub
		int largest = i;  
        int left = (i << 1) + 1;  
        int right = (i << 1) + 2;  
        // left smallest
        if ((left < x) && (a[left] > a[largest])) {
            largest = left;
        }
        // right smallest
        if ((right < x) && (a[right] > a[largest])) {
            largest = right;
		}
        // largest ain't root
        if (largest != i)
        {
            QuickSort.swap(a, largest, i);

            heapify(a, x, largest);
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = new int[100];
		ArrayPlayground.fillRandom(x);
		ArrayPlayground.print(x);
		ArrayPlayground.shuffle(x);
		ArrayPlayground.print(x);
		sort(x);
		ArrayPlayground.print(x);
		System.out.println(ArrayPlayground.checkOrder(x));
	}

}
