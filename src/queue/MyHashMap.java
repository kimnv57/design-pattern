/**
 * Copyright © 2015 Ntq-Solution.
 * 
 */
package queue;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/**
 * class MyHashMap.java
 * 
 * @version 1 4:39:25 PM
 * @author kimnv57
 * @param <K>
 *
 */

public class MyHashMap<K, V> implements Map<K, V> {

	static final int DEFAULT_CAPACITY = 1 << 4; // 16
	static final int MAXIMUM_CAPACITY = 1 << 30;
	static final float DEFAULT_LOAD_FACTOR = 0.75f;

	/**
	 * The load factor for the hash table.
	 *
	 * @serial
	 */
	final float loadFactor;

	private transient int capacity;

	// array of key-value contained in this map
	private transient MyList<Node<K, V>>[] table;

	// the last Node add in this map, using for two-way list.
	private transient Node<K, V> lastNode;

	// numbers of Node contain in this map.
	private transient int size;

	/**
	 * Constructs an empty HashMap with the default initial capacity (16) and
	 * the default load factor (0.75).
	 */

	public MyHashMap() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	/**
	 * Constructs an empty HashMap with the specified initial capacity and the
	 * default load factor (0.75).
	 */
	public MyHashMap(int capacity) {
		this(capacity, DEFAULT_LOAD_FACTOR);
	}

	/**
	 * Constructs an empty HashMap with the specified initial capacity and load
	 * factor.
	 */
	public MyHashMap(int capacity, float loadFactor) {
		if (capacity < 0)
			throw new IllegalArgumentException("Capacity must not negative: "
					+ capacity);
		if (loadFactor <= 0)
			throw new IllegalArgumentException("loadFactor must be positive: "
					+ loadFactor);
		size = 0;
		this.loadFactor = loadFactor;
		if (capacity > MAXIMUM_CAPACITY)
			capacity = MAXIMUM_CAPACITY;
		this.capacity = capacity;
		@SuppressWarnings("unchecked")
		MyList<Node<K, V>>[] nodes = (MyList<Node<K, V>>[]) new MyList[capacity];
		table = nodes;

	}

	/**
	 * Constructs a new HashMap with the same mappings as the specified Map.
	 */
	public MyHashMap(Map<? extends K, ? extends V> m) {// not done yet
		if (m == null)
			throw new NullPointerException();
		this.loadFactor = DEFAULT_LOAD_FACTOR;
	}

	public void print() {
		HashIterator a = new HashIterator();
		while (a.hasNext())
			System.out.println(a.nextNode().getValue());
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		@SuppressWarnings("unchecked")
		K kkey = (K) key;
		int hash = getHashCode(kkey);
		if (table[hash] == null)
			return false;

		// list node at table[hash] contain key.
		return table[hash].containKey(kkey);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean  containsValue(Object value) {
		for (int i = 0; i < capacity; i++) {
			if (table[i] != null) {
				if (table[i].containValue((V) value))
					return true;
			}
		}
		return false;
	}

	@Override
	public V get(Object key) {
		@SuppressWarnings("unchecked")
		K kkey = (K) key;
		int hash = getHashCode(kkey);
		return table[hash].getValueOfKey(kkey);
	}

	@Override
	public V put(K key, V value) {
		if (size + 1 > (capacity * loadFactor)&&capacity!=MAXIMUM_CAPACITY)
			resize(capacity * 2);
		int hash = getHashCode(key);
		Node<K, V> newNode = new Node<K, V>(key, value);
		// create lastNode
		if (size == 0) {
			table[hash] = new MyList<Node<K, V>>();
			table[hash].add(newNode);
			lastNode = newNode;
			size++;
			return null;

		}
		// create list
		if (table[hash] == null) {
			table[hash] = new MyList<Node<K, V>>();
			lastNode.next = newNode;
			newNode.previous = lastNode;
			lastNode = newNode;
			table[hash].add(newNode);
			size++;
			return null;

		}

		if (table[hash].containKey(key))
			return table[hash].replaceNode(key, value);
		lastNode.next = newNode;
		newNode.previous = lastNode;
		lastNode = newNode;
		table[hash].add(newNode);
		size++;
		return null;

	}

	/**
	 * @param i
	 */
	@SuppressWarnings("unchecked")
	private void resize(int newSize) {
		table = (MyList<Node<K, V>>[]) new MyList[newSize];
		HashIterator itr = new HashIterator();
		while (itr.hasNext()) {
			add(itr.nextNode());
		}

	}

	// adding when resize, no change size,no change last node
	private void add(Node<K, V> node) {
		int hash = getHashCode(node.getKey());
		if (table[hash] == null) {
			table[hash] = new MyList<Node<K, V>>();
			table[hash].add(node);
		} else
			table[hash].add(node);
	}

	@Override
	public V remove(Object key) {
		@SuppressWarnings("unchecked")
		K kkey = (K) key;
		if (lastNode.getKey().equals(kkey)) {
			lastNode = lastNode.previous;
		}
		int hash = getHashCode(kkey);
		if (table[hash] == null)
			return null;
		size--;
		return table[hash].removeNodeContainKey(kkey);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {

		// resize
		int mapSize = m.size();
		int needCapacity = capacity + mapSize;
		if (needCapacity > (loadFactor * capacity)
				&& capacity != MAXIMUM_CAPACITY) {
			while (capacity < needCapacity)
				capacity *= 2;
			if (capacity > MAXIMUM_CAPACITY)
				capacity = MAXIMUM_CAPACITY;
			resize(capacity);
		}
		// put all
		for (Map.Entry<? extends K, ? extends V> node : m.entrySet()) {
			put(node.getKey(), node.getValue());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		size=0;
		capacity=DEFAULT_CAPACITY;
		lastNode=null;
		table=(MyList<Node<K,V>>[])new MyList[capacity];
	}

	@Override
	public Set<K> keySet() {
		return null;
	}

	@Override
	public Collection<V> values() {
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return null;
	}

	private int getHashCode(K o) {
		if (o instanceof Number) {
			Number num = (Number) o;
			return num.intValue() % capacity;
		} else {
			String keyString = String.format("%s", 0);
			return getHashCodeFromString(keyString) % capacity;
		}
	}

	private int getHashCodeFromString(String keyString) {
		int value = 0;
		for (int i = 0; i < keyString.length(); i++)
			value = 37 * value + keyString.charAt(i);
		if (value < 0)
			return -value;
		return value;
	}

	@SuppressWarnings("hiding")
	class Node<K, V> {
		K key;
		V value;
		Node<K, V> previous;
		Node<K, V> next;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			previous = null;
			next = null;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.

			value = value;
		}

		public boolean hasNext() {
			return next != null;
		}

		public Node<K, V> getNext() {
			return next;
		}

		public final boolean equals(Object o) {
			if (o == this)
				return true;
			if (o instanceof Node) {
				@SuppressWarnings("unchecked")
				Node<K, V> e = (Node<K, V>) o;
				if (Objects.equals(key, e.getKey())
						&& Objects.equals(value, e.getValue()))
					return true;
			}
			return false;
		}
	}

	class MyList<N> extends LinkedList<Node<K, V>> {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public V replaceNode(K key, V value) {
			Iterator<Node<K, V>> itr = iterator();
			while (itr.hasNext()) {
				Node<K, V> node = itr.next();
				if (node.getKey().equals(key)) {
					V oldValue = node.getValue();
					node.setValue(value);
					return oldValue;
				}
			}
			return null;
		}

		public boolean containKey(K key) {
			Iterator<Node<K, V>> itr = iterator();
			while (itr.hasNext()) {
				if (itr.next().getKey().equals(key))
					return true;
			}
			return false;
		}

		public V removeNodeContainKey(K key) {
			Iterator<Node<K, V>> itr = iterator();
			while (itr.hasNext()) {
				Node<K, V> node = itr.next();
				if (node.getKey().equals(key)) {
					Node<K, V> previousNode = node.previous;
					Node<K, V> nextNode = node.next;
					if (previousNode != null)
						previousNode.next = nextNode;
					if (nextNode != null)
						nextNode.previous = previousNode;
					itr.remove();
					return node.getValue();
				}

			}
			return null;
		}

		public boolean containValue(V value) {
			Iterator<Node<K, V>> itr = iterator();
			while (itr.hasNext()) {
				if (itr.next().getValue().equals(value))
					return true;
			}
			return false;
		}

		public V getValueOfKey(K key) {
			Iterator<Node<K, V>> itr = iterator();
			while (itr.hasNext()) {
				Node<K, V> node = itr.next();
				if (node.getKey().equals(key))
					return node.getValue();
			}
			return null;
		}

	}

	class HashIterator {
		Node<K, V> current; // current entry

		int cusor; // sum current item
		int expectedModCount; // for fast-fail
		int index; // current slot
		int slot; // slot in list

		HashIterator() {
			expectedModCount = size;
			cusor = 0;
			current = lastNode;
		}

		public final boolean hasNext() {
			return cusor < size;
		}

		final Node<K, V> nextNode() {

			if (size != expectedModCount)
				throw new ConcurrentModificationException();
			if (cusor > size)
				throw new NoSuchElementException();
			if (cusor == 0) {
				cusor++;
				return current;
			}
			current = current.previous;
			cusor++;
			return current;

		}

		public final void remove() {
			int hash = getHashCode(current.getKey());

			Node<K, V> previousNode = current.previous;
			Node<K, V> nextNode = current.next;

			size--;
			cusor--;
			if (previousNode != null)
				previousNode.next = nextNode;
			if (nextNode != null)
				nextNode.previous = previousNode;

			if (table[hash].size() == 0) {
				table[hash] = null;
				return;
			}
			Iterator<Node<K, V>> itr = table[hash].iterator();
			while (itr.hasNext()) {
				if (itr.next().equals(current)) {
					itr.remove();
					return;
				}
			}

		}
	}

}
