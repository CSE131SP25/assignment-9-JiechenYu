package assignment9;

import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;

public class Game {
	
	private Snake snake; // Define the snake variable
	private Food food;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		// construct new Snake and Food objects
		snake = new Snake();
		food = new Food();
		
	}
	
	public void play() {
		// Intro screen before the loop
		StdDraw.clear();
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(0.5, 0.5, "Press WASD to start");
		StdDraw.show();

		// Wait for the user to press a direction key
		while (getKeypress() == -1) {
		    // Wait and show the message
		    StdDraw.pause(100);
		}
		
		/*
		 * 1. Pass direction to your snake
		 * 2. Tell the snake to move
		 * 3. If the food has been eaten, make a new one
		 * 4. Update the drawing
		 */
		boolean running = true;

	    while (running) {
	        int dir = getKeypress(); // Retrieve the direction of the key
	        if (dir != -1) {
	            snake.changeDirection(dir); // check if the direction is valid
	        }

	        snake.move(); // Move the snake

	        if (snake.eatFood(food)) { // If snake eat the food
	            food = new Food();  // make a new food if eaten
	        }

	        if (!snake.isInbounds()) {
	            running = false;  // Set running to false if it is outside of bound
	        }

	        updateDrawing(); // redraw everything
	    }
	    
	    // Game over screen
//	    StdDraw.clear();
	    StdDraw.setPenColor(Color.RED);
	    StdDraw.text(0.5, 0.5, "Game Over!");
	    StdDraw.show();
	    StdDraw.pause(2000); // Pause for 2 seconds before exiting
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {	
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
		StdDraw.clear();
		snake.draw();
		food.draw();
		StdDraw.pause(200); // Pause the draw process for a few while
		StdDraw.show();
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
