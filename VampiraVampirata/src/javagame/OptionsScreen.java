
package javagame;

import org.lwjgl.input.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 * @author Tuðrulcan
 * Main Menu
 */
public class OptionsScreen extends BasicGameState{
	
	// Properties
	OptionsData data;
	OptionsController control;
	String fullscreen;
	int cursor = 0;
	
	public OptionsScreen(int state, OptionsData data) {
		this.data = data;
		control = new OptionsController(data);
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
	}
	
	// Draws stuff on screen
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// Brightness
		// Not working, no need to write
		
		// Cursor
		g.drawString(">",100,(100+cursor*50));
		
		// Volume
		g.drawString("Volume",150,100);
		g.drawString("" +data.getVolume(),420,100);
		
		// Fullscreen
		g.drawString("Fullscreen",150,150);
		g.drawString(fullscreen,420,150);
		
		// Brightness
		g.drawString("Brightness",150,200);
		g.drawString("" +data.getBrightness(),420,200);
		

		g.drawString("Use Directions to adjust",100,250);
		g.drawString("Press ENTER to continue",150,300);
		
	}
	
	// Updates images (for animations etc.)
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if (data.isFullscreen())
			fullscreen = "ON";
		else
			fullscreen = "OFF";
		
		listenInput(gc, sbg, delta);
	}
	
	public void listenInput(GameContainer gc, StateBasedGame sbg, int delta){
		Input input = gc.getInput();
		if (input.isKeyPressed(Input.KEY_DOWN)){
			cursor = Math.min(cursor+1, 2);
		}
		else if (input.isKeyPressed(Input.KEY_UP)){
			cursor = Math.max(cursor-1, 0);
		}
		if (cursor == 0 && input.isKeyDown(Input.KEY_RIGHT)){
			control.changeVolume(delta*0.5f);
		}
		else if (cursor == 0 && input.isKeyDown(Input.KEY_LEFT)){
			control.changeVolume(-delta*0.5f);
		}
		if (cursor == 1 && input.isKeyDown(Input.KEY_RIGHT)){
			control.goFullScreen(true);
		}
		else if (cursor == 1 && input.isKeyDown(Input.KEY_LEFT)){
			control.goFullScreen(false);
		}
		if (cursor == 2 && input.isKeyDown(Input.KEY_RIGHT)){
			control.changeBrightness(+5);
		}
		else if (cursor == 2 && input.isKeyDown(Input.KEY_LEFT)){
			control.changeBrightness(-5);
		}
		else if (input.isKeyDown(Input.KEY_ENTER)){
			sbg.enterState(((Game)sbg).prevState);
		}
	}
	
	public int getID() {
		return 2; // Menu's id is set as 0 in Game
	}
}
