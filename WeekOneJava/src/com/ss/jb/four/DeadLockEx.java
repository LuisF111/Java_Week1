/**
 * 
 */
package com.ss.jb.four;

import com.ss.jb.two.Circle;

/**
 * Deadlock example. The deadlock happends because 
 * 
 * ThreadA holds/wants c3 and c2
 * ThreadB holds/wants c2 and c1
 * ThreadC holds/wants c1 and c3
 * 
 * All threads prevent each other from getting the resource needed.
 * 
 * @author Luis Fernandez
 *
 */
public class DeadLockEx {

	public static void main(String[] args) {

		Circle c1 = new Circle(2);
		Circle c2 = new Circle(4);
		Circle c3 = new Circle(6);

		System.out.println("Start of DL Program...");

		Runnable threadA = new Runnable() {

			@Override
			public void run() {
				try {
					synchronized (c3) {
						Thread.sleep(100);
						synchronized(c2) {
							System.out.println("ThreadA has c3 and c2 locks..");
						}
					}
				} catch (Exception e) {

				}
			}
		};

		Runnable threadB = new Runnable() {

			@Override
			public void run() {
				try {
					synchronized (c2) {
						Thread.sleep(100);
						synchronized(c1) {
							System.out.println("ThreadB has c2 and c1 locks..");
						}
					}
				} catch (Exception e) {

				}
			}
		};
		
		Runnable threadC = new Runnable() {

			@Override
			public void run() {
				try {
					synchronized (c1) {
						Thread.sleep(100);
						synchronized(c3) {
							System.out.println("ThreadC has c1 and c3 locks..");
						}
					}
				} catch (Exception e) {

				}
			}
		};
		
		new Thread(threadA).start();
		new Thread(threadB).start();
		new Thread(threadC).start();

		System.out.println("End of DL Program...");
	}

}
