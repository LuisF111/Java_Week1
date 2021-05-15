/**
 * 
 */
package com.ss.jb.two;

/**
 * @author Luis Fernandez
 *
 */
public class Triangle implements Shape {

	private int length;
	private int width;
	
	/**
	 * Default constructor. Creates an empty Triangle object.
	 */
	public Triangle() {
		this.length = 0;
		this.width = 0;
	}
	
	/**
	 * Creates a Triangle object with the specified values.
	 *  
	 * @param len
	 * @param wid
	 * 
	 */
	public Triangle(int len, int wid) {
		this.length = len;
		this.width = wid;
	}
	
	/**
	 * Sets the length of the Triangle object.
	 * 
	 * @param len
	 */
	public void setLength(int len) {
		this.length = len;
	}
	
	/**
	 * Sets the width of the Triangle object.
	 * 
	 * @param wid
	 */
	public void setWidth(int wid) {
		this.width = wid;
	}
	
	/**
	 * 
	 * @return the length of the Triangle object.
	 */
	public int getLength() {
		return this.length;
	}
	
	/**
	 * 
	 * @return the width of the Triangle object.
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * Displays the name of the Shape.
	 */
	public void display() {
		System.out.println("Triangle");
	}
	
	/**
	 * @return the area of the Traingle object.
	 */
	public float calculateArea() {
		return (float)(0.5*this.getLength()*this.getWidth());
	}
	
}
