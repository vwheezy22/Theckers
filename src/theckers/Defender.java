package theckers;

import java.awt.*;


public class Defender extends Piece {
    //implement enumeration to show the directions piece is allowed to move
    
    final int HEALTH_LVL = 1000;
    final int ATTACK_LVL = 500;
    final int RANGE_NERF = 25;
    final int RANGE_ATTACK = 250;
    final int MOVES_ALLOWED = 4;
    
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
        super.drawPiece(g, row, col);
    }
    
    // fix resource for image of defender
    public void drawPiece(Graphics2D g, int row, int col, Theckers obj)
    {
        super.drawPiece(g, row, col, obj);
    }
}
