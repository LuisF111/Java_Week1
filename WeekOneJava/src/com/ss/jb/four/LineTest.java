/**
 * 
 */
package com.ss.jb.four;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.*;

/**
 * @author Luis Fernandez
 *
 */
public class LineTest {
	
	@Test
	public void slopeTest() {
		Line t = new Line(0,0,1,2);
		assertEquals(2.0d, t.getSlope(), 0.0001);
		assertNotEquals(1.0d, t.getSlope(), 0.0001);
	}
	
	@Test
	public void distanceTest() {
		Line t = new Line(9,7,3,2);
		assertEquals(7.8102d, t.getDistance(), 0.0001);
		assertNotEquals(1.0d, t.getDistance(), 0.0001);
	}
	
	@Test
	public void parallelTest() {
		Line t1 = new Line(0,0,1,2);
		Line t2 = new Line(1,-1,2,1);
		Line t3 = new Line(2,0,1,2);
		assertEquals(true, t1.parallelTo(t2));
		assertNotEquals(true, t1.parallelTo(t3));
	}
	
}
