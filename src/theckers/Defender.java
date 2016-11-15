package theckers;

import java.awt.*;


public class Defender extends Piece {
    //implement enumeration to show the directions piece is allowed to move
    
    final private int HEALTH_LVL = 1000;
    final private int ATTACK_LVL = 500;
    final private int RANGE_NERF = 1;
    final private int RANGE_ATTACK = 250;
    final private int MOVES_ALLOWED = 3;
    
    final private String player1ImagePath = "./rook.png"; 
    final private String player2ImagePath = "./rook.png"; 
    
    public Defender(Color _color)
    {
        super(_color);
        name = "Defender";
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
        super.setPieceImage(player1ImagePath, player2ImagePath );
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
