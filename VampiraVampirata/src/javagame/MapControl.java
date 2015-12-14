/**
 * 
 */
package javagame;
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
		System.out.println(i + "ve    " + j + "from mapcontrol");
		
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
	
	
	/*public boolean loadMap(int id){
		map = new Map();
		colliders = decoder.decode(loc+"map"+id+".txt");
		System.out.println("DIM " + map.h+" "+map.w);
		
		for(int i = 0; i < map.h; i++) {
			for (int j = 0; j < map.w; j++) {
				System.out.print(colliders[i][j] + " ");
			}
			System.out.println();
		}
		
		return true;
		//colliders = new boolean[map.MAP_HEIGHT][map.MAP_WIDTH];
		//for(int i = 0; i < map.MAP_HEIGHT; i++) {
//			for (int j = 0; j < map.MAP_WIDTH; j++) {
//				
//			}
//		}//
	}
	
	public int findGridID(float posX, float posY) {
		int rowNo = (int)posX / map.GRID_DIM;
		int colNo = (int)posY / map.GRID_DIM;
		return map.w*colNo + rowNo;
	}
	
	public boolean canMove(int direction, float posX, float posY ) {
		// Chesstable
		int posGrid = findGridID(posX, posY);
		int posGridX = posGrid % map.w;
		int posGridY = posGrid / map.w;
		if (colliders[posGridX + direction/10][posGridY + direction % 10] == 1){
			return true;
		}
		else
			return false;
	}*/
	
}
