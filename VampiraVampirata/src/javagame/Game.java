package javagame;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


//MASTER CLASS
//Bu classýn viewý yok, sadece model. Ama view classlarý gibi observe yapýyor çünkü kendi datasýný optionsdataya göre deðiþtirmesi gerek


public class Game extends StateBasedGame implements Observer{
	
	// Properties
	public static final String gamename = "A Vampire's Past...";
	public static final int menu = 0;
	public static final int play = 1;
	public static final int options = 2;
	public static final int help = 3;
	public static final int introduction = 4;
	public static final int pause = 5;
	
	boolean fullscreen;
	int width;
	int height;
	
	OptionsData optionsData;
	Music msc;
	
	int level;
	
	public Game(String gamename) {
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		fullscreen = false;
		width = 640;
		height = 480;
		level = 0;
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{
		// INITIALIZE STATES
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		// FIRST STATE (SCREEN) WE WILL SEE
		this.enterState(menu);
		
		//MusicManager msc = new MusicManager();
		Common.msc.playTitleMusic();
		
	}
	
	public void enterState(int id){
		super.enterState(id);
	}
	
	/**********************************************MAIN FUNCTION**********************************************/
	public static void main(String[] args) {
		AppGameContainer appgc;
		Game game;
		try {
			// Put the game in appgame container
			game = new Game(gamename);
			appgc = new AppGameContainer(game);
//			appgc = new GameController(game);
			
			// Set the size of the window
			appgc.setDisplayMode(game.getWidth(), game.getHeight(), game.isFullscreen());
			
			//Start
			appgc.start();
			

			
		}catch(SlickException e){
			e.printStackTrace();
		}
		

	}
	
	// GET SET TRASH
	public boolean isFullscreen() {
		return fullscreen;
	}

	public void setFullscreen(boolean fullscreen) {
		this.fullscreen = fullscreen;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public void update(Observable obs, Object arg1) {
		// TODO Auto-generated method stub
		optionsData = (OptionsData)obs;
		fullscreen = optionsData.isFullscreen();
		//appgc.setDisplayMode(game.getWidth(), game.getHeight(), game.isFullscreen())
	}

}
