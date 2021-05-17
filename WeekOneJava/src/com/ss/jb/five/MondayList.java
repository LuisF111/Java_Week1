/**
 * 
 */
package com.ss.jb.five;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;

/**
 * @author luisherre
 *
 */
public class MondayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Month month = null;

		if (args.length < 1) {
			System.out.println("Enter a month.");
			throw new IllegalArgumentException();
		}

		// get month object
		try {
			month = Month.valueOf(args[0].toUpperCase());
		} catch (IllegalArgumentException e) {
			System.out.println("Entered value is not a valid month.");
			e.printStackTrace();
		}

		// display results
		System.out.println("For the month of " + month);
		// set date to first Monday of selected month
		LocalDate date = Year.now().atMonth(month).atDay(1).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
		// get month
		Month mi = date.getMonth();
		// while month is still selected month iterate over the Mondays
		// of the month until the month changes.
		while (mi == month) {
			System.out.printf("%s%n", date);
			date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
			mi = date.getMonth();
		}

	}

}
