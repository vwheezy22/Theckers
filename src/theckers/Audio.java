package theckers;



public class Audio {
    static Sound backgroundSound = null;
    static Sound windowsWinSound = null;
    static Sound movePieceSound = null;
    static Sound crashPieceSound = null;
    static Sound sniperSound = null;
    static Sound yeahBoySound = null;
    
    public static void playBackGroundMusic()
    {
        if (backgroundSound != null)
        {
            backgroundSound.stopPlaying = true;
        }
        else
            backgroundSound = new Sound("./vaporwavemusic.wav");
        
    }
    
    public static void checkIfStopped()
    {
        if(backgroundSound != null)
            if(backgroundSound.donePlaying)
                playBackGroundMusic();
    }
    
    public static void playWindowsWinMusic()
    {
        if (windowsWinSound != null)
                windowsWinSound.stopPlaying = true;
        windowsWinSound = new Sound("./windowsWin.wav");
    }
    
    public static void playMovePieceSFX()
    {
        if (movePieceSound != null)
                movePieceSound.stopPlaying = true;
        movePieceSound = new Sound("./.wav");
    }
    
    public static void playCrashMusic()
    {
        if (crashPieceSound != null)
                crashPieceSound.stopPlaying = true;
        crashPieceSound = new Sound("./crash.wav");
    }
    
    public static void playSniperSound()
    {
        if (sniperSound != null)
                sniperSound.stopPlaying = true;
        sniperSound = new Sound("./sniperSound.wav");
    }
    
    public static void playYeahBoy()
    {
        if (yeahBoySound != null)
                yeahBoySound.stopPlaying = true;
        yeahBoySound = new Sound("./longestYeahBoy.wav");
    }
    
}
