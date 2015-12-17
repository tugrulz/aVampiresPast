package javagame;

import org.newdawn.slick.SlickException;

import javagame.Common.Direction;

public class SleepingManController extends MovingController {
	
	// Properties
	final int Y_ERROR = 48;
	
	public SleepingManController(Moving obj, MapControl map){
		super(obj, map);
	}
	
	public void wakeUp(){
		if (((SleepingMan)obj).isSleeping() == true) {
			if (((SleepingMan)obj).getThreshold() < map.getMaxNoise(obj.posFeetX, obj.posFeetY, ((SleepingMan)obj).getScale(), 0.8f)) {
				((SleepingMan)obj).setSleeping(false);
				obj.setPosition(obj.posX, obj.posY+22);
				try {
					Common.msc.playManAwake();
				} catch (SlickException e) {
					System.out.println("Could not play");
				}
			}
		}
	}
	
	public void sleep(){
		if (((SleepingMan)obj).isSleeping() == false) {
			((SleepingMan)obj).setSleeping(true);
			((SleepingMan)obj).setChecked(false);
			obj.setPosition(obj.posX, obj.posY-22);
			try {
				Common.msc.playMainGameMusic();
			} catch (SlickException e) {
				System.out.println("Could not play");
			}

		}
	}

	public void tour() {
		((SleepingMan)obj).setChecked(!((SleepingMan)obj).isChecked());
	}
	
	public void checkPlayer(Character vamp){
		if (((SleepingMan)obj).isSleeping() == false) {
			
			Direction dir = obj.getMovingDirection();
			if (dir == Direction.LEFT) {
				if (obj.getPosFeetX() - vamp.getPosFeetX() < ((SleepingMan)obj).getSight() && checkPlayerY(vamp)) {
					catchPlayer(vamp);
				}
					
			}
			else if (dir == Direction.LEFT) {
				if (vamp.getPosFeetX() - obj.getPosFeetX()  < ((SleepingMan)obj).getSight() && checkPlayerY(vamp) )
					catchPlayer(vamp);
			}
		}
	}
	
	// used for minor errors with y axis
	public boolean checkPlayerY(Character vamp) {
		if (Math.abs(obj.getPosFeetY() - vamp.getPosFeetY()) < Y_ERROR )
			return true;
		else
			return false;
	}
	
	private void catchPlayer(Character vamp) {
		vamp.setCatched(true);
	}
}
