package theckers;

import java.awt.*;
import java.util.HashMap;
import javax.swing.*;


public class Board {
    
    public final static int NUM_ROWS = 11;     //KEEP THE SAME AS NUM_COLUMNS 
    public final static int NUM_COLUMNS = 11;
    public final int xdelta = Window.getWidth2()/NUM_ROWS;
    public final int ydelta = Window.getHeight2()/NUM_COLUMNS;
    public final static Color player1Color = Color.pink;
    public final static Color player2Color = new Color(0,221,149);
    
    public Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];     
    private HashMap<String,Piece> deadPieces;
    private boolean player1Turn;
    
    private static Image backgroundImage;
    private static boolean checkReset;
    private static boolean drawResetCheck;
    
    private boolean onPiece;
    private int onPieceRow;
    private int onPieceCol;
    
    public Board()
    {
        initBoard();
    }
    
    
    public void drawBoard(Graphics2D g, Theckers obj)
    {
        //draws the background image
        //need to fix colors if we want this as our background
        //g.drawImage(backgroundImage, Window.getX(0), Window.getY(0), Window.getWidth2(), Window.getHeight2(), obj);
        
         //draw grid
        g.setColor(Color.black);
        for (int zi = 1;zi<NUM_ROWS;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta),
                    Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
        }
        for (int zi = 1;zi<NUM_COLUMNS;zi++)
        {
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),
                    Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
        }
            
            highlightPiece(g);
            
        
        //Draw the piece.        
        for (int zi = 0;zi<NUM_ROWS;zi++)
        {
            for (int zx = 0;zx<NUM_COLUMNS;zx++)
            {
                if (board[zi][zx] != null)
                {
                    g.setColor(board[zi][zx].getColor()); 
                    board[zi][zx].drawPiece(g, zi, zx, obj);
                    //draw piece - no image
                    //board[zi][zx].drawPiece(g, zi, zx);
                }
            }
        }
    }
    
    private boolean highlightPiece(Graphics2D g)
    {
        
        //returns true if highlighting a piece
        if(onPiece)
        {
            g.setColor(Color.gray);
            if(TimeCount.update(4))
                g.fillRect(Window.getX(onPieceCol*xdelta), Window.getY(onPieceRow*ydelta), xdelta, ydelta);
            return(true);
        }
        else
            return(false);
    }
    
    public void drawCheckReset(Graphics2D g)
    {
        JFrame window = new JFrame();
        window.setVisible(true);
    }
    
    public boolean checkResetConfirmed()
    {
        //implement mouse click into here and make check reset window
        return(false);
    }
    
    public boolean getOnPiece()
    {
        return(onPiece);
    }
    
    public int getOnPieceRow()
    {
        return(onPieceRow);
    }
    
    public int getOnPieceCol()
    {
        return(onPieceCol);
    }
    
    public boolean isPlayer1()
    {
        return(player1Turn);
    }
    
    public void setOnPiece(boolean _onPiece, int row, int col)
    {
        //stores the row and column of the piece you're on when you click
        
        //create a test to check if you clicked on a piece you're already highlighting, the highlight stops so you can choose another piece to highlight
        //if(!onPiece && row != onPieceRow && col != onPieceCol)
        {
            onPiece = _onPiece;
            onPieceRow = row;
            onPieceCol = col;
            return;
        }
        //setOnPiece(false);
        
        
        
    }
   
    
    public void setOnPiece(boolean _onPiece)
    {
        onPiece = _onPiece;
        
    }
    
    public void setBackGroundImage()
    {
        backgroundImage = Toolkit.getDefaultToolkit().getImage("./backgroundImage.gif");
    }
    
    public void initBoard()
    {
        player1Turn = true;
        checkReset = false;
        onPiece = false;
        deadPieces = new HashMap();
        setBackGroundImage();
        
        //board layout
//                                         {DF1,DF1,DF1,BL1,BL1,DF1,BL1,BL1,DF1,DF1,DF1},
//                                        {PW1,PW1,BL1,PW1,PW1,PW1,PW1,PW1,BL1,PW1,PW1},  
//                                        {EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP},
//                                        {EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP},
//                                        {EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP},
//                                        {EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP},
//                                        {EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP},
//                                        {EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP},
//                                        {EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP},
//                                        {PW2,PW2,PW2,BL2,BL2,PW2,BL2,BL2,PW2,PW2,PW2},
//                                        {DF2,DF2,BL2,DF2,DF2,DF2,DF2,DF2,BL2,DF2,DF2},
        
        //places very top row of board
        for(int i = 0; i < NUM_COLUMNS; i++)
        {
            board[0][i] = new Defender(player1Color, 0, i);
            
            if(i == 2 || i == 8)
                board[0][i] = new Sniper(player1Color, 0, i);
            
            if(i == 5)
                board[0][i] = new King(player1Color, 0, i);
            
            if(i == 1 || i == 9)
                board[0][i] = new Healer(player1Color, 0, i);
            
            
            
            board[0][i].setPlayer(true);
        }
        
        //places row 1 of board
        for(int i = 0; i < NUM_COLUMNS; i++)
        {
            board[1][i] = new Pawn(player1Color, 1, i);
            
            if(i == 3 || i == 4 || i == 6 || i == 7)
                board[1][i] = new Blitzer(player1Color, 1, i);
            
            board[1][i].setPlayer(true);
        }
        
        
        //places very bottom row of board
        for(int i = 0; i < NUM_COLUMNS; i++)
        {
            board[NUM_ROWS - 1][i] = new Defender(player2Color, NUM_ROWS - 1, i);
            
            if(i == 2 || i == 8)
                board[NUM_ROWS - 1][i] = new Sniper(player2Color, NUM_ROWS - 1, i);
            
            if(i == 5)
                board[NUM_ROWS - 1][i] = new King(player2Color, NUM_ROWS - 1, i );
            
            if(i == 1 || i == 9)
                board[NUM_ROWS - 1][i] = new Healer(player2Color, NUM_ROWS - 1, i);
            
            
            board[NUM_ROWS - 1][i].setPlayer(false);
        }
        
        //places one row above of bottom row
        for(int i = 0; i < NUM_COLUMNS; i++)
        {
            board[NUM_ROWS - 2][i] = new Pawn(player2Color, NUM_ROWS - 2, i);
          
            if(i == 3 || i == 4 || i == 6 || i == 7)
                board[NUM_ROWS - 2][i] = new Blitzer(player2Color, NUM_ROWS - 2, i );
            
            board[NUM_ROWS - 2][i].setPlayer(false);
        }
        
        
    }
    
    
    public void checkDeath()
    {
        for(int row = 0; row < NUM_ROWS; row ++)
        {
            for(int col = 0; col < NUM_COLUMNS; col ++)
            {
                if(board[row][col] != null)
                {
                    if(board[row][col].health <= 0)
                    {
                        String returnString = board[row][col].getName() + " " + row + " " + col;   //call the return string to get a dead piece by calling its type and row and col e.g. Pawn 1 5, Defender 2 11
                        System.out.println(returnString);
                        deadPieces.put(returnString,board[row][col]);
                        board[row][col] = null;
                        Audio.playCrashMusic();
                    }
                }
            }
        }
    }
    
    public void switchPlayerTurns()
    {
        player1Turn = !player1Turn;
    }
    
    
    
    
}
