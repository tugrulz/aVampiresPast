package javagame;

public class SleepingMan extends Moving {

	// Properties
	boolean sleeping;
	
	public boolean isSleeping() {
		return sleeping;
	}

	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
	}

	public SleepingMan(String name) {
		super(name);
		posX = 0;
		posY = 0;
		posFeetX = posX + width/2;
		posFeetY = posFeetY + height;
	}
	
	
}
