/**
 * Copyright © 2015 Ntq-Solution.
 * 
 */
package prototype;

/**
 * class Circle.java
 * 
 * @version 1 5:02:57 PM
 * @author kimnv57
 *
 */
public class Circle extends Shape {

	public Circle() {
		type = "Circle";
	}

	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}
}