package theckers;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Theckers extends JFrame implements Runnable {
    
    Image image;
    //figure icon image out
    static Image iconImage = Toolkit.getDefaultToolkit().getImage("./runnable/vaporwave.png");
    Graphics2D g;
    boolean animateFirstTime = true;
    int zrowTemp;
    int zcolTemp;
    
    Board board;
    Piece a = null;

    public static void main(String[] args) {
        Theckers frame = new Theckers();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setTitle("t h e c k e r s");
        //figure icon image out
        frame.setIconImage(iconImage);
        frame.setVisible(true);
        //Audio.playBackGroundMusic();
    }

    public Theckers() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                //highlighting a piece code
                if (e.BUTTON1 == e.getButton() && !board.getOnPiece()) {
                    
                    
                    int zcol = 0;
                    int zcolLoc = board.xdelta;
                    
                    for (int i=0;i<Board.NUM_COLUMNS;i++)
                    {
                        if (zcolLoc*i < e.getX()-Window.getX(0))
                            
                                zcol = i;
                    } 
                    System.out.println(zcol);
                    int zrow = 0;
                    int zrowLoc = board.ydelta;
                    
                    for (int i=0;i<Board.NUM_ROWS;i++)
                    {
                        if (zrowLoc*i < e.getY()-Window.getY(0))
                            zrow = i;
                    } 
                    System.out.println(zrow); 
                    if(board.board[zrow][zcol] != null && (board.board[zrow][zcol].getPlayer()== board.isPlayer1()))
                    {
                        //actually highlights the piece when set to true
                        board.setOnPiece(true, zrow, zcol);
                                               
                        a=board.board[zrow][zcol];
                        zrowTemp=zrow;
                        zcolTemp=zcol;
                        
//                        board.board[zrow][zcol]=null;
//                        a.drawPiece(g, zrow, zcol);
                        board.switchPlayerTurns();

                    }
                    System.out.println(a); 
                    
                }
                //moving a piece after selecting code
                if (e.BUTTON1 == e.getButton() && board.getOnPiece()) {
                    int zcol = 0;
                    int zcolLoc = board.xdelta;
                    
                    for (int i=0;i<Board.NUM_COLUMNS;i++)
                    {
                        if (zcolLoc*i < e.getX() - Window.getX(0))
                            zcol = i;
                    } 
//                    System.out.println(zcol);
                    int zrow = 0;
                    int zrowLoc = board.ydelta;
                    
                    for (int i=0;i<Board.NUM_ROWS;i++)
                    {
                        if (zrowLoc*i < e.getY() - Window.getY(0))
                            zrow = i;
                    } 
//                     if(zrow>=zrowTemp+a.getNumMoves())
//                         zrow=zrowTemp+a.getNumMoves();
//                     if(zrow<=zrowTemp-a.getNumMoves())  
//                         zrow=zrowTemp-a.getNumMoves();
//                     if(zcol>=zcolTemp+a.getNumMoves())
//                         zcol=zcolTemp+a.getNumMoves();
//                     if(zcol<=zcolTemp-a.getNumMoves())  
//                         zcol=zcolTemp-a.getNumMoves();
//                    System.out.println(zrow); 

                    //moves a piece highlighted to an open spot
                    board.board[board.getOnPieceRow()][board.getOnPieceCol()].moveFunction(zrow, zcol, board);
                    
                    //moves a piece to the spot of an enemy you just killed
                    
                    board.board[board.getOnPieceRow()][board.getOnPieceCol()].attackFunction(zrow, zcol, board);
                    
                    
                    board.board[board.getOnPieceRow()][board.getOnPieceCol()].startHighlightPieceChange(zrow, zcol, board);
                        System.out.println(zrow);
                        System.out.println(zcol);
                        
                    
                    
//                    //unhighlights a piece 
//                    if(board.board[zrow][zcol] != null && board.board[zrow][zcol] == board.board[board.getOnPieceRow()][board.getOnPieceCol()])
//                    {
//                        board.setOnPiece(false);
//                    }
                }
                
                
                if (e.BUTTON3 == e.getButton() && board.getOnPiece()) {
                    int zcol = 0;
                    int zcolLoc = board.xdelta;
                    
                    for (int i=0;i<Board.NUM_COLUMNS;i++)
                    {
                        if (zcolLoc*i < e.getX()-Window.getX(0))
                            
                                zcol = i;
                    } 
                    System.out.println(zcol);
                    int zrow = 0;
                    int zrowLoc = board.ydelta;
                    
                    for (int i=0;i<Board.NUM_ROWS;i++)
                    {
                        if (zrowLoc*i < e.getY()-Window.getY(0))
                            zrow = i;
                    } 
//                    if(zrow>=zrowTemp+a.getRange())
//                         zrow=zrowTemp+a.getRange();
//                     if(zrow<=zrowTemp-a.getRange())  
//                         zrow=zrowTemp-a.getRange();
//                     if(zcol>=zcolTemp+a.getRange())
//                         zcol=zcolTemp+a.getRange();
//                     if(zcol<=zcolTemp-a.getRange())  
//                         zcol=zcolTemp-a.getRange();
                    //if(board.board[zrow][zcol] != null && (board.board[zrow][zcol].getPlayer()== board.isPlayer1()))
                    {
                        board.board[board.getOnPieceRow()][board.getOnPieceCol()].rangeAttackFunction(zrow, zcol, board);
                       // board.setOnPiece(false);
                    }
                    
                    if(board.board[zrow][zcol] != null && board.board[board.getOnPieceRow()][board.getOnPieceCol()] instanceof Healer )
                    {
                        Healer healPiece = (Healer) board.board[board.getOnPieceRow()][board.getOnPieceCol()];
                        healPiece.healTeamMatesFunction(zrow, zcol, board);
                        board.setOnPiece(false);
                    }
                }
                
                
                repaint();
            }
        });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {

        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {

        repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.VK_UP == e.getKeyCode()) {
                } else if (e.VK_DOWN == e.getKeyCode()) {
                } else if (e.VK_LEFT == e.getKeyCode()) {
                } else if (e.VK_RIGHT == e.getKeyCode()) {
                } else if (e.VK_ESCAPE == e.getKeyCode()) {
                    reset();
                }
                repaint();
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }
////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
//fill background
        
        g.setColor(Color.cyan);
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.white); //
        g.fillPolygon(x, y, 4);        
// draw border
        g.setColor(Color.red);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
        
        
        board.drawBoard(g, this);
        
         
        
        

        


        
       

            
        gOld.drawImage(image, 0, 0, null);
    }
    
   

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            //may slow down frame rate to show animation of piece losing health when hit with attack or range attack
            double seconds = 1/TimeCount.getFrameRate();    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
/////////////////////////////////////////////////////////////////////////
    public void reset() {
        board = new Board();
        //method to ask if you really want to reset game, yes or no. surround all of reset method with this for loop
        
            //if(board.checkResetConfirmed())
            {
                board.initBoard();
                TimeCount.init();
                Audio.init();
            }

    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {

        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
                        
            reset();

        }
        Audio.checkIfStopped();
        
        board.checkDeath();
        
        if(board.getWin())
            board.ydeltaChange+=10;
        
        TimeCount.addTime();
    }
    

    

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }
/////////////////////////////////////////////////////////////////////////

}
