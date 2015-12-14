package javagame;

import javagame.Common.InteractableType;

public class CharacterController extends MovingController {
	// Note that it takes map control, it is named as map for simplicity
	public CharacterController(Moving obj, MapControl map){ 
		super(obj, map);
		this.obj = (Character) obj;
	}
	
	public void interact() {
		System.out.println("Tried to interact");
		if (map.canInteract(obj.posFeetX, obj.posFeetY)){
			Interactable ref = map.getInteractable(obj.posFeetX, obj.posFeetY);
			System.out.println("Interaction succesfull");
			if (ref.type == InteractableType.TALKONLY) {
				System.out.println(ref.charTalk);
				((Character)obj).talk = ref.charTalk;
			}
			else if (ref.type == InteractableType.OPEN){
				takeItems(ref);
			}
		}
	}
	
	public void decreaseBlood(float change){
		((Character)obj).decreaseBlood(change);
	}
	
	public void takeItems(Interactable container) {
//		if(((Character)obj).inventory.isEmpty()){
			if (((Character)obj).inventory.current <= ((Character)obj).inventory.SIZE){
				System.out.println("alýrým itemlerini");
				boolean notFull = true;
				Item i;
				do {
					i = container.giveItem(0);
					System.out.println(i.name + " alýcam");
					notFull = ((Character)obj).inventory.addItem(i);
				} while (i != null && notFull);
			}
//		}
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
