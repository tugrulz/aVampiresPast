package javagame;

import java.awt.event.ActionEvent;

import javagame.Common.Direction;

public class MovingController {


	
	// The moving object
	Moving obj; // Character, Sleepingman etc.
	MapControl map;

	
	public MovingController(Moving obj, MapControl map) {
		this.obj = obj;
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
	}
	
	public void idle(){
		obj.setMovingDirection(Direction.DOWN);
	}
	
}
