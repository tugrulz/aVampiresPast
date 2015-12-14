package javagame;

import java.util.ArrayList;

import javagame.Common.InteractableType;

public class Interactable {

	// Properties
	ArrayList<Item>inside;
	boolean locked;
	boolean interacted;
	String charTalk; // What vampire says about it
	String afterTalk; // After interactation talk, i.e. "There is nothing to take"
	InteractableType type = InteractableType.TALKONLY;
	
	/*public enum InteractableType {
		MISC, TALKONLY, OPEN, LOCKED, HIDE
	}*/
	
	// Constructors
	public Interactable(String talk) {
		inside = new ArrayList<Item>();
		locked = false;
		interacted = false;
		charTalk = talk;
		afterTalk = "There is nothing to take";
	}
	
	public Interactable(String talk, InteractableType type) {
		inside = new ArrayList<Item>();
		locked = false;
		interacted = false;
		charTalk = talk;
		afterTalk = "There is nothing to take";
		this.type = type;
	}
	
	public Interactable(boolean locked, String talk) {
		inside = new ArrayList<Item>();
		this.locked = locked;
		interacted = false;
		charTalk = talk;
		afterTalk = "There is nothing to take";
	}
	
	public Interactable(boolean locked, String talk, String afterTalk) {
		inside = new ArrayList<Item>();
		this.locked = locked;
		interacted = false;
		charTalk = talk;
		this.afterTalk = afterTalk;
	}
	
	public void addItem (Item i) {
		inside.add(i);
	}
	
	public Item giveItem(int i){
		if (inside.isEmpty()){
			interacted = true;
			return null;
		}
		else
			return inside.remove(i);

	}
	
	

	
	
	
}
