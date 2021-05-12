/**
 * 
 */
package com.ss.jb.two;

/**
 * @author Luis Fernandez
 *
 */
public class ArgumentAdder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Check for args
		if (args.length > 0) {
			
			int[] numberArray = new int[args.length];
			
			// Convert str to int throw exception otherwise.
		    try {
		    	for(int i = 0; i < numberArray.length; i++) {
		    		numberArray[i] = Integer.parseInt(args[i]);
		    	}
		    } catch (NumberFormatException e) {
		        System.err.println("Argument" + args[0] + " must be an integer.");
		        System.exit(0);
		    }
		    
		    // Add values together
		    int totalSum = 0;
		    for(int i = 0; i < numberArray.length; i++) {
		    	totalSum = totalSum + numberArray[i];
		    }
		    System.out.println("Total: " + totalSum);
		    System.exit(0);
		}
		else {
			System.err.println("Command line arguements missing.");
			System.exit(0);
		}
	}

}
