package javagame;

import java.util.Observable;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SleepingManView extends MovingView{

	// Properties
	String V_ACT = "res/npc/sleeping_";
	String p = ".png";
	Image[] sleeping;
	
	public SleepingManView() throws SlickException {
		super();
		walkUp = new Image[3];
		walkDown = new Image[3];
		walkRight = new Image[3];
		walkLeft =  new Image[3];
		sleeping = new Image[3];
		
		for (int i=1; i <= 3; i++){
			walkUp[i-1] = new Image(V_ACT+"up_"+i+""+p);
		}
		for (int i=1; i <=3; i++){
			walkDown[i-1] = new Image(V_ACT+"down_"+i+""+p);
		}
		for (int i=1; i <=3; i++){
			walkLeft[i-1] = new Image(V_ACT+"left_"+i+""+p);
		}
		for (int i=1; i <=3; i++){
			walkRight[i-1] = new Image(V_ACT+"right_"+i+""+p);
		}

		for (int i=0; i <3; i++){
			sleeping[i] = new Image(V_ACT+i+""+p);
		}
		
		int[] duration = {200, 200, 200};
		int[] duration2 = {4800, 4800, 4800};
		movingUp = new Animation(walkUp, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingDown = new Animation(walkDown, duration, false);
		animList = new Animation[5];
		animList[0] = movingUp; 
		animList[1] = movingRight; 
		animList[2] = movingLeft; 
		animList[3] = movingDown;
		animList[4] = new Animation(sleeping, duration2, false);
		for (Animation a : animList) {
			a.setAutoUpdate(true);
		}
		currentAnim = animList[4];
	}
	
	public void draw() throws SlickException {
		if (currentAnim == null)
			System.out.println("null lan bu");
		else if (obj != null)
			currentAnim.draw(obj.posX, obj.posY);
	}
	
	public void setSleepingAnimation(){
		currentAnim = animList[4];
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
