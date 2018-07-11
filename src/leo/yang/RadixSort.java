package leo.yang;


class RadixSort {


	static void sort(int[] a) {
		int max = ArrayPlayground.getMaxValue(a);

		for (int i = 1; max / i > 0; i *= 10)
			CountingSort.sort(a, a.length, i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = new int[100];
		ArrayPlayground.fillRandom(x, 100);
		ArrayPlayground.print(x);
		sort(x);
		ArrayPlayground.print(x);
		System.out.println(ArrayPlayground.checkOrder(x));
	}

}
