/**
 * 
 */
package javagame;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import javagame.Common.Direction;

// NOTE: THIS CLASS' NAME WILL CHANGE TO GAME CONTROLLER
// IT INITIALIZES EVERY ELEMENT IN THE IN-GAME (where player plays the game, move, take items etc.)
// IT LISTENS FOR INPUT

/**
 * @author Tuðrulcan
 * Main Game Screen
 */
public class Play extends BasicGameState{
	
	String V_ACT = "res/vampire/vampir_";
	String p = ".png";
	boolean quit = false;
	
	float vampirePositionX = 360;
	float vampirePositionY = 360;
	
	// Map Control
	MapControl map;
	MapView mapView;
	boolean loaded;
	
	//
	Character vampire;
	CharacterController vampireControl;
	CharacterView vampireView;
	BloodBarView vampireBlood;
	CharacterProfileView vampireFace;
	InventoryView vampireInventory;
	ArrayList<OnScreen> views;
	
	float bar=400;
	final float BAR_MAX = 400;
	float posYBar = 50;
	
	
	public Play(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		views = new ArrayList<OnScreen>();
		
		//
		map = new MapControl();
		loaded = map.loadTileMap(1);
		mapView = new MapView(map.getMap());
		
		// SETTLE
		System.out.println("Naberlan");
		vampire = new Character();
		vampireControl = new CharacterController(vampire, map);
		vampireView = new CharacterView();
		vampireBlood = new BloodBarView();
		vampireFace = new CharacterProfileView();
		vampireInventory = new InventoryView();
		views.add(vampireInventory);
		views.add(vampireBlood);
		views.add(vampireFace);
		vampire.addObserver(vampireView);
		vampire.addObserver(vampireBlood);
		vampire.addObserver(vampireFace);
		vampire.addObserver(vampireInventory);
		vampire.notifyObservers();
		vampire.setPosition(vampirePositionX,vampirePositionY);
		
		//
		//MusicManager msc = new MusicManager();
		
	}
	
	// Draws stuff on screen
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		mapView.render();
		vampireView.draw();
		for(OnScreen view: views){
			view.setGraphics(g);
//			view.draw(); // They draw themselves in the update method
		}
		
	}
	
	// Updates images (for animations etc.)
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
//		if (vampire.hasObjectiveItem)
			//loadnextmap 
		if(vampire.isCatched()) {
			gameOver(gc);
		}
		
		listenInput(gc, sbg, delta);

		vampireControl.decreaseBlood(0.01f);
		vampire.decreaseBlood(0.01f);

	}
	
	// Any user input first goes to listeners in the Input classes (kinda acts like Input manager), 
	// then according to input, GameController makes manipulations in various classes.
	public void listenInput(GameContainer gc, StateBasedGame sbg, int delta) {
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_LEFT)){
			//System.out.println("YUKARÝ");
			vampireControl.move(Direction.LEFT, delta);
//			vampire.changePosition(-1*delta, true);
		}
		else if (input.isKeyDown(Input.KEY_RIGHT)){
			vampireControl.move(Direction.RIGHT, delta);
		}
		else if (input.isKeyDown(Input.KEY_DOWN)){
			vampireControl.move(Direction.DOWN, delta);
		}
		else if (input.isKeyDown(Input.KEY_UP)){
			vampireControl.move(Direction.UP, delta);
		}
		else if (input.isKeyDown(Input.KEY_ENTER)){
//			System.out.println("X: " + Mouse.getX() + "Y: " + Mouse.getY());
			vampireControl.interact();
		}
		else if (input.isKeyDown(Input.KEY_ESCAPE)){
			pause(gc, sbg);
		}
//		else
//			System.out.println("duruyorum");
	}
	
	void pause(GameContainer gc, StateBasedGame game) {
		gc.pause();
		game.enterState(5);
	}
	
	public int getID() {
		return 1; // Menu's id is set as 0 in Game
	}
	
	void resume(GameContainer gc, StateBasedGame game) {
		gc.resume();
		game.enterState(1);
	}
	
	void gameOver(GameContainer gc) {
		gc.exit();
	}
}

/* Comment trash
/*for (int i = 0; i < 18; i++) {
for (int j = 0; j < 26; j++) {
	g.drawRect(24*j, 24*i, 24, 24);
	g.drawString(""+((i*26 + j)%100), 24*j, 24*i);
}
}*/
/*g.drawRect(620, 50, 10, BAR_MAX);
g.setColor(Color.red);
g.fillRect(620, posYBar, 10, bar);
g.setColor(Color.white);*/

/*for (int i = 0; i < map.map.getWidth(); i++) {
for (int j = 0; j < map.map.getHeight(); j++) {
	g.drawRect(24*i, 24*j, 24, 24);
	int myInt = (map.map.collidableTiles[i][j]) ? 1 : 0;
	g.drawString(""+(myInt), 24*i, 24*j);
}
}*/