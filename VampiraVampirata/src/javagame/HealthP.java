package javagame;

import javagame.Common.ItemType;

public class HealthP extends Item {
	public HealthP() {
		super("Health Potion");
		power = 100;
		String desc = "Refreshing"; // What character says about it.
		type = Common.ItemType.POTION;
		consumable = true;
		
	}
	
	public void useItem(Character charUsing) {
		charUsing.blood += power;
	}
}
