package javagame;
import org.newdawn.slick.Image;

import javagame.Common.ItemType;

public class Item {

	// Properties
	int power;
	String name;
	String desc; // What character says about it.
	ItemType type;
	boolean consumable;
	
	Image itemIcon;
	
	public Item(String name) {
		this.name = name;
	}
	
	public Item(String name, String desc, ItemType type, int power) {
		this.power = power;
		this.name = name;
		this.desc = desc;
		this.type = type;
		consumable = true;
	}
	
	public Item(String name, String desc, ItemType type, int power, boolean consumable) {
		this.power = power;
		this.name = name;
		this.desc = desc;
		this.type = type;
		this.consumable = consumable;
	}

	public void useItem(Character charUsing){
		// Will depend on the item type
		// �ki tane se�enek var:
		/*
		 * 1. Bu class abstract olacak, her item t�r� i�in class a��p useItem fonk. yazaca��m
		 * 2. Buraya typelara g�re tek tek charactere ne olaca��n� yazaca��m.
		 */
	}
	
	// GET SET TRASH
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public boolean isConsumable() {
		return consumable;
	}

	public void setConsumable(boolean consumable) {
		this.consumable = consumable;
	}
	
	
	
	
	
}