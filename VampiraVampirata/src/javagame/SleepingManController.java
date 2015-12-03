package javagame;

public class SleepingManController extends CharacterController {
	public SleepingManController(Moving obj, MapControl map){
		super(obj, map);
	}
	
	public void wakeUp(){
		((SleepingMan)obj).setSleeping(false);
	}
	
	public void catchPlayer(Character vamp){
		
	}
}
