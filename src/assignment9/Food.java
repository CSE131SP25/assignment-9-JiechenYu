package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		x = FOOD_SIZE + (1 - 2 * FOOD_SIZE) * Math.random(); // generate the x and y axis for red dot is within bound
		y = FOOD_SIZE + (1 - 2 * FOOD_SIZE) * Math.random(); // coordinates should always between food size and 1 - food size
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		StdDraw.setPenColor(Color.RED);
	    StdDraw.filledCircle(x, y, FOOD_SIZE);
	}
	
	// Add the getter for x, y and size
	public double getX() {
	    return x;
	}

	public double getY() {
	    return y;
	}

	public double getSize() {
	    return FOOD_SIZE;
	}
}
