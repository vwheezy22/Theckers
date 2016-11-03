package theckers;

import java.awt.*;

public abstract class Piece {
    private Color color;
    protected int health;
    protected int attack;
    protected int range;    //subtract a certain amount from attack for each square away when attacking
    private int xdelta = Window.getWidth2()/Board.NUM_COLUMNS;
    private int ydelta = Window.getHeight2()/Board.NUM_ROWS;
    
    
    Piece(Color _color)
    {
        color = _color;
    }
    
    public Color getColor()
    {
        return(color);
    }
    
    public int getHealth()
    {
        return(health);
    }
    
    public int getAttack()
    {
        return(attack);
    }
    
    public int getRange()
    {
        return(range);
    }
    
    public int getXDelta()
    {
        return(xdelta);
    }
    
    public int getYDelta()
    {
        return(ydelta);
    }
    public void setColor(Color _color)
    {
        color = _color;
    }
    protected abstract void setHealth();    
    protected abstract void setAttack();    
    protected abstract void setRange();    
    protected abstract void drawPiece(Graphics2D g, int row, int col);
    
}
