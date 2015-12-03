package javagame;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class MusicManager {

	// Properties
	Music msc;
	boolean on = false;
	float volume;
	
	
	public void playTitleMusic() throws SlickException {
		msc = new Music("res/music/Dungeon5.ogg");
		if (on)
			msc.loop();
		volume = 100f;
	}
	

	public void playMainGameMusic() throws SlickException {
		msc = new Music("res/music/Dungeon8.ogg");
		if (on)
			msc.loop();
	}
	
	public void decreaseVolume(float change) {
		volume += change;
	}
}
