
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
		g.drawString("Press ENTER to interact (Not now!).", 20, 100);
		g.drawString("Press Direction keys to move.", 20, 150);
		g.drawString("Avoid moving frequently near the sleeping man and avoid him.", 20, 200);
		g.drawString("Press ENTER to continue.", 20, 250);
	}
	
	// Updates images (for animations etc.)
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		/*
		 * If backButton.isCliked()
		 *     sbg.enterState(0); // Menuye geri dön.
		 */
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_ENTER)) {
			sbg.enterState(((Game)sbg).prevState);
		}
	}
	
	public int getID() {
		return 3; // Help's id is set as 0 in Game
	}
}
