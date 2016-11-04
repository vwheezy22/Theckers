package theckers;

import java.awt.*;


public class Board {
    
    public final static int NUM_ROWS = 11;     //KEEP THE SAME AS NUM_COLUMNS 
    public final static int NUM_COLUMNS = 11;
    public final int xdelta = Window.getWidth2()/NUM_ROWS;
    public final int ydelta = Window.getHeight2()/NUM_COLUMNS;
    
    private Color player1Color = Color.pink;
    private Color player2Color = new Color(0,221,149);
    
    private Image backgroundImage;
    
    
    //pieces
        private Piece PW1 = new Pawn(player1Color);
        private Piece DF1 = new Defender(player1Color);
        
        private Piece PW2 = new Pawn(player2Color);
        private Piece DF2 = new Defender(player2Color);     
        
        
        
        private Piece EMP = null;
    

    
         Piece board[][] = {            {DF1,DF1,DF1,DF1,DF1,DF1,DF1,DF1,DF1,DF1,DF1},
                                        {PW1,PW1,PW1,PW1,PW1,PW1,PW1,PW1,PW1,PW1,PW1},  
                                        {EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP},
                                        {EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP},
                                        {EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP},
                                        {EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP},
                                        {EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP},
                                        {EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP},
                                        {EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP,EMP},
                                        {PW2,PW2,PW2,PW2,PW2,PW2,PW2,PW2,PW2,PW2,PW2},
                                        {DF2,DF2,DF2,DF2,DF2,DF2,DF2,DF2,DF2,DF2,DF2},

                };
                
            
    public Board()
    {
        setBackGroundImage();
        
        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board.length; col++)
            {
                if(board[row][col] != null)
                {
                    if(board[row][col].getColor() == player1Color)
                        board[row][col].setIsPlayer1(true);
                    else if(board[row][col].getColor() == player2Color)
                        board[row][col].setIsPlayer1(false);
                }
            }
        }
    }
    
    
    public void drawBoard(Graphics2D g, Theckers obj)
    {
        //draws the background image
        //need to fix colors if we want this as our background
        g.drawImage(backgroundImage, Window.getX(0), Window.getY(0), Window.getWidth2(), Window.getHeight2(), obj);
        
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
//    public void drawPiece(Graphics2D g,Piece x,int zi, int zx)
//    {
//         
//        //Draw the piece.        
//       
//                    g.setColor(x.getColor()); 
//                    x.drawPiece(g, zi, zx);
//               
//    }
    
    public void initBoard()
    {
        
        
    }
    
    public void setBackGroundImage()
    {
        backgroundImage = Toolkit.getDefaultToolkit().getImage("./runnable/backgroundImage.gif");
    }
    
    
}
