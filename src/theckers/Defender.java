package theckers;

import java.awt.*;


public class Defender extends Piece {
    //implement enumeration to show the directions piece is allowed to move
    
    final private int HEALTH_LVL = 1000;
    final private int ATTACK_LVL = 500;
    final private int RANGE_NERF = 1;
    final private int RANGE_ATTACK = 250;
    final private int MOVES_ALLOWED = 3;
    
    final private String player1ImagePath = "./runnable/rook.png"; 
    final private String player2ImagePath = "./runnable/rook2.png"; 
    
    public Defender(Color _color, int _row, int _col)
    {
        super(_color, _row, _col);
        super.setName("Defender");
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
        super.setPieceImage(player1ImagePath, player2ImagePath );
    }
  
}
