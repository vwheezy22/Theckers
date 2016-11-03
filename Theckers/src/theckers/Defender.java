/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theckers;

import java.awt.*;


public class Defender extends Piece {
    final int HEALTH_LVL = 1000;
    final int ATTACK_LVL = 250;
    final int RANGE_NERF = 25;
    
    public Defender(Color _color)
    {
        super(_color);
        setHealth();
        setAttack();
        setRange();
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
}
