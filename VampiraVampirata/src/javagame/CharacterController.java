package javagame;

import javagame.Common.InteractableType;

public class CharacterController extends MovingController {
	// Note that it takes map control, it is named as map for simplicity
	public CharacterController(Moving obj, MapControl map){ 
		super(obj, map);
		this.obj = (Character) obj;
	}
	
	public void interact() {
		if (map.canInteract(obj.posFeetX, obj.posFeetY)){
			Interactable ref = map.getInteractable(obj.posFeetX, obj.posFeetY);
//			if (ref.type == InteractableType.TALKONLY) {
				System.out.println(ref.charTalk);
//			}
		}
	}
	
	public void decreaseBlood(float change){
		((Character)obj).decreaseBlood(change);
	}
	
	public void takeItems(Interactable container) {
		if(((Character)obj).inventory.isEmpty()){
			if (((Character)obj).inventory.current <= ((Character)obj).inventory.SIZE){
				Item i = container.giveItem(0);
				boolean notFull = true;
				while (i != null && notFull) {
					notFull = ((Character)obj).inventory.addItem(i);
				}
			}
		}
	}
	
	public void useItem(int index){ // BUNA Bi DiZAYN PATTERN UYDURMAK GEREK
		Item item = ((Character)obj).inventory.takeItem(index);
		if (item != null) {
			item.useItem((Character)obj);
//			if (item.getType() == Common.ItemType.POTION) {
				//((Character)obj).increaseBlood(item.getPower()); // I have extended a Person class, now I have to typecast to character everytime, which is also nonsense
				//or
				// item.use(Character obj);
//			}
//			else
//				System.out.println("and other items..");
		}
		else
			System.out.println("Cannot use");
	}
}
