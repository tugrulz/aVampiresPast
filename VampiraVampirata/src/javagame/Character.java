package javagame;

import java.util.ArrayList;

import javagame.Common.ItemType;

public class Character extends Moving {
	
	// VARIABLES
	float blood;
	public final float BLOOD_MAX = 400;
	
	Inventory inventory;
	boolean hasObjectiveItem;
	boolean catched;
	
	String talk;
	
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
		talk = "";
	}
	
	public void setRandomTalk() {
		int rand = (int)(Math.random()*10 + 1);
		System.out.print("Deneme" + rand);
		switch (rand) {
        case 1:  talk = "Only Van Helsing can hunt me.";
        break;
        case 2:  talk = "Still a better love story than twilight.";
        break;
        case 3:  talk = "Trolololololo.";
        break;
        case 4:  talk = "Wanna be my friend?";
        break;
        case 5:  talk = "I'm bored.";
        break;
        case 6:  talk = "I have a dream.";
        break;
        case 7:  talk = "Haters gonna hate.";
        break;
        case 8:  talk = "The internet is dark and full of spoilers.";
        break;
        case 9: talk = 	"Eto'o is done.";
        break;
        case 10: talk = "Give me your command.";
        break;
		}
		
	}

	
	
	public void setCatched(boolean catched) {
		this.catched = catched;
	}

	public boolean hasObjectiveItem() {
		return hasObjectiveItem;
	}

	public void setHasObjectiveItem(boolean hasObjectiveItem) {
		this.hasObjectiveItem = hasObjectiveItem;
	}

	public float getBlood() {
		return blood;
	}

	public void setBlood(float bl) {
		if (bl < 0 ) bl = 0;
		else if (bl>400) bl = 400;
		this.blood = bl;
	}
	
	public void decreaseBlood(float change) {
		blood -= change;
		if (blood < 0) blood = 0;
		if (blood > 400) blood =400;
		setChanged();
		notifyObservers();
		clearChanged();
	}
	
	public void increaseBlood(float change) {
		blood += change;
		if (blood > 400) blood = 400;
		if (blood < 0) blood = 0;
		setChanged();
		notifyObservers();
		clearChanged();
	}
	
	public boolean isCatched() {
		// TODO Auto-generated method stub
		return catched;
	}
	
	/*public void increaseNoise(float change) {
		noise += change;
		
		setChanged();
		notifyObservers();
		clearChanged();
	}
	
	public void decreaseNoise(float change) {
		noise += change;
		
		setChanged();
		notifyObservers();
		clearChanged();
	}*/
	
	
	
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
			System.out.println(i.name + "eklenecek");
			current++;
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
		
		public int containsKey() {
			for (int i=0; i < itemList.size(); i++) {
				if (itemList.get(i).getType() == ItemType.KEY)
					return i;
			}
			return -1;
		}
		
		public int containsObjective() {
			for (int i=0; i < itemList.size(); i++) {
				if (itemList.get(i).getType() == ItemType.OBJ)
					return i;
			}
			return -1;
		}
		
		
		
		
		
	}



	
}
