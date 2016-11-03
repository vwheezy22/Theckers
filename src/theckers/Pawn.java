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
    
    
    public Pawn(Color _color)
    {
        super(_color);
        setHealth();
        setAttack();
        setRange();
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
    
    public void setPieceImage()
    {
        pieceImage = Toolkit.getDefaultToolkit().getImage("./pawn.png");
    }
    
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
    }
    
}
