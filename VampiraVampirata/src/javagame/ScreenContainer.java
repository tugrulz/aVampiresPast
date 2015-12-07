package javagame;

/*
 * This class changes its current screen with respect to gamestate
 * But it also enables change of screen without changing the game state
 */

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import org.newdawn.slick.state.BasicGameState;

public class ScreenContainer implements Observer{
	// Properties
	ArrayList<BasicGameState> screens;
	BasicGameState current;
	Game game;
	
	public ScreenContainer(Game game){
		screens = new ArrayList<BasicGameState>();
		this.game = game;
		current = (BasicGameState) game.getCurrentState();
	}
	
	public void addScreen (BasicGameState screen) {
		screens.add(screen);
	}
	
	public void setScreen (BasicGameState screen) {
		screens.add(screen);
	}

	public BasicGameState getCurrent() {
		return current;
	}

	@Override
	public void update(Observable obs, Object arg1)  {
		// TODO Auto-generated method stub
		//this.game = (Game)obs;
		this.setScreen((BasicGameState)game.getCurrentState());
		// Another class should implement ScreenContainer.getCurrent().render,update etc.
		// Or render them here
	}
	
}
