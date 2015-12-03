package javagame;
import javagame.Common.ItemType;

public class ObjectiveItem extends Item {
	public ObjectiveItem(String name) {
		super(name, "You have found the objective item!", ItemType.OBJ, -1);
	}
	
}
