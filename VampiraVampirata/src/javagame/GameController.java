package javagame;

import java.util.Observable;
import java.util.Observer;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class GameController extends AppGameContainer implements Observer {

	public GameController( Game game) throws SlickException{
			super(game);
	}
	
	// This function won't be used because we cannot change the library
	// And library takes game as input instead of game controller
	public void changeState(String state) {
		Game conv = (Game) game; // To fix the clash between game interface and game class
		if (state.equals("menu"))
			conv.enterState(0);
		if (state.equals("play"))
			conv.enterState(1);
		if (state.equals("options"))
			conv.enterState(2);
		if (state.equals("help"))
			conv.enterState(3);
		if (state.equals("introduction"))
			conv.enterState(4);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof OptionsData) {
			try {
				this.setDisplayMode(((Game)game).getWidth(),((Game)game).getHeight(), ((OptionsData)o).isFullscreen());
			} catch (SlickException e) {
				System.out.println("Could not set fullscreen");
			}
		}
	}

}
