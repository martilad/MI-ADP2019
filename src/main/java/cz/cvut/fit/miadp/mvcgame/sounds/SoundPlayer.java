package cz.cvut.fit.miadp.mvcgame.sounds;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer {

    public static synchronized void playCollisionSound() {
        playEffect("/sounds/collision.wav");
    }

    public static synchronized void playShootSound() {
        playEffect("/sounds/shoot.wav");
    }

    public static synchronized void playNewLevelSound() {
        playEffect("/sounds/levelUp.wav");
    }

    private static synchronized void playEffect(String path) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            getClass().getResourceAsStream(path));
                    clip.open(inputStream);
                    clip.start();

                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
}
