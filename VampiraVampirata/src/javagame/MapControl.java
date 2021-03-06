/**
 * 
 */
package javagame;
import java.util.ArrayList;
import java.util.Collections;

import org.newdawn.slick.SlickException;

import javagame.Common.Direction;

/**
 * @author Tugrulcan
 *
 */
public class MapControl {

	// PROPERTIES
	//Map map;
	TileMap map;
	String loc = "res/mapdata/";
	float NOISE_MULTIPLIER = 0.5f;
	float NOISE_MULTIPLIER_Y = 0.5f;
	//int[][] colliders; // Determines the positions where the character cannot walk
	
	// Direction
	
	
	// METHODS
	public boolean loadTileMap(int id) throws SlickException{
		map = new TileMap(loc+"map"+id+".tmx");
		return true;
	}
	
	public void renderTileMap(){
		map.render(0, 0);
	}
	
	
	public boolean canMove(float posX, float posY, Direction dir) {
		//posY = map.getHeight()*map.getTileHeight() - posY;
		//System.out.println(posX + "ve    " + posY);
		//int currentTile = map.getTileId((int)posX,(int) posY, 0);
		//System.out.println(currentTile);
		// Decode the currentTile id into x and y
		int i = (int)posX / map.getTileWidth();
		int j = (int)posY / map.getTileHeight();
//		System.out.println(i + "ve    " + j + "from mapcontrol");
		
		if (dir == Common.Direction.UP) {
			return map.isMovable(i,j-1);
		}
		else if (dir == Common.Direction.DOWN) {
			return map.isMovable(i,j+1);
		}
		else if (dir == Common.Direction.LEFT) {
			return map.isMovable(i-1,j);
		}
		else
			return map.isMovable(i+1,j);
	}
	
	public boolean canInteract(float posX, float posY) {
		// Change to tile first
		int i = (int)posX / map.getTileWidth();
		int j = (int)posY / map.getTileHeight();
//		System.out.println(i + "ve    " + j + "from mapcontrol");
		
		// Check the upper tile, j-1th tile
		return (map.doesInteractableExist(i, j-1)); 
	}
	
	public Interactable getInteractable(float posX, float posY) {
		// Change to tile first
		int i = (int)posX / map.getTileWidth();
		int j = (int)posY / map.getTileHeight();
		
		// Check the upper tile, j-1th tile
		return (map.getInteractable(i, j-1)); 
	}
	
	public void changeNoise(float posX, float posY, float scale, float amount) {
		// Change to tile first
		int i = (int)posX / map.getTileWidth();
		int j = (int)posY / map.getTileHeight();
		int neighbourTilesX = (int)scale / map.getTileWidth();
		int neighbourTilesY = (int)scale / map.getTileHeight();
		
		map.changeNoise(i, j, amount);
		for (int a = 1; a <= neighbourTilesX; a++) {
			map.changeNoise(i+a, j, amount*(float)Math.pow(NOISE_MULTIPLIER, a));
			map.changeNoise(i-a, j, amount*(float)Math.pow(NOISE_MULTIPLIER, a));
			
		}
		for (int b = 1; b <= neighbourTilesY; b++) {
			map.changeNoise(i, j+b, amount*(float)Math.pow(NOISE_MULTIPLIER_Y, b));
			map.changeNoise(i, j-b, amount*(float)Math.pow(NOISE_MULTIPLIER_Y, b));
		}
	}
	
	public void updateNoise(float delta) {
		for (int i = 0; i< map.getWidth(); i++) {
			for (int j = 0; j < map.getHeight(); j++) {
				map.changeNoise(i, j, -delta*0.1f);
			}
		}
	}
	
	//multiplier is the hearing efficiency according to tile
	public float getMaxNoise(float posX, float posY, float scale, float multiplier) {
		int i = (int)posX / map.getTileWidth();
		int j = (int)posY / map.getTileHeight();
		int neighbourTilesX = (int)scale / map.getTileWidth();
		int neighbourTilesY = (int)scale / map.getTileHeight();
		
		
		ArrayList<Float> noises = new ArrayList<Float>();
		
		noises.add(map.getNoise(i, j));
		for (int a = 1; a <= neighbourTilesX; a++) {
			noises.add(map.getNoise(i+a, j)*(float)Math.pow(multiplier, a));
			noises.add(map.getNoise(i-a, j)*(float)Math.pow(multiplier, a));
		}
		for (int b = 1; b <= neighbourTilesY; b++) {
			noises.add(map.getNoise(i, j+b)*(float)Math.pow(multiplier, b*b));
			noises.add(map.getNoise(i, j-b)*(float)Math.pow(multiplier, b*b));
		}
		return Collections.max(noises);
		
	}
	
	
	
	
	// Those are used to return how much tiles an object occupies given its dimensions
	// Those are trash, TiledMap already have a getWidth and getHeight that does the same.
	public int getWidthInTiles(int size){
		return Math.round((float)size/map.getWidth());
	}
	
	public int getHeigthInTiles(int size){
		return Math.round((float)size/map.getHeight());
	}

	public TileMap getMap() {
		// TODO Auto-generated method stub
		return this.map;
	}
	
}
