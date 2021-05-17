/**
 * 
 */
package com.ss.jb.four;

/**
 * @author luisherre
 *
 */
public class ProducerConsumerEx {

	public static void main(String[] args) {
		
		// create bounded buffer
		BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>();

		// create a producer thread
		// override the run() method to put() integers
		// in the bb
		Runnable producer = new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i < bb.getLimit()*2; i++) {
					Integer rand = (int) Math.floor(Math.random() * (100 - 1 + 1) + 1);
					bb.put(rand);
					System.out.println("Producing...");
				}
				
			}
		};

		// create consumer thread
		// override the run() method to remove() integers
		// in the bb
		Runnable consumer = new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i < bb.getLimit()*2; i++) {
					bb.take();
					System.out.println("Consuming...");
				}
			}
		};

		// start threads
		new Thread(producer).start();
		new Thread(consumer).start();
	}

}
