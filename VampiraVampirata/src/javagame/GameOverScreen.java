package javagame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOverScreen extends BasicGameState {
	int state;
	String status;
	public GameOverScreen (int state) {
		this.state = state;
		this.status = "";
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	}
	
	// Draws stuff on screen
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// Draw backButton
		g.drawString("GAME OVER.", 150, 100);
		g.drawString(status, 150, 150);
		g.drawString("Press Enter to exit...", 150, 250);
		gc.setMinimumLogicUpdateInterval(1); 
	}
	
	// Updates images (for animations etc.)
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		listenInput(gc);
	}
	
	public int getID() {
		return 6; // Help's id is set as 0 in Game
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void listenInput(GameContainer gc){
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_ENTER)) {
			gc.exit();
//			System.exit(9);
		}
	}
	
}

