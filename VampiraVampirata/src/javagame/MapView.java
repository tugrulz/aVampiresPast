package javagame;

/*
 * This is a trash class, because renderMap() is already implemented in TiledMap class of Slick2D
 */

public class MapView {
	// Properties
	TileMap map;
	
	public MapView(TileMap map) {
		this.map = map;
	}
	
	public void render() {
		map.render(0,0);
	}
}
