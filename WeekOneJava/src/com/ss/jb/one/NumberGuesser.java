/**
 * 
 */
package com.ss.jb.one;

import java.util.*;
import java.lang.Math;

/**
 * @author Luis Fernandez
 *
 */
public class NumberGuesser {
	public static void main(String[] args){
        int tries = 5, userGuess;
        int randNumber = (int)Math.floor(Math.random()*(100-1+1)+1);
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("Guess a number [1-100]");
            userGuess = Integer.parseInt(scanner.nextLine());

            if (((userGuess <= randNumber+10) && (userGuess >= randNumber-10)) || (userGuess == randNumber)) {
            	System.out.println("Guess: " + userGuess);
            	System.out.println("Result: " + randNumber);
                System.exit(0);
            }

            System.out.println("Sorry");

            tries--;
        } while (tries > 0);
        scanner.close();
        System.exit(0);
    }
}
