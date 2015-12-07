package javagame;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

/*
 * Note: TileMap does not have a view because it's data equals to its views. Maps are created by creating its view.
 */

/*
 * Note: Collidable means the character can walk on the given tile because there is nothing blocking his movement 
 * (such as a wall, a refrigerator, a rnold schwarzenegger etc.)
 * AN IMPORTANT NOTICE: The 2D array representing the map is created so that x coordinate will map to its row 
 * and y coordinate to its column. So array is created as [x][y] or [width][height], in different than so rowNumbers 
 * are mapped to columns actually. example
 * 		x1 x2 x3 x4
 * 	y1  0  1  0  1
 *  y2  1  0  1  0 
 *  y3  0  0  0  0 
 *  y4  0  0  0  0
 * 
 */

public class TileMap extends TiledMap {
	
	// Properties
	public boolean collidableTiles[][];
	public Interactable interactableTiles[][]; // This may changed to STRING or int later
	public Item itemTiles[][]; // This may changed to STRING or InteractableType later
	final int LAYER_ID_COL = 0; // all collision information are stored in the layer 1 for all maps
	
	ItemFactory items;
	InteractableFactory interactables;
	
	// Loads a map (.tmx file) from file location "ref"
	public TileMap(String ref) throws SlickException {
		super(ref);
		collidableTiles = new boolean[this.getWidth()][this.getHeight()];
		interactableTiles = new Interactable[this.getWidth()][this.getHeight()];
		items = new ItemFactory(this);
		interactables = new InteractableFactory(this);
		//System.out.println(this.getHeight() + " " + this.getWidth());
		loadColliders();
		loadInteractables();
		
	}
	

	public boolean doesInteractableExist(int i, int j) {
		return (interactableTiles[i][j] != null);
	}
	

	public void loadInteractables(){
		for (int i = 0; i < collidableTiles.length; i++) {
			for (int j = 0; j < collidableTiles[i].length; j++) {
				interactableTiles[i][j] = interactables.createInteractableAt(i,j);
//				/interactableTiles[i][j] = new Interactable();
			}
		}
	}
	

	public Interactable getInteractable(int i, int j) {
		System.out.println("interactabl'ý yakala");
		return (interactableTiles[i][j]);
	}
	
	// Interactable create
	

	public void loadItems(){
		for (int i = 0; i < collidableTiles.length; i++) {
			for (int j = 0; j < collidableTiles[i].length; j++) {
				itemTiles[i][j] = items.createItemAt(i,j);
			}
		}
	}
	
	
	// 1. Main collider loading function
	public void loadColliders(){
		for (int i = 0; i < collidableTiles.length; i++) {
			for (int j = 0; j < collidableTiles[i].length; j++) {
				collidableTiles[i][j] = detectCollidable(i,j);
			}
		}
	}
	
	// 2. Helper to load
	// Detects and returns collidability for a single time
	public boolean detectCollidable(int i, int j) { 
		int tileID = this.getTileId(i, j, LAYER_ID_COL); // j is row number and also x coordinate
		//System.out.println(tileID);
		String value = getTileProperty(tileID, "collidable", "false"); //"false" is the default value
		return (value.equals("true"));
	}
	
	// Returns if the given tile is movable 
	public boolean isMovable(int i, int j) {
		return collidableTiles[i][j];
	}
	
	/***************** TRASHHHHHHHHHHHHHHHHHH*************/
	
	/**
	 * Get the width of the tile map. The slightly odd name is used
	 * to distiguish this method from commonly used names in game maps.
	 * 
	 * @return The number of tiles across the map
	 */
//	public int getWidthInTiles() {
//		return this.getWidth()/this.getTileWidth();
//	}

	/**
	 * Get the height of the tile map. The slightly odd name is used
	 * to distiguish this method from commonly used names in game maps.
	 * 
	 * @return The number of tiles down the map
	 */
//	public int getHeightInTiles(){
//		return this.getHeight()/this.getTileHeight();
//	}
	
	/**
	 * Notification that the path finder visited a given tile. This is 
	 * used for debugging new heuristics.
	 * 
	 * @param x The x coordinate of the tile that was visited
	 * @param y The y coordinate of the tile that was visited
	 */
//	public void pathFinderVisited(int x, int y){}
	
	/**
	 * Check if the given location is blocked, i.e. blocks movement of 
	 * the supplied mover.
	 * 
	 * @param context The context describing the pathfinding at the time of this request
	 * @param tx The x coordinate of the tile we're moving to
	 * @param ty The y coordinate of the tile we're moving to
	 * @return True if the location is blocked
	 */
//	public boolean blocked(PathFindingContext context, int tx, int ty){return false;}
	
	/**
	 * Get the cost of moving through the given tile. This can be used to 
	 * make certain areas more desirable. A simple and valid implementation
	 * of this method would be to return 1 in all cases.
	 * 
	 * @param context The context describing the pathfinding at the time of this request
	 * @param tx The x coordinate of the tile we're moving to
	 * @param ty The y coordinate of the tile we're moving to
	 * @return The relative cost of moving across the given tile
	 */
//	public float getCost(PathFindingContext context, int tx, int ty){return 0;}
	
	
	
}
