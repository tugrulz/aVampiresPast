/**
 * 
 */
package javagame;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
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
	float vampirePositionY = 350;
	float scale = 120;
	float amount = 32; // of noise

	float sleepingPositionX = 360;
	float sleepingPositionY = 350;
	
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
	SleepingMan sleeping;
	SleepingManView sleepingView;
	SleepingManController sleepingControl;
	ArrayList<OnScreen> views;
	String status = "";
	
	float bar=400;
	final float BAR_MAX = 400;
	float posYBar = 50;
	
	String talk = "";
	boolean initial = false;
	
	boolean stop = false;
	
	public Play(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		views = new ArrayList<OnScreen>();
		
		//
		map = new MapControl();
		loaded = map.loadTileMap(1);
		mapView = new MapView(map.getMap());
		
		// SETTLE
		vampire = new Character();
		vampireControl = new CharacterController(vampire, map);
		vampireView = new CharacterView();
		vampireBlood = new BloodBarView();
		vampireFace = new CharacterProfileView();
		vampireInventory = new InventoryView();
		sleeping = new SleepingMan();
		sleepingControl = new SleepingManController(sleeping, map);
		sleepingView = new SleepingManView();
		sleeping.addObserver(sleepingView);
		views.add(vampireInventory);
		views.add(vampireBlood);
		views.add(vampireFace);
		vampire.addObserver(vampireView);
		vampire.addObserver(vampireBlood);
		vampire.addObserver(vampireFace);
		vampire.addObserver(vampireInventory);
		vampire.notifyObservers();
		vampire.setPosition(vampirePositionX,vampirePositionY);
//		sleeping.setPosition(488, 100);
		sleeping.setPosition(496, 110);
		
		
		//
		//MusicManager msc = new MusicManager();
		
	}
	
	// Draws stuff on screen
	// Unexpected problem: the objects only draws themselves in these function	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		mapView.render();
		vampireView.draw();
		sleepingView.draw();
		for(OnScreen view: views){
				view.setGraphics(g);
				view.draw();
		}
		g.drawString(vampire.talk, 180, 5);
//		}
//		vampireBlood.draw(g);
//		g.drawRect(vampirePositionX, vampirePositionY, 100, 100);
	}
	
	// Updates images (for animations etc.)
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

//		if (vampire.hasObjectiveItem)
			//loadnextmap 
		if(vampire.isCatched()) {
			gameOver(gc, (Game)sbg);
		}
		
		listenInput(gc, sbg, delta);

		vampireControl.decreaseBlood(0.007f);
//		vampire.decreaseBlood(0.01f);
		sleepingControl.wakeUp();
		if (!sleeping.isSleeping()){
			if (sleeping.posFeetX > 72 && sleeping.checked==false) {
				sleepingControl.move(Direction.LEFT, delta*0.5f);
			}
			else {
				if (sleeping.checked == false) {
					sleepingControl.tour();
				}
				sleepingControl.move(Direction.RIGHT, delta*0.5f);
				if(sleeping.posFeetX > 510) {
					sleepingControl.sleep();
				}
			}
		}
		
		sleepingControl.checkPlayer(vampire);
		map.updateNoise(90.0f);
	
		
		if (delta > 30) {
			if (!initial)
				initial = true;
			else {
				if (!vampire.talk.equals(""))
					vampire.talk = "";
				else if (delta > 30)
					vampire.setRandomTalk();
			}
		}
		
		
		
		if (vampire.isCatched()) {
			status = "You've been caught.";
			gameOver(gc, (Game)sbg);
			
		}
		
		if(vampireControl.doesHaveObjective()){
			status = "You won it!";
			gameOver(gc, (Game)sbg);
			
		}
		
		if (vampire.getBlood()<=0) {
			status = "You're out of blood!.";
			gameOver(gc, (Game)sbg);
			
		}
	

	}
	
	// Any user input first goes to listeners in the Input classes (kinda acts like Input manager), 
	// then according to input, GameController makes manipulations in various classes.
	public void listenInput(GameContainer gc, StateBasedGame sbg, int delta) {
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_LEFT)){
			vampireControl.move(Direction.LEFT, delta);
			map.changeNoise(vampire.getPosFeetX(), vampire.getPosFeetY(), scale, amount*delta);
		}
		else if (input.isKeyDown(Input.KEY_RIGHT)){
			vampireControl.move(Direction.RIGHT, delta);
			map.changeNoise(vampire.getPosFeetX(), vampire.getPosFeetY(), scale, amount*delta);
		}
		else if (input.isKeyDown(Input.KEY_DOWN)){
			vampireControl.move(Direction.DOWN, delta);
		}
		else if (input.isKeyDown(Input.KEY_UP)){
			vampireControl.move(Direction.UP, delta);
		}
		else if (input.isKeyDown(Input.KEY_ENTER)){
			vampireControl.interact();
		}
		else if (input.isKeyDown(Input.KEY_ESCAPE)){
			pause(gc, sbg);
		}
		else if (input.isKeyDown(Input.KEY_1)) {
			vampireControl.useItem(0);
		}
		else if (input.isKeyDown(Input.KEY_2)) {
			vampireControl.useItem(1);
		}
		else if (input.isKeyDown(Input.KEY_3)) {
			vampireControl.useItem(2);
		}
		else if (input.isKeyDown(Input.KEY_4)) {
			vampireControl.useItem(3);
		}
		else if (input.isKeyDown(Input.KEY_5)) {
			vampireControl.useItem(4);
		}
		else if (input.isKeyDown(Input.KEY_6)) {
			vampireControl.useItem(5);
		}
		else
			vampireControl.idle();
	}
	
	void pause(GameContainer gc, StateBasedGame game) {
		gc.pause();
//		game.enterState(5);
		((GameController)gc).changeState("pause");
	}
	
	public int getID() {
		return 1; // Menu's id is set as 0 in Game
	}
	
	void resume(GameContainer gc, StateBasedGame game) {
		gc.resume();
//		game.enterState(1);
		((GameController)gc).changeState("play");
	}
	
	void gameOver(GameContainer gc, Game sbg) {
		save(sbg);
		gc.setMinimumLogicUpdateInterval(1000); 
		sbg.setGameOverMessage(status);
//		sbg.enterState(sbg.gameover);	
		((GameController)gc).changeState("gameover");
	}
	
	void save(Game sbg){
        String text = "" + sbg.level;
        BufferedWriter output = null;
        try {
            File file = new File("saved.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(text);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) try {
            	output.close();
            } catch ( IOException e ) {
                e.printStackTrace();
            } 
        }

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