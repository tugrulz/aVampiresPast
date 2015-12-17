/**
 * 
 */
package javagame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Tuðrulcan
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

	// TUM METHODLARA SET CHANGED VE CLEAR CHANGED EKLENECEK
	// GET SET TRASH
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
		try {
			setBrightnessWork(br);
		} catch (IOException e) {
			
		}
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
	
	public static void setBrightnessWork(int brightness)
			throws IOException {
	        //Creates a powerShell command that will set the brightness to the requested value (0-100), after the requested delay (in milliseconds) has passed. 
	        String s = String.format("$brightness = %d;", brightness)
	                + "$delay = 0;"
	                + "$myMonitor = Get-WmiObject -Namespace root\\wmi -Class WmiMonitorBrightnessMethods;"
	                + "$myMonitor.wmisetbrightness($delay, $brightness)";
	        String command = "powershell.exe  " + s;
	        // Executing the command
	        Process powerShellProcess = Runtime.getRuntime().exec(command);

	        powerShellProcess.getOutputStream().close();

	        //Report any error messages
	        String line;

	        BufferedReader stderr = new BufferedReader(new InputStreamReader(
	                powerShellProcess.getErrorStream()));
	        line = stderr.readLine();
	        if (line != null)
	        {
	            System.err.println("Standard Error:");
	            do
	            {
	                System.err.println(line);
	            } while ((line = stderr.readLine()) != null);

	        }
	        stderr.close();

   }
	
	
	
}
