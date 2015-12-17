package javagame;

import javagame.Common.InteractableType;
import javagame.Common.ItemType;

/*
 * Factory design pattern
 * Note: This class is not effectively used right now. In the future, there could be creating Interactable dynamically
 * (in game) or creating for Database. This class would be good in switching between creating algorithms.
 */


public class InteractableFactory {
	
	// Properties
	TileMap map;
	ItemFactory itemFactory;

	public InteractableFactory(TileMap map){
		this.map = map;
		itemFactory = new ItemFactory(map);
	}
	
	// Creates by loading from map
	public Interactable createInteractableAt(int i, int j) { 
		int tileID = map.getTileId(i, j, map.LAYER_ID_COL); // deðiþecek
		// O TILEDAKI INTERACTABLEA GÖRE CREATE FONKSÝYONU ÇAÐIRACAK.
		if (map.getTileProperty(tileID, "interactable", "false").equals("true")) {
			System.out.println("Found an interactable from int factory");
			if (map.getTileProperty(tileID, "type", "false").equals("TALKONLY")){
				return new Interactable(map.getTileProperty(tileID, "charTalk", "false"));
			}
			else if (map.getTileProperty(tileID, "type", "false").equals("OPEN")){
				return createUnLockedInteractable(map, tileID);
			}
			else if (map.getTileProperty(tileID, "type", "false").equals("LOCKED"))
				return createLockedInteractable(map, tileID);
			else
					return null;
		}
		else
			return null;
//		return createInteractable(map.getTileProperty(tileID, "InteractableName", "false"), "", InteractableType.OPEN, false); //EDITLENECEK
	}
	
	// Creates for other uses
	public Interactable create(String name) {
		return null;
	}
	
	public Interactable createInteractable(String name, String desc, InteractableType type, boolean locked) {
		return null; // for now
	}
	
	public Interactable createLockedInteractable(String name, String desc){ 
		return createInteractable(name, desc, InteractableType.LOCKED, true);
	}
	
	public Interactable createLockedInteractable(TileMap map, int tileID){ 
		Interactable inte = createUnLockedInteractable(map, tileID);
		inte.setType(InteractableType.LOCKED);
		return inte;
	}
	
	public Interactable createUnLockedInteractable(String name, String desc){ 
		return createInteractable(name, desc, InteractableType.LOCKED, true);
	}
	
	public Interactable createUnLockedInteractable(TileMap map, int tileID){ 
		Interactable inte = new Interactable(map.getTileProperty(tileID, "charTalk", "false"), InteractableType.OPEN);
		Item item = null;
		int currentItem = 1;
		while(currentItem <= Integer.parseInt(map.getTileProperty(tileID, "itemNumber", "false"))) {
			String curItem = map.getTileProperty(tileID, "item"+currentItem, "false");
			if(curItem.contains("healthp")){
				item = itemFactory.createHealthPotion();
			}
			else if(curItem.contains("diary")){
				item = itemFactory.createObjectiveItem("diary");
			}
			else if (curItem.contains("key")){
				item = itemFactory.createKey();
			}
			inte.addItem(item);
			currentItem++;
		}
		return inte;
	}
	
}
