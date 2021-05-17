/**
 * 
 */
package com.ss.jb.wk1;

/**
 * @author luisherre
 *
 */
public class RecursionPractice {

	/**
	 * 
	 * Assignment 5
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Group integers to form target sum.");
		
		int[] l1 = new int[]{2,4,8};
		int[] l2 = new int[]{1,2,4,8,1};
		int[] l3 = new int[]{2,4,4,8};
		
		
		
		if (groupSumClump(0, l1, 10)) {
			System.out.println("Its Possible");
		}
		else {
			System.out.println("Its Impossible");
		}
		
		if (groupSumClump(0, l2, 10)) {
			System.out.println("Its Possible");
		}
		else {
			System.out.println("Its Impossible");
		}
		
		if (groupSumClump(0, l3, 10)) {
			System.out.println("Its Possible");
		}
		else {
			System.out.println("Its Impossible");
		}

	}
	
	// A5
	public static boolean groupSumClump(int start, int[] numbers, int target) {
		if (target == 0)
			return true;
		else if (start == numbers.length)
			return false;
		else {
			return groupSumClump(start+1, numbers, target-numbers[start]) || groupSumClump(start+1,numbers,target);
		}
	}

}
