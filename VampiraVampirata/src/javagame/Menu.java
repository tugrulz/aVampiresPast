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
	int posX = 90 , posY = 70;
	
	public String mouse = "Play?";
	public String exit = "Exit?";
	
	// Sonradan eklenecek
	public String options = "Options";
	public String help = "Help";
	
	public String cont = "Continue";
	
	public Menu(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
	}
	
	// Draws stuff on screen
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// Play button
		g.drawString(mouse,305,100);
		g.drawRect(300, 100, 55, 20);
		g.drawString("y : " + Mouse.getY() + "x : " + Mouse.getX(), 0, 0);
		
		// Exit Button
		g.drawString(exit,305,300);
		g.drawRect(300, 300, 55, 20);
		
		// Continue Button
		g.drawString(cont,305,150);
		g.drawRect(300, 150, 90, 20);
		
		// Options Button
		g.drawString(options,305,200);
		g.drawRect(300, 200, 80, 20);
		
		// Help Button
		g.drawString(help,305,250);
		g.drawRect(300, 250, 55, 20);
		
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
				sbg.enterState(4);
				Common.msc.playMainGameMusic();
			}
		}
		else
			mouse = "Play?";
		if (input.isKeyDown(Input.KEY_UP)) {
			posY -= 1;
		}
		
		if ((xpos>280 && xpos<340)&&(ypos> 140 && ypos < 190)){
			exit = "Exit!";
			if (input.isMouseButtonDown(0)){
				System.exit(0);
			}
		}
		else
			exit = "Exit?";
		
		if ((xpos>280 && xpos<400)&&(ypos> 310 && ypos < 340)){
			cont = "Continue!";
			if (input.isMouseButtonDown(0)){
				sbg.enterState(4);
				Common.msc.playMainGameMusic();
			}
		}
		else
			cont = "Continue?";
		
		if ((xpos>280 && xpos<380)&&(ypos> 260 && ypos < 300)){
			options = "Options!";
			if (input.isMouseButtonDown(0)){
				((Game)sbg).prevState = 0;
				sbg.enterState(2);
//				Common.msc.playOptionsMusic();
			}
		}
		else
			options = "Options?";
		
		if ((xpos>280 && xpos<350)&&(ypos> 210 && ypos < 240)){
			help = "Help!";
			((Game)sbg).prevState = 0;
			if (input.isMouseButtonDown(0)){
				((Game)sbg).prevState = 0;
				sbg.enterState(3);
//				Common.msc.playOptionsMusic();
			}
		}
		else
			help = "Help?";
		
		
	}
	
	public int getID() {
		return 0; // Menu's id is set as 0 in Game
	}
}
