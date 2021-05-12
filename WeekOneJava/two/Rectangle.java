/**
 * 
 */
package com.ss.jb.two;

/**
 * @author Luis Fernandez
 *
 */
public class Rectangle implements Shape {

	private int length;
	private int width;
	
	/**
	 * Default constructor. Creates an empty Rectangle object.
	 */
	public Rectangle() {
		this.length = 0;
		this.width = 0;
	}
	
	/**
	 * Creates a Rectangle object with specified values.
	 * 
	 * @param len
	 * @param wid
	 */
	public Rectangle(int len, int wid) {
		this.length = len;
		this.width = wid;
	}
	
	/**
	 * 
	 *  * Sets length value.
	 * 
	 * @param len
	 * 
	 */
	public void setLength(int len) {
		this.length = len;
	}
	
	/**
	 * * Sets width value
	 * 
	 * @param wid
	 * 
	 */
	public void setWidth(int wid) {
		this.width = wid;
	}
	
	/**
	 * 
	 * @return length of Rectangle object.
	 */
	public int getLength() {
		return this.length;
	}
	
	/**
	 * 
	 * @return width of Rectangle object.
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * Displays name of Object.
	 */
	public void display() {
		System.out.println("Rectangle");
	}
	
	/**
	 * @return the area of the Rectangle.
	 */
	public float calculateArea() {
		return (float)(this.getLength()*this.getWidth());
	}
	
}
