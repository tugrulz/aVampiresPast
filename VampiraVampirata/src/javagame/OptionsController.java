package javagame;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class OptionsController {

	

// Properties
	OptionsData data;
	
	// Constructors
	public OptionsController(OptionsData data) {
		this.data = data;
	}
	
	public void changeVolume(float delta) {
		int newDelta = (int)delta;
		data.setVolume(data.getVolume() + newDelta);
		data.notifyObservers();
	}
	
	public void changeBrightness(int delta) {
		data.setBrightness(data.getBrightness() + delta);
		data.notifyObservers();
	}
	
	public void goFullScreen(boolean fl) {
		data.setFullscreen(fl);
	}
	
	


	
}
