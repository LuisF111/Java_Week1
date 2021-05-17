/**
 * 
 */
package com.ss.jb.four;

/**
 * @author Luis Fernendez
 *
 */
public class DCLSingleton {
	
	// The use of volatile prevents JVM to reorder code in the
	// synchronized block.
	private static volatile DCLSingleton instance = null;

	private DCLSingleton() {
		System.out.println("Instance Created...");
	}

	// Double checked locking to prevent lock acquisition
	// when the instance is already instantiated.
	public static DCLSingleton getInstance() {
		if (instance == null) {
			synchronized (instance) {
				if (instance == null) {
					instance = new DCLSingleton();
				}
			}
		}
		return instance;
	}
}
