package theckers;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.GradientPaint;

public class Theckers extends JFrame implements Runnable {
    
    Image image;
    //figure icon image out
    static Image iconImage;
    Graphics2D g;
    boolean animateFirstTime = true;
    boolean player1Turn = true;
    boolean onPiece = false;
    
    Board board;
    Piece a = null;

    public static void main(String[] args) {
        Theckers frame = new Theckers();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Theckers");
        //figure icon image out
        frame.setIconImage(iconImage);
        frame.setVisible(true);
    }

    public Theckers() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                
                
                
                int ydelta = Window.getHeight2()/Board.NUM_ROWS;
                int xdelta = Window.getWidth2()/Board.NUM_COLUMNS;
                
                if (e.BUTTON1 == e.getButton() && !onPiece) {
                    
                    
                    int zcol = 0;
                    int zcolLoc = xdelta;
                    
                    for (int i=0;i<Board.NUM_COLUMNS;i++)
                    {
                        if (zcolLoc*i < e.getX()-Window.getX(0))
                            zcol = i;
                    } 
                    System.out.println(zcol);
                    int zrow = 0;
                    int zrowLoc = ydelta;
                    
                    for (int i=0;i<Board.NUM_ROWS;i++)
                    {
                        if (zrowLoc*i < e.getY()-Window.getY(0))
                            zrow = i;
                    } 
                    System.out.println(zrow); 
                    if(board.board[zrow][zcol]!=null)
                    {
                        onPiece=true;
                       
                        a=board.board[zrow][zcol];
                        board.board[zrow][zcol]=null;
//                        a.drawPiece(g, zrow, zcol);
                       
                    }
                    System.out.println(a); 
                    
                }
                if (e.BUTTON2 == e.getButton()) {
                    reset();
                }
                if (e.BUTTON3 == e.getButton() && onPiece) {
                    
                    
                    
                    int zcol = 0;
                    int zcolLoc = xdelta;
                    
                    for (int i=0;i<Board.NUM_COLUMNS;i++)
                    {
                        if (zcolLoc*i < e.getX()-Window.getX(0))
                            zcol = i;
                    } 
//                    System.out.println(zcol);
                    int zrow = 0;
                    int zrowLoc = ydelta;
                    
                    for (int i=0;i<Board.NUM_ROWS;i++)
                    {
                        if (zrowLoc*i < e.getY()-Window.getY(0))
                            zrow = i;
                    } 
//                    System.out.println(zrow); 
                    if(board.board[zrow][zcol]==null)
                    {
                        
                        board.board[zrow][zcol]=a;
                        onPiece=false;
                       
                        
                        
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
        g.setColor(Color.white);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.red);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
        
        board.drawBoard(g);

        
         
        
        

        


        
       

            
        gOld.drawImage(image, 0, 0, null);
    }
    
   

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = .1;    //time that 1 frame takes.
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
                            