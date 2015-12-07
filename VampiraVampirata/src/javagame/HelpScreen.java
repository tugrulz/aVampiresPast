
package javagame;

import org.lwjgl.input.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 * @author Tuðrulcan
 * Help Screen
 * This screen only consist of a image that shows help and back button. Nothing else.
 */
public class HelpScreen extends BasicGameState{
	
	// VARIABLES
	Image helpScreenImage;
	// Button backButton;
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		//helpScreen = new Image("not determined");
	}
	
	// Draws stuff on screen
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// Draw backButton
	}
	
	// Updates images (for animations etc.)
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		/*
		 * If backButton.isCliked()
		 *     sbg.enterState(0); // Menuye geri dön.
		 */
	}
	
	public int getID() {
		return 3; // Help's id is set as 0 in Game
	}
}
