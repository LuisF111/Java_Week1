/**
 * 
 */
package com.ss.jb.one;

/**
 * @author Luis Fernandez
 *
 */
public class PatternPrint {
	public static void main(String[] args) {
        for (int i = 0; i < 4; i++){
            System.out.println((i+1) + ")");
            if (i+1 == 1 ){
                System.out.println("*");
                System.out.println("**");
                System.out.println("***");
                System.out.println("****");
                System.out.println(".........");
            }
            else if (i+1 == 2) {
                System.out.println("..........");
                System.out.println("****");
                System.out.println("***");
                System.out.println("**");
                System.out.println("*");
            }
            else if (i+1 == 3) {
                System.out.println("    *");
                System.out.println("   ***");
                System.out.println("  *****");
                System.out.println(" *******");
                System.out.println("...........");
            }
            else{
                System.out.println("............");
                System.out.println(" *******");
                System.out.println("  *****");
                System.out.println("   ***");
                System.out.println("    *");
            }
        }
    }
}
