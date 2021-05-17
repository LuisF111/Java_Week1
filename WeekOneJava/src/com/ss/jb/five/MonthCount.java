/**
 * 
 */
package com.ss.jb.five;

import java.time.DateTimeException;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;

/**
 * @author luisherre
 *
 */
public class MonthCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int year = 0;

		if (args.length <= 0) {
			System.out.println("Enter a year in <xxxx> format.");
			throw new IllegalArgumentException();
		}

		// convert input to Integer
		try {
			year = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.out.printf("Argument must me an Integer.");
			e.printStackTrace();
		}

		// check that year is valid
		try {
			Year enteredYear = Year.of(year);
		} catch (DateTimeException e) {
			System.out.println("Year is not valid.");
			e.printStackTrace();
		}

		// Display results
		System.out.println("Year: " + year);
		for (Month month : Month.values()) {
			YearMonth yearMon = YearMonth.of(year, month);
			System.out.println(month + ": " + yearMon.lengthOfMonth());
		}
	}

}
