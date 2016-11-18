package theckers;



public class Audio {
    static Sound backgroundSound = null;
    static Sound windowsWinSound = null;
    static Sound movePieceSound = null;
    static Sound crashPieceSound = null;
    static Sound sniperSound = null;
    static Sound yeahBoySound = null;
    
    static boolean checkBool = true;
    
    
    public static void init()
    {
        checkBool = true;
        
        if (yeahBoySound != null)
                yeahBoySound.stopPlaying = true;
        
        playBackGroundMusic();
                
    }
    
    
    public static void playBackGroundMusic()
    {
        if (backgroundSound != null)
        {
            backgroundSound.stopPlaying = true;
            if(backgroundSound.donePlaying)
                backgroundSound = new Sound("./runnable/vaporwavemusic.wav");
        }
        else
            backgroundSound = new Sound("./runnable/vaporwavemusic.wav");
        
    }
    
    public static void checkIfStopped()
    {
        if(checkBool)
        {
            if(backgroundSound != null)
                if(backgroundSound.donePlaying)
                    playBackGroundMusic();
        }
        else
            backgroundSound.stopPlaying = true;
    }
    
    public static void playWindowsWinMusic()
    {
        if (windowsWinSound != null)
                windowsWinSound.stopPlaying = true;
        windowsWinSound = new Sound("./runnable/windowsWin.wav");
    }
    
    public static void playMovePieceSFX()
    {
        if (movePieceSound != null)
                movePieceSound.stopPlaying = true;
        movePieceSound = new Sound("./runnable/ .wav");
    }
    
    public static void playCrashMusic()
    {
        if (crashPieceSound != null)
                crashPieceSound.stopPlaying = true;
        crashPieceSound = new Sound("./runnable/crash.wav");
    }
    
    public static void playSniperSound()
    {
        if (sniperSound != null)
                sniperSound.stopPlaying = true;
        sniperSound = new Sound("./runnable/sniperSound.wav");
    }
    
    public static void playYeahBoy()
    {
        if (yeahBoySound != null)
                yeahBoySound.stopPlaying = true;
        yeahBoySound = new Sound("./runnable/longestYeahBoy.wav");
    }
    
    public static void setCheckBool(boolean _checkBool)
    {
        checkBool = _checkBool;
    }
    
}
