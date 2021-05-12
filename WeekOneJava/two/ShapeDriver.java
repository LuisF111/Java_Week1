/**
 * 
 */
package com.ss.jb.two;

/**
 * @author Luis Fernandez
 *
 */
public class ShapeDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Create shapes
		Rectangle rec = new Rectangle(3, 4);
		Triangle tri = new Triangle(3, 4);
		Circle cir = new Circle(4);
		
		// Display values
		rec.display();
		System.out.println("L: " + rec.getLength());
		System.out.println("W: " + rec.getWidth());
		System.out.println("A: " + rec.calculateArea() + '\n');
		
		tri.display();
		System.out.println("L: " + tri.getLength());
		System.out.println("W: " + tri.getWidth());
		System.out.println("A: " + tri.calculateArea() + '\n');
		
		cir.display();
		System.out.println("R: " + cir.getRadius());
		System.out.println("A: " + cir.calculateArea());
	}

}
