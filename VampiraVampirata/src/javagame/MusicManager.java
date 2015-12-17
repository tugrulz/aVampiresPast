package javagame;

import java.util.Observable;
import java.util.Observer;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class MusicManager implements Observer{

	// Properties
	Music msc;
	boolean on = true;
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
	
	public void changeVolume(float change) {
		volume += change;
		msc.setVolume(volume);
	}
	
	public void playManAwake() throws SlickException {
		msc = new Music("res/music/psycho.ogg");
		if (on)
			msc.loop();
	}


	@Override
	public void update(Observable options, Object arg1) {
		// TODO Auto-generated method stub
		if (options instanceof OptionsData) {
			msc.setVolume((((OptionsData)options).volume)*0.01f);
		}
	}
}
