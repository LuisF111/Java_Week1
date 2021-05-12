/**
 * 
 */
package com.ss.jb.two;

/**
 * @author Luis Fernandez
 *
 */
public class Circle implements Shape{

	private int radius;
	
	/**
	 * Default constructor. Creates an empty Circle object.
	 */
	public Circle() {
		this.radius = 0;
	}
	
	/**
	 * Creates a Circle object with the specified value.
	 * @param rad
	 */
	public Circle(int rad) {
		this.radius = rad;
	}
	
	/**
	 * Sets the radius of the Circle object.
	 * 
	 * @param rad
	 */
	public void setRadius(int rad) {
		this.radius = rad;
	}
	
	/**
	 * 
	 * @return the radius of the Circle object.
	 */
	public int getRadius() {
		return this.radius;
	}
	
	/**
	 * Displays the name of the Shape.
	 */
	public void display() {
		System.out.println("Circle");
	}
	
	/**
	 * @return the area of the Circle object.
	 */
	public float calculateArea() {
		return (float)(3.14*this.getRadius()*this.getRadius());
	}
	
}
