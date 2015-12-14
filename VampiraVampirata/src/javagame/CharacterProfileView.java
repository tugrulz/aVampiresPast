package javagame;

import java.util.Observable;
import java.util.Observer;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class CharacterProfileView implements Observer, OnScreen {

	// Properties
	Image current;
	Image face;
	//more to come
	
	Character obj;
	Graphics g;
	final int POS_Y = 50;
	final int POS_X = 620;
	float newPosY; // This will change to give decrase effect.
	boolean noGraphics;
	
	public CharacterProfileView() throws SlickException{
		face = new Image("res/vampire/vampireFace.jpg");
		System.out.println("bu niye çalýþmýyo");
		//face = new Image("res/vampire/vampireFace.jpg");
		//current = face;
	}
	
	public void setGraphics(Graphics g) {
			this.g = g;
			noGraphics = false;
	}
	
	public void draw() {
		if (g == null)
			System.out.println("graphics null þu anda");
		else
			g.drawImage(this.face, 45, 409, Color.lightGray);
	}
	
	public void setMoodImage() {
		// do..
		// sets image according to Character object's mood, current = character.get....
	}
	
	
	@Override
	public void update(Observable obs, Object arg) {
		// TODO Auto-generated method stub
		if (obs instanceof Character && g != null && this.face == null) {
			obj = (Character)obs;
//			draw(); Does not work
//			g.drawImage(this.face, 50, 250, Color.lightGray);
		}
//		else 
//			System.out.println("face kuçu");
	}

}
