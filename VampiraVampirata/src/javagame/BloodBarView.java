package javagame;

import java.util.Observable;
import java.util.Observer;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class BloodBarView implements Observer, OnScreen{

	// Properties
	Graphics g;
	final int POS_Y = 50;
	final int POS_X = 620;
	float newPosY; // This will change to give decrease effect.
	boolean noGraphics;
	
	Character obj;
	
	public BloodBarView(){
		newPosY = POS_Y;
		noGraphics = true;
	}
	
	public void setGraphics(Graphics g) {
			this.g = g;
	}
	
	public void draw() throws SlickException {
		if (g != null) {
			g.drawRect(POS_X, 50, 10, obj.BLOOD_MAX);
			g.setColor(Color.red);
			g.fillRect(POS_X, newPosY, 10, obj.getBlood());
			g.setColor(Color.white);
		}
	}
	
	@Override
	public void update(Observable obs, Object arg1) {
		// TODO Auto-generated method stub
		if (obs instanceof Character) {
			obj = (Character)obs;
			newPosY = POS_Y + obj.BLOOD_MAX - obj.getBlood();
			/*try {
					draw();
			} catch (SlickException e) {
				System.out.println("could not draw");
			}*/
		}

	}

}
