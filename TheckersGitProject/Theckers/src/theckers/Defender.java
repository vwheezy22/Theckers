package theckers;

import java.awt.*;


public class Defender extends Piece {
    //implement enumeration to show the directions piece is allowed to move
    
    final int HEALTH_LVL = 1000;
    final int ATTACK_LVL = 500;
    final int RANGE_NERF = 25;
    final int RANGE_ATTACK = 250;
    final int MOVES_ALLOWED = 3;
    
    public Defender(Color _color)
    {
        super(_color);
        setHealth();
        setAttack();
        setRange();
        setRangeAttack();
        setMovesAllowed();
        setPieceImage();
    }
    
    public void setHealth()
    {
        health = HEALTH_LVL;
    }
    
    public void setAttack()
    {
        attack = ATTACK_LVL;
    }
    
    public void setRange()
    {
        range = RANGE_NERF;
    }
    
    public void setRangeAttack()
    {
        rangeAttack = RANGE_ATTACK;
    }
    
    public void setMovesAllowed()
    {
        num_moves = MOVES_ALLOWED;
    }
    
    public void setPieceImage()
    {
        pieceImage = Toolkit.getDefaultToolkit().getImage("./runnable/rook.png");
    }
    
    public void drawPiece(Graphics2D g, int row, int col)
    {
        int xval[] = {Window.getX(col * getXDelta()) + getXDelta()/2, Window.getX(col * getXDelta()) + getXDelta(), Window.getX(col * getXDelta()) };
        int yval[] = {Window.getY(row * getYDelta()), Window.getY(row * getYDelta()) + getYDelta(), Window.getY(row * getYDelta()) + getYDelta()  };
        g.fillPolygon(xval, yval, xval.length);
        g.fillOval(Window.getX(col*getXDelta()),Window.getY(row*getYDelta()),getXDelta(),getYDelta());
        
        g.setColor(Color.black);
        g.setFont(new Font("Broadway",Font.PLAIN,20));
        g.drawString(String.valueOf(getHealth()), Window.getX(col* getXDelta()) + getXDelta()/2, Window.getY(row * getYDelta()) + getYDelta()/2); 
    }
    
    // fix resource for image of defender
    public void drawPiece(Graphics2D g, int row, int col, Theckers obj)
    {
        g.drawImage(pieceImage, Window.getX(col*getXDelta()), Window.getY(row*getYDelta()), getXDelta(), getYDelta(), obj);
        
        g.setColor(Color.black);
        g.setFont(new Font("Broadway",Font.PLAIN,20));
        g.drawString(String.valueOf(getHealth()), Window.getX(col* getXDelta()) + getXDelta()/2, Window.getY(row * getYDelta()) + getYDelta()/2); 
    }
}
