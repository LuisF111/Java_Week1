/**
 * 
 */
package com.ss.jb.wk1;

/**
 * @author luisherre
 *
 */
public class LambdaPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Functional Interface Practice.");
		
		PerformOperation isOdd = (num) -> ((num % 2 == 0) ? "EVEN" : "ODD");
		System.out.println(isOdd.function(4));
	}

}
