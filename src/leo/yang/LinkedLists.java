package leo.yang;


public class LinkedLists<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public LinkedLists() {
		head = null;
		tail = null;
		size = 0;
	}
	
//	find function
	public T get(int x) {
		//System.out.println("get (x):" +  x + " head: " + head + " : " + size);
		
		if (x >= 0 && x < size) {
			return node(x).getData();
		} else {
			return null;
		}
}

//	find size of ll
	public int getSize() {
		return size;
	}
	
	private void insertFront(Node<T> x) {
		if (head == null) {
			head = x;
			tail = x;
			size = 1;
		} else {
			x.setNext(head);
			head.setPrev(x);
			head = x;
			size++;
		}
	}
	
	private void insertAfter(Node<T> x, Node<T> prev) {
		if (prev.getNext() != null) {
			x.setNext(prev.getNext());
			prev.getNext().setPrev(x);
			prev.setNext(x);
			x.setPrev(prev);
			size++;
		} else {
			prev.setNext(x);
			x.setPrev(prev);
			tail = x;
			size++;
		}
	}
	
	public Node<T> node(int n) {
		//System.out.println("Node (x):" +  n + " head: " + head + " : " + size);
		
		Node<T> temp = head;
		int count = 0;
		while(true) {
			//System.out.println("Node (x): while " +  n + " temp=" + temp + " head: " + head + " : " + size);
			
			if(count == n) {
				return temp;
			} else {
				count++;
				temp = temp.getNext();
			}
		}
	}
	
	public void add(T val) {
		Node<T> added = new Node<T>(val, null);
		if (tail == null) {
			insertFront(added);
		} else {
			insertAfter(added, tail);
		}
	}
	
	public void add(T val, int i) {
		Node<T> added = new Node<T>(val, null);
		if (i == 0) {
			insertFront(added);
			return;
		}
		if(i >= size) {
			throw new IndexOutOfBoundsException("Overflow, index too high" + i);
		}
		insertAfter(added, node(i-1));
	}
	private void removeHeader() {
		if (head == null) {
			System.out.println("removed nothing");
			
			size = 0;
			if (tail != null) {
				throw new IndexOutOfBoundsException("WHAT ARE YOU DOING WITH YOUR CODE? FIX IT!");
			}
		} else {
			if (head == tail) {
				head = tail = null;
				size = 0;
			} else {
				head = head.getNext();
				size--;
			}
		}
	}
	
	private void removeNode(Node<T> x) {
		//System.out.println("remove Node (x):" +  x + " head: " + head + " : " + size);
		
		if (x == head) {
			removeHeader();
		} else {
			if (x.getNext() == null) {
				Node<T> temp = x;
				temp.getPrev().setNext(null);
				temp.setPrev(null);
				tail = temp.getPrev();
			} else {
				Node<T> temp = x;
				temp.getPrev().setNext(x.getNext());
				temp.getNext().setPrev(x.getPrev());
				size--;
			}
		}
	}
	
	public void remove() {
//		System.out.println("remove ():" +  " head: " + head + " : " + size);
		if(head==null) {
			if(tail == null) {
				removeHeader();
				return;
			} else {
				throw new IndexOutOfBoundsException("CMON IX YOUR CODE");
			}
		} else {
			size--;
			removeNode(node(size));
			return;
		}
	}
	
	public void remove(int i) {
//		System.out.println("remove i:" + i + " head: " + head + ": " + size);
		if (i == 0) {
			removeHeader();
			return;
		} 
		if (i > size) {
			throw new IndexOutOfBoundsException("Overflow");
		} else {
			removeNode(node(i));
		}
	}
	
	public Object[] toArray() {
		Object[] a = new Object[size];
		for(int i = 0; i < size; i++) {
			a[i] = node(i).getData();
		}
		return a;
	}
	
}
