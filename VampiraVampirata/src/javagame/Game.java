package javagame;

import java.util.Observable;
import java.util.Observer;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


//MASTER CLASS
// Possible problem: It cannot extend SBG and Observable at once
public class Game extends StateBasedGame implements Observer{
	
	// Properties
	public static final String gamename = "A Vampire's Past...";
	public static final int menu = 0;
	public static final int play = 1;
	public static final int options = 2;
	public static final int help = 3;
	public static final int introduction = 4;
	public static final int pause = 5;
	public static final int gameover = 6;
	
	public static final int STATE_COUNT = 7;
	
	boolean fullscreen;
	int width;
	int height;
	
	
	OptionsData optionsData;
	GameController control;
	Music msc;
	
	int level;
	int prevState;
	String gameOverMessage = "";
	
	public Game(String gamename) {
		super(gamename);
		optionsData = new OptionsData();
		optionsData.addObserver(this);
		optionsData.addObserver(Common.msc);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new OptionsScreen(options, optionsData));
		this.addState(new IntroductionScreen());
		this.addState(new HelpScreen());
		this.addState(new PauseMenu());
		this.addState(new GameOverScreen(gameover));
		fullscreen = false;
		width = 640;
		height = 480;
		level = 0;
		prevState = 0;
		
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{
		// INITIALIZE STATES
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(introduction).init(gc, this);
		this.getState(gameover).init(gc, this);
		// FIRST STATE (SCREEN) WE WILL SEE
		this.enterState(menu);
		
		//MusicManager msc = new MusicManager();
		Common.msc.playTitleMusic();
		
	}
	
	public void enterState(int id){
		super.enterState(id);
	}
	
	public void setGameController(GameController appgc) {
		this.control = appgc;
		optionsData.addObserver(control);
	}
	
	/**********************************************MAIN FUNCTION**********************************************/
	public static void main(String[] args) {
		AppGameContainer appgc;
		Game game;
		try {
			// Put the game in appgame container
			game = new Game(gamename);
//			appgc = new AppGameContainer(game);
			appgc = new GameController(game);
			game.setGameController((GameController)appgc);
			
			// Set the size of the window
			appgc.setDisplayMode(game.getWidth(), game.getHeight(), game.isFullscreen());
			
			//Start
			appgc.start();
			

			
		}catch(SlickException e){
			e.printStackTrace();
			System.out.println("Not opening");
		}
		

	}
	
	/*
	public final void render(GameContainer container, Graphics g) throws SlickException {
		preRenderState(container, g);
		
		if (leaveTransition != null) {
			leaveTransition.preRender(this, container, g);
		} else if (enterTransition != null) {
			enterTransition.preRender(this, container, g);
		}
		
		currentState.render(container, this, g);
		
		if (leaveTransition != null) {
			leaveTransition.postRender(this, container, g);
		} else if (enterTransition != null) {
			enterTransition.postRender(this, container, g);
		}
		
		postRenderState(container, g);
	}*/
	
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
	
	

	public String getGameOverMessage() {
		return gameOverMessage;
	}

	public void setGameOverMessage(String gameOverMessage) {
		this.gameOverMessage = gameOverMessage;
		GameOverScreen pointer = (GameOverScreen)this.getState(gameover);
		pointer.setStatus(gameOverMessage);
	}

	@Override
	public void update(Observable obs, Object arg1) {
		// TODO Auto-generated method stub
		optionsData = (OptionsData)obs;
		fullscreen = optionsData.isFullscreen();
		//appgc.setDisplayMode(game.getWidth(), game.getHeight(), game.isFullscreen())
	}

}
