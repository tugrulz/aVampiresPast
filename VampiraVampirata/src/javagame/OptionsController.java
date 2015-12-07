package javagame;

public class OptionsController {

	// Properties
	OptionsData data;
	
	// Constructors
	public OptionsController(OptionsData data) {
		this.data = data;
	}
	
	public void changeVolume(int delta) {
		data.setVolume(data.getVolume() + delta);
		data.notifyObservers();
	}
	
	
}
