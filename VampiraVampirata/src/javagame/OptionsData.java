/**
 * 
 */
package javagame;

/**
 * @author Tuðrulcan
 *
 */
public class OptionsData extends java.util.Observable {
	
	// Data
	int volume;
	int brightness;
	boolean fullscreen;
	
	public OptionsData() {
		volume = 100;
		brightness = 100;
		fullscreen = false;
		setChanged(); // Silinecek
	}

	// TUM METHODLARA SET CHANGED VE CLEAR CHANGED EKLENECEK
	// GET SET TRASH
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}

	public boolean isFullscreen() {
		return fullscreen;
	}

	public void setFullscreen(boolean fullscreen) {
		this.fullscreen = fullscreen;
	}
	
	
	
}
