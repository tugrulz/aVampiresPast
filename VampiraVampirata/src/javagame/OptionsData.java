/**
 * 
 */
package javagame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Tu�rulcan
 *
 */
public class OptionsData extends java.util.Observable {
	
	// Data
	int volume;
	int brightness;
	boolean fullscreen;
	boolean paused;
	
	public OptionsData() {
		volume = 100;
		brightness = 25;
		fullscreen = false;
		paused = false;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int vol) {
		if (vol > 100) vol = 100;
		else if (vol < 0) vol = 0;
		this.volume = vol;
		
		setChanged();
		notifyObservers();
		clearChanged();
	}
	

	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int br) {
		if(br < 0) br = 0;
		else if (br>100) br = 0;
		this.brightness = br;
	}

	public boolean isFullscreen() {
		return fullscreen;
	}

	public void setFullscreen(boolean fullscreen) {
		this.fullscreen = fullscreen;
		
		setChanged();
		notifyObservers();
		clearChanged();
	}
	

	
	
	
}
