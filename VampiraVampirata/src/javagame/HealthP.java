package javagame;

public class HealthP extends Item {
	public HealthP() {
		super("Health Potion");
	}
	
	public void useItem(Character charUsing) {
		charUsing.blood += power;
	}
}
