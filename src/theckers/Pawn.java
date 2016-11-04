/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theckers;

import java.awt.*;

public class Pawn extends Piece{
    final int HEALTH_LVL = 250;
    final int ATTACK_LVL = 250;
    final int RANGE_NERF = 50;
    final int RANGE_ATTACK = 250;
    final int MOVES_ALLOWED = 3;
    
    
    public Pawn(Color _color)
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
        pieceImage = Toolkit.getDefaultToolkit().getImage("./runnable/pawn.png");
    }
    
    //default drawing of piece without image
    public void drawPiece(Graphics2D g, int row, int col)
    {
        
        g.fillOval(Window.getX(col*getXDelta()),Window.getY(row*getYDelta()),getXDelta(),getYDelta());
        
        g.setColor(Color.black);
        g.setFont(new Font("Broadway",Font.PLAIN,20));
        g.drawString(String.valueOf(getHealth()), Window.getX(col* getXDelta()) + getXDelta()/2, Window.getY(row * getYDelta()) + getYDelta()/2); 
    }
    
    public void drawPiece(Graphics2D g, int row, int col, Theckers obj)
    {
        g.drawImage(pieceImage, Window.getX(col*getXDelta()), Window.getY(row*getYDelta()), getXDelta(), getYDelta(), obj);
        
        g.setColor(Color.black);
        g.setFont(new Font("Broadway",Font.PLAIN,20));
        g.drawString(String.valueOf(getHealth()), Window.getX(col* getXDelta()) + getXDelta()/2, Window.getY(row * getYDelta()) + getYDelta()/2); 
    }
    
}
