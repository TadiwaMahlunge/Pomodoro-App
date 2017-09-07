package application.com;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class FloatingBall extends Circle {
	private double yBound;
	private double xBound;
	private int xMoveBy;
	private int yMoveBy;
	private int direction;
	
	/**
	 * Initialises ball position, bound limits and gives it a direction in which to move.
	 * @param xPos The position along the x axis of the layout pane.
	 * @param yPos The position along the y axis of the layout pane.
	 * @param xBound The width  of the layout pane. The ball cannot exceed this limit.
	 * @param yBound The height of the layout pane. The ball cannot exceed this limit.
	 * @param direction This is the direction the ball starts moving in when it's created.
	 */
	public FloatingBall(double xPos, double yPos, double xBound, double yBound, int direction){
		if (xPos < 6 || xPos > (xBound - 6))
			xPos = 50;
		if (yPos < 6 || yPos > (yBound - 6))
			yPos = 60;
		this.setLayoutX(xPos);
		this.setLayoutY(yPos);
		this.xBound = xBound;
		this.yBound = yBound;
		this.direction = direction;
		setRadius(10);
		setFill(Color.RED);
		setVisible(true);
		
		if (direction == 0){
				xMoveBy = 2;
				yMoveBy = 2;
		}
		else if (direction == 1){
				xMoveBy = 2;
				yMoveBy = -2;
		}
		else if (direction == 2){
				xMoveBy = -2;
				yMoveBy = 2;
		}
		else if (direction == 3){
				xMoveBy = -2;
				yMoveBy = -2;
		}
	}
	
	/**
	 * This moves the ball 2 pixels in its given direction.
	 * If the ball reaches a boundary its direction will be reversed. 
	 */
	public void move(){	
		if (getLayoutX() < 3 || getLayoutX() > (xBound - 3)){
			xMoveBy = -xMoveBy;
			setLayoutX(getLayoutX() + 2*xMoveBy);
		}
		if (getLayoutY() < 3 || getLayoutY() > (yBound - 3)){
			yMoveBy = -yMoveBy;
			setLayoutY(getLayoutY() + 2*yMoveBy);
		}
	
		setLayoutX(getLayoutX() + xMoveBy);
		setLayoutY(getLayoutY() + yMoveBy);
	}
}
