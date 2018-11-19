package Media;

import java.applet.Applet;
import java.applet.AudioClip;

public class Music {

	private static AudioClip bgm;
	private static AudioClip[] gameEffect;

	public Music() {
		bgm = Applet.newAudioClip(getClass().getResource("/AudioTrack/bgmusic.wav"));
		
		gameEffect = new AudioClip[3];
		gameEffect[0] = Applet.newAudioClip(getClass().getResource("/AudioTrack/crush.wav"));
	}

	public static void playBGM() {
		bgm.loop();
	}
	
	public static void stopBGM(){
		bgm.stop();
	}
	
	public static void crush(){
		gameEffect[0].play();
	}
	
	public static void bouce(){
		
	}
}