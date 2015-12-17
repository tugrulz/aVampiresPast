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

	public ArrayList<Item> getInside() {
		return inside;
	}

	public void setInside(ArrayList<Item> inside) {
		this.inside = inside;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isInteracted() {
		return interacted;
	}

	public void setInteracted(boolean interacted) {
		this.interacted = interacted;
	}

	public String getCharTalk() {
		return charTalk;
	}

	public void setCharTalk(String charTalk) {
		this.charTalk = charTalk;
	}

	public String getAfterTalk() {
		return afterTalk;
	}

	public void setAfterTalk(String afterTalk) {
		this.afterTalk = afterTalk;
	}

	public InteractableType getType() {
		return type;
	}

	public void setType(InteractableType type) {
		this.type = type;
	}
	
	
	
	
	

	
	
	
}
