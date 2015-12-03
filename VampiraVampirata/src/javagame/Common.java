package javagame;

public class Common {
	public enum Direction {
	    UP, RIGHT, LEFT, DOWN
	}
	
	public enum ItemType {
		MISC, OBJ, KEY, POTION, FREEZER; 
	}
	
	public enum InteractableType {
		MISC, TALKONLY, OPEN, LOCKED, HIDE
	}
	
	public static String emptyTalk = "There is nothing to take";
	
	public static MusicManager msc = new MusicManager();
}
