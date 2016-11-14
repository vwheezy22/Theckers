package theckers;



public class Audio {
    static Sound backgroundSound = null;
    static Sound windowsWinSound = null;
    static Sound movePieceSound = null;
    
    public static void playBackGroundMusic()
    {
        if (backgroundSound != null)
        {
            backgroundSound.stopPlaying = true;
            if(backgroundSound.donePlaying)
                backgroundSound = new Sound("./vaporwavemusic.wav");
            else
                backgroundSound = new Sound("./vaporwavemusic.wav");
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
    
}
