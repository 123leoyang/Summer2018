package leo.yang;

public class Node<T> {
	private T data;
	private Node<T> nextNode;
	
	private Node<T> previousNode;
	public Node (T d, Node x) {
		data = d; 
		nextNode = x;
	}
	
//	returns the data
	public T getData () {
		return data;
	}
	
//	returns the next node stored
	public Node<T> getNext() {
		return nextNode;
	}
	
//	allows data to be changed
	public void setData(T a) {
		data = a;
	}
	
//	allows next node to be changed
	public void setNext(Node a) {
		nextNode = a;
	}
	
	public void setPrev(Node<T> a) {
		previousNode= a;
	}
	public Node<T> getPrev() {
		return previousNode;
	}
	public String toString() {
		return "(node data " + data + ")";
	}
}
