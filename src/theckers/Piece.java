package theckers;

import java.awt.*;

public abstract class Piece {
    private Color color;
    private int xdelta = Window.getWidth2()/Board.NUM_COLUMNS;
    private int ydelta = Window.getHeight2()/Board.NUM_ROWS;    
    private int row;
    private int col;    
    private String name;
    private Image pieceImage;
    private int health;       //the amount of health a piece has 
    private int attack;       //if move into another piece of the other team, the other piece loses health
    private int rangeAttack;  //if right-click on a piece of the other team, the other piece loses health
    private int range;    //subtract a certain amount from attack for each square away when attacking
    private int num_moves;    //the amount of squares a certain piece can only move
    private boolean player1;
    //private boolean hasSpecialAbility;    //automatically sets to false
    
    Piece(Color _color, int _row, int _col)
    {
        row = _row;
        col = _col;
        color = _color;
        //hasSpecialAbility = false;
    }
    
    //accessors 
    
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
    
    public int getRow()
    {
        return(row);
    }
    
    public int getCol()
    {
        return(col);
    }
    
    public Image getPieceImage()
    {
        return(pieceImage);
    }
    
    public String getName()
    {
        return(name);
    }
    
    public boolean getPlayer()
    {
        return(player1);
    }
    
    ////////////////////////////////////////////////////////////
    //mutators
    
    public void setPlayer(boolean _player1)
    {
        player1=_player1;
    }
    
    public void setColor(Color _color)
    {
        color = _color;
    }
    
    public void setRow(int _row)
    {
        row = _row;
    }
    
    public void setCol(int _col)
    {
        col = _col;
    }
    
    public void setHealth(int _health)
    {
        health = _health;
    }
    
    public void setAttack(int _attack)
    {
        attack = _attack;
    }
    
    public void setRange(int _rangeNerf)
    {
        range = _rangeNerf;
    }
    
    public void setRangeAttack(int _rangeAttack)
    {
        rangeAttack = _rangeAttack;
    }
    
    public void setNumMoves(int _numMoves)
    {
        num_moves = _numMoves;
    }
    
    public void setName(String _name)
    {
        name = _name;
    }
    
    public void setPieceImage(String _player1ImagePath, String _player2ImagePath)
    {
        //set as default image for piece basically a try and catch
        if(getColor() == Board.player1Color)
            pieceImage = Toolkit.getDefaultToolkit().getImage(_player1ImagePath);
        else if(getColor() == Board.player2Color)
            pieceImage = Toolkit.getDefaultToolkit().getImage(_player2ImagePath);
        
    }
    
    //////////////////////////////////////////////
    //game functions
    
    public void rangeAttackFunction(int _attackedPieceRow, int _attackedPieceCol, Board theBoard)
    {
        //move to empty spot
        if(theBoard.board[_attackedPieceRow][_attackedPieceCol] != null && (theBoard.board[_attackedPieceRow][_attackedPieceCol].getPlayer()== theBoard.isPlayer1()) )
        {
            //vertical cap
            if(_attackedPieceRow <= this.row + this.range && _attackedPieceRow >= this.row - this.range)
            {
                //horizontal cap
                if(_attackedPieceCol <= this.col + this.range && _attackedPieceCol >= this.col - this.range)
                {
                    theBoard.board[_attackedPieceRow][_attackedPieceCol].health -= this.rangeAttack;
                    theBoard.setOnPiece(false);
                    //Audio.PlaySniperSound();
                }
            }
        }
    }
    
    public void attackFunction(int _attackedPieceRow, int _attackedPieceCol, Board theBoard)
    {
        if(theBoard.board[_attackedPieceRow][_attackedPieceCol] != null && (theBoard.board[_attackedPieceRow][_attackedPieceCol].getPlayer()== theBoard.isPlayer1()))
        {
            if(this.attack >= theBoard.board[_attackedPieceRow][_attackedPieceCol].health)
            {
                theBoard.board[_attackedPieceRow][_attackedPieceCol].health -= this.attack;
                theBoard.board[_attackedPieceRow][_attackedPieceCol] = theBoard.board[this.row][this.col];    //sets the data of the piece to that next spot
                this.row = _attackedPieceRow;    //sets both the row and col for drawing to the next spot
                this.col = _attackedPieceCol;
                theBoard.setOnPiece(false);     //sets the highlight off
            }
            else if(this.attack < theBoard.board[_attackedPieceRow][_attackedPieceCol].health)
            {
                //fail safe to fix it switching turns if there was a move and someone was not killed
                theBoard.board[_attackedPieceRow][_attackedPieceCol].health -= this.attack;
                theBoard.board[theBoard.getOnPieceRow()][theBoard.getOnPieceCol()].health = 0;
            }
        }
         
    }
    
    public void moveFunction(int _nextSpotRow, int _nextSpotCol, Board theBoard)
    {
        //move to empty spot
        if(theBoard.board[_nextSpotRow][_nextSpotCol] == null )
        {
            //vertical cap
            if(_nextSpotRow <= this.row + this.num_moves && _nextSpotRow >= this.row - this.num_moves)
            {
                //horizontal cap
                if(_nextSpotCol <= this.col + this.num_moves && _nextSpotCol >= this.col - this.num_moves)
                {
                    theBoard.board[_nextSpotRow][_nextSpotCol] = theBoard.board[this.row][this.col];    //sets the data of the piece to that next spot
                    this.row = _nextSpotRow;    //sets both the row and col for drawing to the next spot
                    this.col = _nextSpotCol;
                    theBoard.setOnPiece(false);     //sets the highlight off
                }
            }
        }
        
    }
    
    
 
    ////////////////////////////////////////
    //drawing functions
    
    protected void drawPiece(Graphics2D g)
    {
        g.fillOval(Window.getX(col*getXDelta()),Window.getY(row*getYDelta()),getXDelta(),getYDelta());
        
        g.setColor(Color.black);
        g.setFont(new Font("Broadway",Font.PLAIN,20));
        g.drawString(String.valueOf(getHealth()), Window.getX(col* getXDelta()) + getXDelta()/2 - 20, Window.getY(row * getYDelta()) + getYDelta()/2); 
    }
    
    protected void drawPiece(Graphics2D g, Theckers obj)
    {
        if(pieceImage != null)
            g.drawImage(pieceImage, Window.getX(col*getXDelta()), Window.getY(row*getYDelta()), getXDelta(), getYDelta(), obj);
        else
            drawPiece(g);
        
        g.setColor(Color.black);
        g.setFont(new Font("Broadway",Font.PLAIN,20));
        g.drawString(String.valueOf(getHealth()), Window.getX(col* getXDelta()) + getXDelta()/2 - 20, Window.getY(row * getYDelta()) + getYDelta()/2); 
    }
    
    
}
