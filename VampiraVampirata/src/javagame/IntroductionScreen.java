package javagame;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/*
 * This screen only consist of a image that shows comics and continue button. Nothing else.
 */

public class IntroductionScreen {
	// VARIABLES
	Image IntroductionImage;
	ArrayList<Image> intros;
	// Button continueButton;

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		//IntroductýonScreen = new Image("not determined");
	}
	
	// Draws stuff on screen
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// Draw continueButton
	}
	
	// Updates images (for animations etc.)
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		/*
		 * If continueButton.isCliked()
		 *     sbg.enterState(0); // Menuye geri dön.
		 */
		setIntroductionImage(((Game)sbg).getLevel());
	}
	
	public Image getIntroductionImage() {
		return IntroductionImage;
	}

	public void setIntroductionImage(Image introductionImage) {
		IntroductionImage = introductionImage;
	}
	
	public void setIntroductionImage(int level) {
		IntroductionImage = intros.get(level);
	}
	
	public int getID() {
		return 4; // Help's id is set as 0 in Game
	}
}
