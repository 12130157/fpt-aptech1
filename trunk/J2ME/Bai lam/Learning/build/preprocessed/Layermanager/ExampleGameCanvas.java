/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Layermanager;

import java.io.IOException;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author ThiepND
 */
public class ExampleGameCanvas extends GameCanvas implements Runnable {

    private boolean  isPlay;
    private long delay;
    private int currentX,currentY;
    private int width;
    private int height;
    private Sprite playerSprite;
    private Sprite backgroundSprite;
    private LayerManager layerManager;

    public ExampleGameCanvas() throws IOException{
        super(true);
        width=getWidth();
        height=getHeight();
        currentX=width/2;
        currentY=height/2;
        delay=20;
        Image backgroundImage= Image.createImage("/layermanager.png");
        backgroundSprite= new Sprite(backgroundImage);

        Image playerImage= Image.createImage("/Sprite.png");
        playerSprite= new Sprite(playerImage,36,36);

        layerManager= new LayerManager();
        layerManager.append(playerSprite);
        layerManager.append(backgroundSprite);
        
        
    }
    public void start(){
        isPlay=true;
        Thread t = new Thread(this);
        t.start();
    }
    public void stop(){
        isPlay=false;
    }

    public void run(){
        Graphics g =getGraphics();
        while(isPlay){
            input();
            drawScreen(g);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }
    public void input(){
        int keyStates= getKeyStates();
        playerSprite.setFrame(0);
        //left
        if((keyStates&LEFT_PRESSED)!=0){
            currentX= Math.max(0, currentX-1);
            //playerSprite.setFrame(1);
        }
        //right
        if((keyStates&RIGHT_PRESSED)!=0){
            if(currentX+5<width){
                currentX=Math.min(width, currentX+1);
                //playerSprite.setFrame(3);
            }
        }
        //up
        if((keyStates&UP_PRESSED)!=0){
          
                currentY=Math.max(0, currentY-1);
                //playerSprite.setFrame(2);
            
        }
        //down
        if((keyStates&DOWN_PRESSED)!=0){
            if(currentY+30<height){
                currentY= Math.min(height, currentY+1);
                //playerSprite.setFrame(4);
            }
        }
    }
    public void drawScreen(Graphics g){
        g.setColor(0x00C000);
        g.fillRect(0, 0, width, height);
        g.setColor(0x0000ff);
        playerSprite.setPosition(currentX, currentY);
        layerManager.paint(g, 0, 0);
        flushGraphics();
    }

    

    

}
