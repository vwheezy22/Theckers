/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theckers;

import java.awt.*;

public class Pawn extends Piece{
    final private int HEALTH_LVL = 500;
    final private int ATTACK_LVL = 250;
    final private int RANGE_NERF = 50;
    final private int RANGE_ATTACK = 250;
    final private int MOVES_ALLOWED = 2;
    
    final private String player1ImagePath = "./runnable/pawn.png";
    final private String player2ImagePath = "./runnable/pawn.png";
    
    
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
        super.setPieceImage(player1ImagePath, player2ImagePath);
    }
    
    //default drawing of piece without image
    public void drawPiece(Graphics2D g, int row, int col)
    {
        super.drawPiece(g, row, col);
    }
    
    public void drawPiece(Graphics2D g, int row, int col, Theckers obj)
    {
        super.drawPiece(g, row, col, obj);
    }
    
}
