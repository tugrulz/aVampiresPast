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
		
		//setChanged(); // WILL CHANGE IT LATER TO APPROPRIATE FUNCTIONS
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
		System.out.println("change position functionýndayým");
		if (changeX) posX += change;
		else posY += change;
		updateFeet();
		specifyDirection(change > 0 , changeX);
		
		setChanged();
		notifyObservers();
		clearChanged();
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
	
	// TRASHHHHHHHHHHHHHHH
	// This positions are the positions of the object's feet
	//int posX; 
	//int posY;
	// TRASH ALGORITH
	// Every character has a base (i.e. foot) to move on ground. posX and posY are the position of this base. However
	// a base may be too wide that it could occupy 3 tiles at once. To detect the collision with neighbouring tiles, 
	// we set a simple algorithm:
	/* 1. Set the position of the base at the middle.
	 * 2. Set how much tiles the base occupies.
	 * 3. Set how much of the boundaring tiles the base should NOT OCCUPY (set as percent)
	 * 4. If a base occupies larger than it supposed to, this is considered moving between tiles. 
	 * 5. In case this happens, collision detection detects if the next tile is movable or not.
	 * 6. If not movable, then the character's position won't be changed.
	 * 
	 * In this game, both the Character and the sleeping man are humans which has the same dimensions. 
	 * So their base (foot) takes 1 tile, and percent is set to 0.5
	 */
//	float percent = 0.5f;
	
	
	
	

	
	
}
