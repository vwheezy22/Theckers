package theckers;



public class Audio {
    static Sound backgroundSound = null;
    
    public static void playBackGroundMusic()
    {
        if (backgroundSound != null || backgroundSound.stopPlaying)
            if(backgroundSound.donePlaying)
                backgroundSound.stopPlaying = true;
        backgroundSound = new Sound("./runnable/bebacklater.wav");
    }
    
}
