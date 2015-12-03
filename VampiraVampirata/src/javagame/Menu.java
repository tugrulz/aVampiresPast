/**
 * 
 */
package javagame;

import org.lwjgl.input.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 * @author Tuðrulcan
 * Main Menu
 */
public class Menu extends BasicGameState{
	
	// VARIABLES
	int posX = 100 , posY = 100;
	
	public String mouse = "Play?";
	public String exit = "Exit?";
	
	// Sonradan eklenecek
	public String options = "Options";
	public String help = "Help";
	
	public Menu(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
	}
	
	// Draws stuff on screen
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString(mouse,305,100);
		g.drawRect(300, 100, 55, 20);
		g.drawString("y : " + Mouse.getY() + "x : " + Mouse.getX(), 0, 0);
		
		// Exit Button
		g.drawString(exit,305,150);
		g.drawRect(300, 150, 55, 20);
		
		// Put JohnDoe on the screen
		Image vampir = new Image("res/vampir.png");
		g.drawImage(vampir, posX, posY);
		
	}
	
	// Updates images (for animations etc.)
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// INPUT CONTROL
		Input input = gc.getInput();		
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		if ((xpos>280 && xpos<340)&&(ypos> 350 && ypos < 380)){
			mouse = "Play!";
			if (input.isMouseButtonDown(0)){
				sbg.enterState(1);
				Common.msc.playMainGameMusic();
			}
		}
		else
			mouse = "Play?";
		if (input.isKeyDown(Input.KEY_UP)) {
			posY -= 1;
		}
		
		if ((xpos>280 && xpos<340)&&(ypos> 300 && ypos < 340)){
			exit = "Exit!";
			if (input.isMouseButtonDown(0)){
				System.exit(0);
			}
		}
		else
			exit = "Exit?";
		
	}
	
	public int getID() {
		return 0; // Menu's id is set as 0 in Game
	}
}
