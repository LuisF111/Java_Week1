/**
 * 
 */
package com.ss.jb.wk1;

import java.sql.Connection;

/**
 * @author luisherre
 *
 */
public class SampleSingleton {
	
	private static Connection conn = null;
	
	// The use of volatile prevents JVM to reorder code in the
	// synchronized block.
	private volatile static SampleSingleton instance = null;
	
	private SampleSingleton() {
		System.out.println("Instance created...");
	}

	// Double checked locking to prevent lock acquisition
	// when the instance is already instantiated.
	public static SampleSingleton getInstance() {
		if(instance == null) {
			synchronized(instance) {
				if(instance == null) {
					instance = new SampleSingleton();
				}
			}
		}
		return instance;
	}

}
