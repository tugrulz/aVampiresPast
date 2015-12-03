package javagame;

import javagame.Common.InteractableType;
import javagame.Common.ItemType;

/*
 * Factory design pattern
 */

public class InteractableFactory {
	
	// Properties
	TileMap map;

	public InteractableFactory(TileMap map){
		this.map = map;
	}
	
	// Creates by loading from map
	public Interactable createInteractableAt(int i, int j) { 
		int tileID = map.getTileId(i, j, map.LAYER_ID_COL); // deðiþecek
		// O TILEDAKI INTERACTABLEA GÖRE CREATE FONKSÝYONU ÇAÐIRACAK.
		if (map.getTileProperty(tileID, "InteractableName", "false").equals("true")) {
			return new Interactable(map.getTileProperty(tileID, "charTalk", "false"));
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
	
	public Interactable createUnLockedInteractable(String name, String desc){ 
		return createInteractable(name, desc, InteractableType.LOCKED, true);
	}
	
}
