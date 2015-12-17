package javagame;

import java.awt.event.ActionEvent;

import javagame.Common.Direction;

public class MovingController {


	
	// The moving object
	Moving obj; // Character, Sleepingman etc.
	// These are defined here because Moving object does not have access to map properties
	int widthInTiles; 
	int heightInTiles;
	
	MapControl map;

	
	public MovingController(Moving obj, MapControl map) {
		this.obj = obj;
//		heightInTiles = map.getHeigthInTiles(obj.height);
//		widthInTiles = map.getWidthInTiles(obj.width);
//		System.out.println("deneme height and widht" + heightInTiles + " " + widthInTiles);
		this.map = map;
	}
	
	public void move(Common.Direction dir, float delta){
		delta = delta*obj.speed;
		if(map.canMove(obj.posFeetX, obj.posFeetY, dir)) {
			boolean changeX = (dir == Direction.RIGHT || dir == Direction.LEFT);
			int multiplier = (dir == Direction.RIGHT || dir == Direction.DOWN) ? 1 : -1;
			obj.changePosition(multiplier*delta, changeX);
		}
		else
			System.out.println("The player cannot move right now.");
	}
	
	public void idle(){
		obj.setMovingDirection(Direction.DOWN);
	}
	
	// TRASH
	/*public void isOffLimits(){
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}*/
	

	
	
}
