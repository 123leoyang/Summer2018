package leo.yang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashMap<K, V>{
	
	private ArrayList<Entry<K, V>>[] store;
	private int capacity;
	private int size;
	
	public HashMap(int a) {
		capacity = a;
		size = 0;
	    Object [] tab = new Object[a];;
		store = (ArrayList<Entry<K, V>>[]) new ArrayList[a];
	}


	public void put(K k, V v) {
		Entry yeet = new Entry(k, v);
		int i = hash(k); 
		if (store[i] == null) {
			store[i] = new ArrayList<Entry<K, V>>();
			return;
		}
		for (int j = 0; j < store[i].size(); j++) {
			if  (store[i].get(j).k.equals(k)) {
				store[i].add(j, yeet);
				System.out.println("Repitition");
				return;
			}
		}
		store[i].add(yeet);
		yeet.setIndex(store[i].size());
		size++;
	}
	
	public int getSize () {
		
		return size;
	}
	
	public V get (K k) {
		
		int i = hash(k);
		
		for (int j = 0; j < store[i].size(); i++ ) {
			if (store[i].get(j).k.equals(k)) {
				return store[i].get(j).v;
			}
		}
		
		return null;
	}
	
	public void remove(K k) {
		int i = hash(k);
		
		for (int j = 0; j < store[i].size(); i++ ) {
			if (store[i].get(j).k.equals(k)) {
				store[i].remove(j);
				size--;
				return;
			}
		}
	}
	
	
	
	private static class Entry <K, V>{
		K k;
		V v;
		int index;
		public Entry(K k2, V v2) {
			k= k2;
			v = v2;
			index = 0;
		}
		
		public void setIndex(int i) {
			index = i;
		}
	}
	
	public int hash(K k) {
		return k.hashCode()%capacity;
	}
	
}
