/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theckers;

import java.awt.*;

public class Sniper extends Piece{
    final private int HEALTH_LVL = 500;
    final private int ATTACK_LVL = 250;
    final private int RANGE_NERF = 50;
    final private int RANGE_ATTACK = 2500;
    final private int MOVES_ALLOWED = 2;
    
    
    final private String player1ImagePath = "./runnable/sniper.png";
    final private String player2ImagePath = "./runnable/sniper2.png";
    
    
    public Sniper(Color _color, int _row, int _col)
    {
        super(_color, _row, _col);
        super.setName("Sniper");
        setHealth();
        setAttack();
        setRange();
        setRangeAttack();
        setMovesAllowed();
        setPieceImage();
    }
    
    public void setHealth()
    {
        super.setHealth(HEALTH_LVL);
    }
    
    public void setAttack()
    {
        super.setAttack(ATTACK_LVL);
    }
    
    public void setRange()
    {
        super.setRange(RANGE_NERF);
    }
    
    public void setRangeAttack()
    {
        super.setRangeAttack(RANGE_ATTACK);
    }
    
    public void setMovesAllowed()
    {
        super.setNumMoves(MOVES_ALLOWED);
    }
    
    public void setPieceImage()
    {
        super.setPieceImage(player1ImagePath, player2ImagePath);
    }
        
}
