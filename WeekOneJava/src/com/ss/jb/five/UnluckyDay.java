/**
 * 
 */
package com.ss.jb.five;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

/**
 * @author luisherre
 *
 */
public class UnluckyDay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Month month = null;
        LocalDate date = null;

        // check arguments
        if (args.length < 2) {
            System.out.printf("Must enter <month> <day>%n");
            throw new IllegalArgumentException();
        }

        // get month object
        try {
            month = Month.valueOf(args[0].toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.printf("Invalid month argument.");
            e.printStackTrace();
        }

        // convert day argument to integer
        int day = Integer.parseInt(args[1]);

        // get date object ready for query
        try {
            date = Year.now().atMonth(month).atDay(day);
        } catch (DateTimeException e) {
            System.out.printf("Date not valid");
            e.printStackTrace();
        }
        
        // Daisplay results by running a date query
        if(date.query(new UnluckyQuery())) {
        	System.out.println(date + " will be unlucky.");
        }
        else {
        	System.out.println(date + " will be normal.");
        }
        

	}

}
