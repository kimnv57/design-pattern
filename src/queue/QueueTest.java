/**
 * Copyright © 2015 Ntq-Solution.
 * 
 */
package queue;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * class MyTest.java
 * 
 * @version 1 8:50:47 AM
 * @author kimnv57
 *
 */
public class QueueTest {

	private MyQueue<Integer> queue;

	@Before
	public void init() {
		queue = new MyQueue<Integer>();
	}

	@Test
	public void testIsEmptyOnEmpty() {
		assertTrue(queue.isEmpty());
	}

	@Test
	public void testIsEmptyOnNotEmpty() {
		queue.add(5);
		assertTrue(!queue.isEmpty());
	}

	@Test
	public void testOnepoll() {
		queue.add(5);
		assertTrue(5 == queue.poll());
	}

	@Test
	public void testOrdering() {
		queue.add(1);
		queue.add(2);
		queue.add(3);
		assertTrue(1 == queue.poll());
		assertTrue(2 == queue.poll());
		assertTrue(3 == queue.poll());
	}

	@Test
	public void testEmptyAfterpoll() {
		queue.add(5);
		queue.poll();
		assertTrue(queue.isEmpty());
	}

}