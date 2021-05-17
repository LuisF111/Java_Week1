/**
 * 
 */
package com.ss.jb.four;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * This BoundedBuffer Class implements a blocking queue.
 * The queue will block a producer thread if its full or
 * block a consumer thread if its empty.
 * 
 * @author Luis Fernandez
 *
 */
public class BoundedBuffer<E> {

	private Queue<E> queue;
	private int limit = 20;
	private Object notEmpty = new Object();
	private Object notFull = new Object();

	public BoundedBuffer() {
		queue = new LinkedList<>();
	}

	public BoundedBuffer(int size) {
		queue = new LinkedList<>();
		limit = size;
	}

	/**
	 * This method produces an item in to the bounded buffer
	 * it will block if the bounded buffer is full.
	 * 
	 * @param item
	 */
	public void put(E item) {
		try {
			synchronized (notEmpty) {
				while (queue.size() == limit) {
					System.out.println("Waiting to produce...");
					notFull.wait();
				}
				queue.add(item);
				notEmpty.notifyAll();
			}

		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

	/**
	 * This method consumes an item from the bounded buffer
	 * it will block if the bounded buffer is empty.
	 * 
	 * @return
	 */
	public E take() {
		E item = null;
		try {
			synchronized(notFull) {
				if (queue.size() == 0) {
					System.out.println("Waiting to consume...");
					notEmpty.wait();
				}
				item = queue.remove();
				notFull.notifyAll();
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return item;
	}

	/**
	 * 
	 * @return limit of the bounded buffer
	 */
	public int getLimit() {
		return limit;
	}
}
