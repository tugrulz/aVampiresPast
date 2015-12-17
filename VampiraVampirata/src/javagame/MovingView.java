package javagame;

import java.util.Observable;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MovingView implements java.util.Observer {

	
	// Properties
	Animation currentAnim, movingLeft, movingRight, movingUp, movingDown;
	Animation[] animList;
	Moving obj;
	
	//
	Image[] walkUp;
	Image[] walkDown;
	Image[] walkLeft;
	Image[] walkRight;

	
	public MovingView(Animation a) throws SlickException {
		currentAnim = a;
	}
	public MovingView() throws SlickException {
	}
	
	public void setDefault(Animation a) {
		currentAnim = a;
	}
	@Override
	public void update(Observable obs, Object arg) {
		// TODO Auto-generated method stub
		if (obs instanceof Moving) {
			obj = (Moving) obs;
			currentAnim = animList[obj.getMovingDirection().ordinal()];
			currentAnim.draw();
		}
		
	}
	
}
