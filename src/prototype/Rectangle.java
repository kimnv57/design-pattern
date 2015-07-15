/**
 * Copyright © 2015 Ntq-Solution.
 * 
 */
package prototype;

/**
 * class RecTangle.java
 * 
 * @version 1 5:02:11 PM
 * @author kimnv57
 *
 */
public class Rectangle extends Shape {

	public Rectangle() {
		type = "Rectangle";
	}

	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}