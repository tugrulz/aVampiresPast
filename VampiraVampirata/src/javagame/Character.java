package javagame;

import java.util.ArrayList;

public class Character extends Moving {
	
	// VARIABLES
	float blood;
	public final float BLOOD_MAX = 400;
	
	Inventory inventory;
	boolean hasObjectiveItem;
	boolean catched;
	
	// Constructors
	public Character(){
		super("Vampire");
		inventory = new Inventory();
		height = 48;
		width = 48;
		blood = BLOOD_MAX;
		hasObjectiveItem = false;
		inventory = new Inventory();
		catched = false;
	}

	public float getBlood() {
		return blood;
	}

	public void setBlood(float blood) {
		this.blood = blood;
	}
	
	public void decreaseBlood(float change) {
		blood -= change;
		
		setChanged();
		notifyObservers();
		clearChanged();
	}
	
	public void increaseBlood(float change) {
		blood += change;
		
		setChanged();
		notifyObservers();
		clearChanged();
	}
	
	public boolean isCatched() {
		// TODO Auto-generated method stub
		return false;
	}
	
	// INVENTORY IS A SUBCLASS OF CHARACTER CLASS AND ONLY MANIPULATED BY CHARACTER CONTROLLER
	// INVENTORYVIEW IS AN OBSERVER TO CHARACTER CLASS
	// INVENTORY CAN ALSO NOTIFYOBSERVERS OF CHARACTER
	public class Inventory {
		ArrayList<Item> itemList;
		final int SIZE = 6;
		int current;
//		Character c;
		
		public Inventory() {
//			this.c = c;
			itemList = new ArrayList<Item>();
			current = 0;
		}
		
		public boolean isEmpty(){
			return itemList.isEmpty();
		}
		
		public boolean addItem(Item i){
			boolean changed = itemList.add(i);
			if (changed)
				notifyObservers();
			return changed;
		}
		
		public boolean isFull(){
			return current == SIZE;
		}
		
		public Item takeItem(int i) {
			Item returned = null;
			if (i < itemList.size()){
				if (itemList.get(i).isConsumable())
					returned =  itemList.remove(i);
				else
					returned = itemList.get(i);
			}
			notifyObservers();
			return returned;
		}
		
		
		
	}



	
}
