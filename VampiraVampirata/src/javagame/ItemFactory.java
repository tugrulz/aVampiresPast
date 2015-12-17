package javagame;

import org.newdawn.slick.Image;

import javagame.Common.ItemType;
/*
 * This class uses Design pattern "Factory Pattern"
 * Note: This class is not effectively used right now. In the future, there could be creating Interactable dynamically
 * (in game) or creating for Database. This class would be good in switching between creating algorithms.
 */
//TRASAH
public class ItemFactory {

	// Properties 
	TileMap map; // Map to decode items from
	
	public ItemFactory(TileMap map){
		this.map = map;
	}
	
	// Creates by loading from map
	public Item createItemAt(int i, int j) { 
		int tileID = map.getTileId(i, j, map.LAYER_ID_COL); // j is row number and also x coordinate
		return createItem(map.getTileProperty(tileID, "ItemName", "false"), "", ItemType.POTION, 0); //EDITLENECEK
	}
	
	public Item createItem(String name, String desc, ItemType type, int power) {
		if (type == ItemType.OBJ) {
			return createObjectiveItem(name);
		}
		else
			return new Item(name, desc, type, power);
	}
	
	public Item createObjectiveItem(String name){ 
		Item item = new Item(name);
		item.setType(ItemType.OBJ);
		return item;
	}
	
	// Creates a default health potion
	public Item createHealthPotion() {
		return new HealthP();
	}
	
	public Item createKey(){
		Item item = new Item("key");
		item.setType(ItemType.KEY);
		item.setConsumable(false);
		
		return item;
	}
	
	public Item createFreezer(){
		return null;
	}
	

	
}
