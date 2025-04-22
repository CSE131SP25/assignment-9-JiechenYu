package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		//set up the segments instance variable
		deltaX = 0;
		deltaY = 0;
		
		segments = new LinkedList<>(); // Initialize linked list
		segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE)); // add a new body segment to the center of screen 
		
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		// Store the previous x and y of each segment
	    double prevX = segments.get(0).getX();
	    double prevY = segments.get(0).getY();

	    // Move head
	    BodySegment head = segments.get(0);
	    head.setX(head.getX() + deltaX);
	    head.setY(head.getY() + deltaY);

	    // Move the rest of the body
	    for (int i = 1; i < segments.size(); i++) { // iterate through each element from the segment list
	        BodySegment current = segments.get(i);

	        // Save current position to pass to next one
	        double tempX = current.getX();
	        double tempY = current.getY();

	        current.setX(prevX);
	        current.setY(prevY);

	        // Pass position down the line
	        prevX = tempX;
	        prevY = tempY;
	    }
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for (BodySegment bodySegment:segments) { // iterate through each line of the the segments
			bodySegment.draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
	    BodySegment head = segments.get(0);
	    double dx = head.getX() - f.getX();
	    double dy = head.getY() - f.getY();
	    double distance = Math.sqrt(dx * dx + dy * dy); // Get the distance from the snake and the food

	    if (distance < SEGMENT_SIZE + f.getSize()) { // If the food and head of the snake overlap
	        BodySegment tail = segments.getLast(); // get the tail of the snake
	        segments.add(new BodySegment(tail.getX(), tail.getY(), SEGMENT_SIZE)); // add segment to the end of the tail| add segment to the end of the linked list
	        return true; // return true indicates the snake has eaten the food
	    }
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
	    BodySegment head = segments.get(0);
	    double x = head.getX();
	    double y = head.getY();
	    
	    // check if the head of the snake is within bound
	    if (x >= SEGMENT_SIZE && x <= 1 - SEGMENT_SIZE && y >= SEGMENT_SIZE && y <= 1 - SEGMENT_SIZE) {
	    	    return true;
	    	} else {
	    	    return false;
	    	}
	    
	    
	}
}
