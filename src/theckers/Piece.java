package theckers;

import java.awt.*;

public abstract class Piece {
    private Color color;
    private int xdelta = Window.getWidth2()/Board.NUM_COLUMNS;
    private int ydelta = Window.getHeight2()/Board.NUM_ROWS;    
    
    private int row;
    private int col;
    
    
    protected String name;
    protected Image pieceImage;
    public int health;       //the amount of health a piece has 
    protected int attack;       //if move into another piece of the other team, the other piece loses health
    protected int rangeAttack;  //if right-click on a piece of the other team, the other piece loses health
    protected int range;    //subtract a certain amount from attack for each square away when attacking
    protected int num_moves;    //the amount of squares a certain piece can only move
    protected boolean player1;
    protected boolean hasSpecialAbility = false;    //automatically sets to false
    
    Piece(Color _color, int _row, int _col)
    {
        row = _row;
        col = _col;
        color = _color;
    }
    
    public Color getColor()
    {
        return(color);
    }
    
    public int getHealth()
    {
        return(health);
    }
    
    public int getAttack()
    {
        return(attack);
    }
    
    public int getRange()
    {
        return(range);
    }
    
    public int getRangeAttack()
    {
        return(rangeAttack);
    }
    
    public int getNumMoves()
    {
        return(num_moves);
    }
    
    public int getXDelta()
    {
        return(xdelta);
    }
    
    public int getYDelta()
    {
        return(ydelta);
    }
    
    public Image getPieceImage()
    {
        return(pieceImage);
    }
    
    public String getName()
    {
        return(name);
    }
    public void setPlayer(boolean a)
    {
        player1=a;
    }
    public boolean getPlayer()
    {
        return(player1);
    }
    public void setColor(Color _color)
    {
        color = _color;
    }
    
    public void rangeAttackFunction(int _attackedPieceRow, int _attackedPieceCol, Board board)
    {
         board.board[_attackedPieceRow][_attackedPieceCol].health -= this.rangeAttack;
         
         //implement the code of range nerf
    }
    
    public void attackFunction(int _attackedPieceRow, int _attackedPieceCol, Board theBoard)
    {
        
        if(this.attack >= theBoard.board[_attackedPieceRow][_attackedPieceCol].health)
        {
            theBoard.board[_attackedPieceRow][_attackedPieceCol].health -= this.attack;
            Audio.playCrashMusic();
            Piece temp = this;
            theBoard.board[theBoard.getOnPieceRow()][theBoard.getOnPieceCol()] = null;
            theBoard.board[_attackedPieceRow][_attackedPieceCol] = temp;
        }
        if(this.attack < theBoard.board[_attackedPieceRow][_attackedPieceCol].health)
        {
            //fail safe to fix it switching turns if there was a move and someone was not killed
            Audio.playCrashMusic();
            theBoard.board[_attackedPieceRow][_attackedPieceCol].health -= this.attack;
            theBoard.board[theBoard.getOnPieceRow()][theBoard.getOnPieceCol()] = null;
        }
         
    }
 
    public void setPieceImage(String _player1ImagePath, String _player2ImagePath)
    {
        //set as default image for piece basically a try and catch
        if(getColor() == Board.player1Color)
            pieceImage = Toolkit.getDefaultToolkit().getImage(_player1ImagePath);
        else if(getColor() == Board.player2Color)
            pieceImage = Toolkit.getDefaultToolkit().getImage(_player2ImagePath);
        
    }
    
    protected void drawPiece(Graphics2D g, int row, int col)
    {
        g.fillOval(Window.getX(col*getXDelta()),Window.getY(row*getYDelta()),getXDelta(),getYDelta());
        
        g.setColor(Color.black);
        g.setFont(new Font("Broadway",Font.PLAIN,20));
        g.drawString(String.valueOf(getHealth()), Window.getX(col* getXDelta()) + getXDelta()/2 - 20, Window.getY(row * getYDelta()) + getYDelta()/2); 
    }
    
    protected void drawPiece(Graphics2D g, int row, int col, Theckers obj)
    {
        if(pieceImage != null)
            g.drawImage(pieceImage, Window.getX(col*getXDelta()), Window.getY(row*getYDelta()), getXDelta(), getYDelta(), obj);
        else
            drawPiece(g, row, col);
        
        g.setColor(Color.black);
        g.setFont(new Font("Broadway",Font.PLAIN,20));
        g.drawString(String.valueOf(getHealth()), Window.getX(col* getXDelta()) + getXDelta()/2 - 20, Window.getY(row * getYDelta()) + getYDelta()/2); 
    }
    
    protected abstract void setHealth();    
    protected abstract void setAttack();    
    protected abstract void setRange();    
    
    
    
}
