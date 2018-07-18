package leo.yang;

import javax.management.RuntimeErrorException;

public class Deque {
	private static int size;
	private static int f;
	private static int r;
	int a[];

	public Deque(int x) {
		a = new int[x];
		f = -1;
		r = 0;
		size = x;
	}
	public boolean isFull() {
		return (((f == 0) && (r == size - 1)) || (f == r + 1));
	}
	public boolean isEmpty() {
		return (f == -1);
	}
	public void addFront(int pos) {
        if (isFull()) {
            System.out.println("Overflow"); 
            return;
        }
//        initially empty
        if (f == -1) {
            f = 0;
            a[f] = pos;
        }
//        at first position
        else if (f == 0) {
            f = size - 1 ;
            a[f] = pos;
        }
//        decrement front end
        else {
            f = f-1;
            a[f] = pos;
        }
	}
	public void addRear(int x)
    {
        if (isFull()) {
            System.out.println(" Overflow ");
            return;
        }
//        initially empty
        if (f == -1) {
            f = 0;
            r = 0;
            a[r] = x ;
        } 
//        rear is at last position
        else if (r == size-1) {
            r = 0;
            a[r] = x ;
        }
//        increment rear end
        else {
            r = r+1;
            a[r] = x ;
        } 
    }
	public int popFront() {
//		check empty
		if (isEmpty()) {
			throw new RuntimeErrorException(null, "Underflow");
		}
//		has one element
		if (f == r)
        {
			int x = a[f];
            f = -1;
            r = -1;
            return x;
        }
//		at the rear end
		if (f == size - 1) {
			int x = a[f];
            f = 0;
            return x;
		}
//		still in the middle
		else {
			int x = a[f];
            f++;
            return x;
		}
	}
	public int popRear() {
//		check empty
		if (isEmpty()) {
			throw new RuntimeErrorException(null, "Underflow");
		}
//		has one element
		if (f == r)
        {
			int x = a[f];
            f = -1;
            r = -1;
            return x;
        }
//		at the front end
		if (r == 0) {
			int x = a[r];
            r = size - 1;
            return x;
		}
//		still in the middle
		else {
			int x = a[r];
            r--;
            return x;
		}
	}
}
