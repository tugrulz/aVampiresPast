package javagame;

//import org.newdawn.slick.util.pathfinding.Mover;

import javagame.Common.Direction;

public class Moving extends java.util.Observable {
	// Properties
	float posX;
	float posY;
	float posFeetX;
	float posFeetY;
	int width;
	int height;
	float speed;
	
	String name;
	Direction movingDirection; // This is the direction currently the character faces, default is DOWN
	
	public Moving(String name) {
		this.name = name;
		posX = 0;
		posY = 0;
		posFeetX = posX + width/2;
		posFeetY = posY + height;
		movingDirection = Direction.DOWN;
		speed = 0.2f;
	}
	
	public void setPosition(float x, float y) {
		posX = x;
		posY = y;
		updateFeet();
		
		
		//setChanged();
		setChanged();
		notifyObservers();
		clearChanged();
	}
	
	public void changePosition(float change, boolean changeX) {
		if (changeX) posX += change;
		else posY += change;
		updateFeet();
		specifyDirection(change > 0 , changeX);
		
		setChanged();
		notifyObservers();
		clearChanged();
	}
	
	
	
	
	public float getPosFeetX() {
		return posFeetX;
	}

	public void setPosFeetX(float posFeetX) {
		this.posFeetX = posFeetX;
	}

	public float getPosFeetY() {
		return posFeetY;
	}

	public void setPosFeetY(float posFeetY) {
		this.posFeetY = posFeetY;
	}

	/*************************************INNER FUNCTIONS*************************************/
	private void specifyDirection(boolean positive, boolean changeX) {
		if (changeX) movingDirection = (positive) ? Direction.RIGHT : Direction.LEFT;
		else movingDirection = (positive) ? Direction.DOWN : Direction.UP;
	}
	
	private void updateFeet(){
		posFeetX = posX + width/2;
		posFeetY = posY + height*0.9f;
	}
	
	// GET SET TRASH
	public Direction getMovingDirection() {
		return movingDirection;
	}

	public void setMovingDirection(Direction movingDirection) {
		this.movingDirection = movingDirection;
	}
	
	
	

	
	
}
