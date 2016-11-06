
package theckers;


public class TimeCount {
    private static int timeCount;
    private static double frameRate = 10.0;
    
    public static void addTime()
    {
        timeCount++;
    }
    
    public static int getTimeCount()
    {
        return(timeCount);
    }
    
    public static double getFrameRate()
    {
        return(frameRate);
    }
    
    public static boolean update(int val)
    {
        return(timeCount % val == val -1);
    }
    
    public static void init()
    {
        timeCount = 0;
    }
}
