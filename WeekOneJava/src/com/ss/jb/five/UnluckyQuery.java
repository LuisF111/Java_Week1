/**
 * 
 */
package com.ss.jb.five;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

/**
 * 
 * This object makes a date query to check if the date is a Friday 13th
 * 
 * @author luisherre
 *
 */
public class UnluckyQuery implements TemporalQuery<Boolean> {

	public Boolean queryFrom(TemporalAccessor date) {
		return ((date.get(ChronoField.DAY_OF_MONTH) == 13) && (date.get(ChronoField.DAY_OF_WEEK) == 5));
	}

}
