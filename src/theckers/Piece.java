package theckers;

import java.awt.*;

public abstract class Piece {
    private Color color;
    private int xdelta = Window.getWidth2()/Board.NUM_COLUMNS;
    private int ydelta = Window.getHeight2()/Board.NUM_ROWS;    
    
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
    
    public void setPieceImage(String _player1ImagePath, String _player2ImagePath)
    {
        //set as default image for piece basically a try and catch
        if(getColor() == Board.player1Color)
            pieceImage = Toolkit.getDefaultToolkit().getImage(_player1ImagePath);
        else if(getColor() == Board.player2Color)
            pieceImage = Toolkit.getDefaultToolkit().getImage(_player2ImagePath);
        
    }
    
    protected void drawPiece(Graphics2D g, int row, int col)
    {
        g.fillOval(Window.getX(col*getXDelta()),Window.getY(row*getYDelta()),getXDelta(),getYDelta());
        
        g.setColor(Color.black);
        g.setFont(new Font("Broadway",Font.PLAIN,20));
        g.drawString(String.valueOf(getHealth()), Window.getX(col* getXDelta()) + getXDelta()/2 - 20, Window.getY(row * getYDelta()) + getYDelta()/2); 
    }
    
    protected void drawPiece(Graphics2D g, int row, int col, Theckers obj)
    {
        if(pieceImage != null)
            g.drawImage(pieceImage, Window.getX(col*getXDelta()), Window.getY(row*getYDelta()), getXDelta(), getYDelta(), obj);
        else
            drawPiece(g, row, col);
        
        g.setColor(Color.black);
        g.setFont(new Font("Broadway",Font.PLAIN,20));
        g.drawString(String.valueOf(getHealth()), Window.getX(col* getXDelta()) + getXDelta()/2 - 20, Window.getY(row * getYDelta()) + getYDelta()/2); 
    }
    
    protected abstract void setHealth();    
    protected abstract void setAttack();    
    protected abstract void setRange();    
    
    
    
}
