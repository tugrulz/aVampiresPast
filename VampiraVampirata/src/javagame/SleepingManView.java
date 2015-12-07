package javagame;

import java.util.Observable;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SleepingManView extends MovingView{

	// Properties
	String V_ACT = "res/npc/sleeping_";
	String p = ".png";
	
	public SleepingManView() throws SlickException {
		super();
		walkUp = new Image[4];
		walkDown = new Image[4];
		walkRight = new Image[4];
		walkLeft =  new Image[4];
		
		for (int i=0; i <4; i++){
			walkUp[i] = new Image(V_ACT+"up"+i+""+p);
		}
		for (int i=0; i <4; i++){
			walkDown[i] = new Image(V_ACT+"down"+i+""+p);
		}
		for (int i=0; i <4; i++){
			walkLeft[i] = new Image(V_ACT+"left"+i+""+p);
		}
		for (int i=0; i <4; i++){
			walkRight[i] = new Image(V_ACT+"right"+i+""+p);
		}

	
		int[] duration = {200, 200, 200, 200};
		movingUp = new Animation(walkUp, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingDown = new Animation(walkDown, duration, false);
		animList = new Animation[4];
		animList[0] = movingUp; 
		animList[1] = movingRight; 
		animList[2] = movingLeft; 
		animList[3] = movingDown;
		currentAnim = movingDown;
	}
	
	public void draw() throws SlickException {
		if (currentAnim == null)
			System.out.println("null lan bu");
		else 
			currentAnim.draw(obj.posX, obj.posY);
	}
	
	public void setSleepingAnimation(){
		// currentAnim = ...
	}
	
	public void setAwakeAnimation(){
		// currentAnim = ...
	}
	
	public void update(Observable obs, Object arg) {
		// TODO Auto-generated method stub
		if (obs instanceof SleepingMan) {
			//System.out.println("Notifylandým");
			obj = (Moving) obs;
			if (((SleepingMan)obj).isSleeping()){
				this.setSleepingAnimation();
			}
			else
				currentAnim = animList[obj.getMovingDirection().ordinal()];
			//draw();
			
		}
	}
	
}
