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
				((Character)obj).talk = ref.charTalk;
			}
			else if (ref.type == InteractableType.LOCKED){
				if (((Character)obj).inventory.containsKey() >= 0){
					((Character)obj).inventory.takeItem(((Character)obj).inventory.containsKey());
					takeItems(ref);
				}
				else 
					((Character)obj).talk = "I don't have the key.";
			}
		}
		else
			((Character)obj).talk = "Nothing to do here.";
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
					if (i!= null ) {
						System.out.println(i.name + " alýcam");
						notFull = ((Character)obj).inventory.addItem(i);
					}
				} while (i != null && notFull);
			}
//		}
	}
	
	public boolean doesHaveObjective() {
		if (((Character)obj).inventory.containsObjective() > 0)
			((Character)obj).setHasObjectiveItem(true);
		return ((Character)obj).hasObjectiveItem();
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
