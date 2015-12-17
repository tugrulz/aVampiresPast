package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class PauseMenu extends BasicGameState {
	// Properties
	// VARIABLES
	int posX = 90 , posY = 70;
	
	public String exit = "Exit?";
	
	// Sonradan eklenecek
	public String options = "Options";
	public String help = "Help";
	
	public String cont = "Continue";
	
		public PauseMenu(int state) {
			
		}
		
		public PauseMenu() {
			
		}
		
		public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
			
		}
		
		// Draws stuff on screen
		public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
			
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
			
		}
		
		// Updates images (for animations etc.)
		public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
			// INPUT CONTROL
			Input input = gc.getInput();		
			int xpos = Mouse.getX();
			int ypos = Mouse.getY();
			
			if (input.isKeyDown(Input.KEY_UP)) {
				posY -= 1;
			}
			
			if ((xpos>280 && xpos<340)&&(ypos> 140 && ypos < 190)){
				exit = "Exit!";
				if (input.isMouseButtonDown(0)){
					this.exit(gc);
				}
			}
			else
				exit = "Exit?";
			
			if ((xpos>280 && xpos<400)&&(ypos> 310 && ypos < 340)){
				cont = "Continue!";
				if (input.isMouseButtonDown(0)){
					resume(gc);
				}
			}
			else
				cont = "Continue?";
			
			if ((xpos>280 && xpos<380)&&(ypos> 260 && ypos < 300)){
				options = "Options!";
				if (input.isMouseButtonDown(0)){
					((Game)sbg).prevState = 5;
					options(gc);
//					Common.msc.playOptionsMusic();
				}
			}
			else
				options = "Options?";
			
			if ((xpos>280 && xpos<350)&&(ypos> 210 && ypos < 240)){
				help = "Help!";
				((Game)sbg).prevState = 0;
				if (input.isMouseButtonDown(0)){
					((Game)sbg).prevState = 5;
					help(gc);
				}
			}
			else
				help = "Help?";
		}
		
		public int getID() {
			return 5; // Menu's id is set as 0 in Game
		}
		
		public void resume(GameContainer gc) {
			((GameController)gc).changeState(1);
			((GameController)gc).resume();
		}
		
		public void options(GameContainer gc) {
			((GameController)gc).changeState(2);
		}
		
		public void help(GameContainer gc) {
			((GameController)gc).changeState(3);
		}
		
		public void exit(GameContainer gc) {
			gc.exit();
		}
		
}
