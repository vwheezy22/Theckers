package theckers;

import java.awt.*;


public class Blitzer extends Piece {
    //implement enumeration to show the directions piece is allowed to move
    
    final private int HEALTH_LVL = 250;
    final private int ATTACK_LVL = 1000;
    final private int RANGE_NERF = 50;
    final private int RANGE_ATTACK = 250;
    final private int MOVES_ALLOWED = 5;
    
    final private String player1ImagePath = "./runnable/bishop.png";
    final private String player2ImagePath = "./runnable/bishop.png";
    
    public Blitzer(Color _color)
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
    
    public void drawPiece(Graphics2D g, int row, int col)
    {
        super.drawPiece(g, row, col);
    }
    
    // fix resource for image of defender
    public void drawPiece(Graphics2D g, int row, int col, Theckers obj)
    {
        super.drawPiece(g, row, col, obj);
    }
}
