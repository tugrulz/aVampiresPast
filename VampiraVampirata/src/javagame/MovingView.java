package javagame;

import java.util.Observable;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MovingView implements java.util.Observer {

	
	// Properties
	Animation currentAnim, movingLeft, movingRight, movingUp, movingDown;
//	Animation[] animList = {movingUp, movingRight, movingLeft, movingDown};
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
			//System.out.println("Notifylandým");
			obj = (Moving) obs;
			currentAnim = animList[obj.getMovingDirection().ordinal()];
			//draw();
			
		}
		
	}
	
	// TRASH
	/*public void draw() throws SlickException{
	/*String V_ACT = "res/vampire/vampir_";
	String p = ".png";
	Image[] walkUp = {new Image(V_ACT+"up0"+p), new Image(V_ACT+"up1"+p), new Image(V_ACT+"up2"+p), new Image(V_ACT+"up3"+p)};
	Image[] walkDown = {new Image(V_ACT+"down1"+p), new Image(V_ACT+"down2"+p), new Image(V_ACT+"down3"+p), new Image(V_ACT+"down0"+p)};
	Image[] walkLeft = {new Image(V_ACT+"left0"+p), new Image(V_ACT+"left1"+p), new Image(V_ACT+"left2"+p), new Image(V_ACT+"left3"+p)};
	Image[] walkRight = {new Image(V_ACT+"right0"+p), new Image(V_ACT+"right1"+p), new Image(V_ACT+"right2"+p), new Image(V_ACT+"right3"+p)};
	int duration = 200;*/
//	currentAnim.draw(obj.posX, obj.posY);
//}
}
