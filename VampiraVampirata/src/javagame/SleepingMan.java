package javagame;

public class SleepingMan extends Moving {

	// Properties
	boolean sleeping;
	float threshold;
	float scale;
	float sight;
	boolean checked = false;
	
	public boolean isSleeping() {
		return sleeping;
	}

	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
		
		setChanged();
		notifyObservers();
		clearChanged();
	}

	public SleepingMan(String name) {
		super(name);
		posX = 0;
		posY = 0;
		posFeetX = posX + width/2;
		posFeetY = posFeetY + height;
		height = 32;
		width = 32;
		sleeping = true;
		threshold = 200;
		scale = 168;
		sight = 80;
	}
	
	public SleepingMan() {
		super("House Owner");
		posX = 0;
		posY = 0;
		posFeetX = posX + width/2;
		posFeetY = posFeetY + height;
		height = 32;
		width = 32;
		sleeping = true;
		threshold = 200;
		scale = 168;
		sight = 80;
	}

	public float getThreshold() {
		return threshold;
	}

	public void setThreshold(float threshold) {
		this.threshold = threshold;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public float getSight() {
		return sight;
	}

	public void setSight(float sight) {
		this.sight = sight;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
				setChanged();
				notifyObservers();
				clearChanged();;
	}
	
	
	
	
	
}
