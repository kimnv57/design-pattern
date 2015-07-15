/**
 * Copyright © 2015 Ntq-Solution.
 *
 */

package queue;

import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * class Queue.java
 * 
 * @version 1 8:44:44 AM
 * @author kimnv57
 *
 */
class Node<E> {
	public E value;
	public Node<E> next;

	public Node(E e) {
		value = e;
		next = null;
	}
}

public class MyQueue<E> implements Queue<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;

	/*
	 * to do
	 */
	public MyQueue() {
		head = null;
		tail = null;
		size = 0;
	}

	/*
	 * to do
	 */
	@Override
	public boolean add(E e) {
		if (e == null)
			return false;
		Node<E> newNode = new Node<E>(e);
		if (size == 0) {
			tail = newNode;
			head = newNode;
			size++;
			return true;
		} else {
			tail.next = newNode;
			tail = newNode;
			size++;
			return true;
		}
	}

	/*
	 * to do return the value of the tail element of the queue not remove
	 */
	@Override
	public E peek() {
		return head.value;
	}

	/*
	 * to do return the value of the tail element of the queue remove
	 */
	@Override
	public E poll() {
		if (size > 1) {
			E value = head.value;
			head = head.next;
			size--;
			return value;
		}
		if (size == 1) {
			E value = head.value;
			head = head.next;
			size--;
			tail = null;
			return value;
		}
		return null;
	}

	/*
	 * to do size of queue
	 */

	public int size() {

		return size;
	}

	/*
	 * to do
	 */
	@Override
	public boolean contains(Object o) {
		E find = (E) o;
		Node<E> current = head;
		while (current != null) {
			if (current.value.equals(find)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	/*
	 * to do
	 */

	public boolean addAll(Collection<? extends E> c) {
		if (c == null || c == this)
			return false;
		boolean isOk = true;
		for (E e : c) {
			if (!add(e))
				isOk = false;
		}
		return isOk;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		if (c == null)
			return false;
		return false;
	}

	public Iterator iterator() {
		return new MyIterator();
	}

	@Override
	public E remove() {
		if (isEmpty())
			throw new NullPointerException();
		return poll();
	}

	@Override
	public E element() {
		if (isEmpty())
			throw new NoSuchElementException();
		return peek();
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		Iterator itr = iterator();
		int i = 0;
		while (itr.hasNext()) {
			array[i] = itr.next();
			i++;
		}
		return array;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		@SuppressWarnings("unchecked")
		T[] copyOf = (T[]) Arrays.copyOf(toArray(), size, a.getClass());
		return copyOf;
	}

	@Override
	public boolean remove(Object o) {
		if (isEmpty() || o == null)
			throw new NullPointerException();
		E find = (E) o;
		Node<E> current = head;
		Node<E> back = null;
		int cussor = 1;
		while (current != null) {
			if (current.value.equals(find)) {
				//back(previous node) null and size>1 => need chage head
				if (back == null && size > 1) {
					head = head.next;
					size--;
				}
				// previous node null and size =1 => delete the only element
				if (back == null && size == 1) {
					head = null;
					tail = null;
					size = 0;
				}
				// previous node not null so change the pointer of previous node(back)
				if (back != null && size > 1 && cussor != size) {
					current = back;
					current.next = current.next.next;
					cussor--;
					size--;
				}
				//delete last node
				if (back != null && cussor == size) {
					System.out.println("chay4");
					tail = back;
					tail.next = null;
					size--;
				}
				return true;
			}
			cussor++;
			back = current;
			current = current.next;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		if (c == null)
			throw new NullPointerException();
		for (Object e : c)
			if (!contains(e))
				return false;
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		if (c == null)
			throw new NullPointerException();

		boolean isRemove = false;
		Iterator it = iterator();
		while (it.hasNext()) {
			if (!c.contains(it.next())) {
				it.remove();
				isRemove = true;
			}
		}
		return isRemove;
	}

	@Override
	public void clear() {
		size = 0;
		head = null;
		tail = null;
	}

	@Override
	public boolean offer(E e) {
		return add(e);
	}

	private final class MyIterator implements Iterator<E> {
		private int cursor = 0;
		private Node<E> current = null;
		private LinkedList<Node<E>> back = new LinkedList<Node<E>>();
		private int expectedCount = size;

		public boolean hasNext() {
			return cursor < size;
		}

		public E next() {

			if (expectedCount != size)
				throw new ConcurrentModificationException();
			if (hasNext()) {
				cursor++;
				if (current == null) {
					current = head;
					return current.value;
				} else {
					back.add(current);
					current = current.next;
					return (E) current.value;
				}

			}
			throw new NoSuchElementException();
		}

		public void remove() {

			if (expectedCount != size)
				throw new ConcurrentModificationException();
			if (cursor == 1) {
				poll();
				current = tail;
				expectedCount = size;
			}
			if (cursor > 1) {
				current = back.removeLast();
				current.next = current.next.next;
				expectedCount = --size;
				cursor--;
			}
		}
	}

}
