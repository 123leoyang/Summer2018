package leo.yang;

public class BinarySearch {
	
	public static int search(int[] a, int x) {
		int l = a.length;
		int first = 0;
		int last = l;
		int middle = (first+last)/2;
		while(true){
			if (a[middle] < x) {
				first = middle+1;
				middle = (first + last)/2;
			} 
			if (a[middle] > x) {
				last = middle;
				middle = (last + first)/2;				
			}
			if(a[middle] == x) {
				if(middle == 0) {
					return middle;
				}
				if(a[middle-1] == x) {
					middle--;
					System.out.println("Repeat");
				} else {
					return middle;
				}
			} 
			if(first >= (last-1)) {
				return -1;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] x = new int[10];
		int[] x= {7,7,7,7,7,7,7,7,7,7};
		//ArrayPlayground.fillRandom(x);
		ArrayPlayground.print(x);
		ArrayPlayground.shuffle(x);
		ArrayPlayground.print(x);
		HeapSort.sort(x);
		ArrayPlayground.print(x);
		int found = search(x, 7);
		if (found == -1) {
			System.out.println("Not Found");
		} else {
			System.out.println("a[" + found + "] = " + x[found]);
		}
	}
}
