/**
 * 
 */
package com.ss.jb.two;

import java.lang.Math;

/**
 * @author Luis Fernandez
 *
 */
public class MultiArrrayMax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// initialize 2D array with random size from 1 to 10.
		int sizeRow = (int)Math.floor(Math.random()*(10-1+1)+1);
		int sizeCol = (int)Math.floor(Math.random()*(10-1+1)+1);
		int[][] numberArray = new int[sizeRow][sizeCol];
		
		// Assign random values in the array from 1 to 99.
		for(int i = 0; i < sizeRow; i++) {
			for(int j = 0; j < sizeCol; j++) {
				numberArray[i][j] = (int)Math.floor(Math.random()*(99-1+1)+1);
			}
		}
		
		// Find max value and location of value in the 2D array.
		int maxValue = numberArray[0][0];
		int maxLocRow = 0;
		int maxLocCol = 0;
		for(int i = 0; i < sizeRow; i++) {
			for(int j = 0; j < sizeCol; j++) {
				if (numberArray[i][j] > maxValue) {
                    maxValue = numberArray[i][j];
                    maxLocRow = i;
                    maxLocCol = j;
                }
			}
		}
		
		// Display results
		for(int i = 0; i < sizeRow; i++) {
			System.out.println();
			for(int j = 0; j < sizeCol; j++) {
				System.out.print(numberArray[i][j] + " ");
			}
		}
		
		
		System.out.println();
		System.out.println("~~~~~~~Results~~~~~~~");
		
		System.out.println("Max: " + maxValue);
		System.out.println("Row: " + maxLocRow);
		System.out.println("Col: " + maxLocCol);
	}

}
