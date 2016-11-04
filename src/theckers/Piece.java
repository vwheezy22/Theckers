package theckers;

import java.awt.*;

public abstract class Piece {
    private Color color;
    private int xdelta = Window.getWidth2()/Board.NUM_COLUMNS;
    private int ydelta = Window.getHeight2()/Board.NUM_ROWS;    
    private boolean isPlayer1;
    
    protected Image pieceImage;
    protected int health;       //the amount of health a piece has 
    protected int attack;       //if move into another piece of the other team, the other piece loses health
    protected int rangeAttack;  //if right-click on a piece of the other team, the other piece loses health
    protected int range;    //subtract a certain amount from attack for each square away when attacking
    protected int num_moves;    //the amount of squares a certain piece can only move
    
    
    Piece(Color _color)
    {
        color = _color;
    }
    
    public Color getColor()
    {
        return(color);
    }
    
    public boolean isPlayer1()
    {
        return(isPlayer1);
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
    
    public int getRangeAttack()
    {
        return(rangeAttack);
    }
    
    public int getNumMoves()
    {
        return(num_moves);
    }
    
    public int getXDelta()
    {
        return(xdelta);
    }
    
    public int getYDelta()
    {
        return(ydelta);
    }
    
    public Image getPieceImage()
    {
        return(pieceImage);
    }
    
    public void setColor(Color _color)
    {
        color = _color;
    }
    
    public void setIsPlayer1(boolean _isPlayer1)
    {
        isPlayer1 = _isPlayer1;
    }
    
    public void setPieceImage()
    {
        //set as default image for piece basically a try and catch
       // pieceImage = Toolkit.getDefaultToolkit().getImage("./")
    }
    protected abstract void setHealth();    
    protected abstract void setAttack();    
    protected abstract void setRange();    
    protected abstract void drawPiece(Graphics2D g, int row, int col);
    protected abstract void drawPiece(Graphics2D g, int row, int col, Theckers obj);
    
}
