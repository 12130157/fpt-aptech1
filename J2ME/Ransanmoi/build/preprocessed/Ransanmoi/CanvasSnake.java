/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Ransanmoi;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

/**
 *
 * @author Thiepnd
 */
public class CanvasSnake extends GameCanvas implements Runnable{
    private boolean isPlay;
    private int delay;
    private int heading=2;
    private int currentX,currentY;
    private int width,height;
    //int i=0;
    portionSnake pSnake;
    public CanvasSnake(){
        super(true);
        delay=200;
        width=getWidth();
        height=getHeight();
        currentX=40;
        currentY=40;
    }
    public void run() {
        Graphics g= getGraphics();
        pSnake= new portionSnake();
        while(isPlay==true){
            switch(heading){
                case 1:
                    currentY=currentY-5;
                    break;
                case 2:
                    currentX=currentX+5;
                    break;
                case 3:
                    currentY=currentY+5;
                    break;
                case 4:
                    currentX=currentX-5;
            }
           input();
           this.drawScreen(g);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
        }
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    public void start(){
    isPlay=true;
    Thread t= new Thread(this);
    t.start();
        
    }
    public void stop(){
        isPlay=false;
        
    }
     public void input(){
        int keyStates= getKeyStates();
        if((keyStates&LEFT_PRESSED)!=0){
            //currentX=currentX-5;
            heading=4;
        }
        if((keyStates&RIGHT_PRESSED)!=0){
            //currentX=currentX+5;
            heading=2;
            //System.out.println(currentX);
        }
        if((keyStates&UP_PRESSED)!=0){
            //currentY=currentY-5;
            heading=1;
            //System.out.println(currentY);
        }
        if((keyStates&DOWN_PRESSED)!=0){
            //currentY=currentY+5;
            heading=3;
        }
    }
    public void drawScreen(Graphics g){
        g.setColor(0xFFFF00);
        g.fillRect(0, 0, width, height);
        pSnake.moveSnake(currentX, currentY,g);
        flushGraphics();
    }
    

    

            

    
    

}
