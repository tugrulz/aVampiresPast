package javagame;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/*
 * This interface is designed to use polymorphism on view objects who paints on the screen (graphics g)
 * They all implement setGraphics(Graphics g) function
 */

public interface OnScreen {
	
	public void setGraphics(Graphics g);
	
	public void draw() throws SlickException;
	
}
