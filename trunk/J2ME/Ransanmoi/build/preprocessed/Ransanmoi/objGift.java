/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Ransanmoi;

import java.util.Random;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

/**
 *
 * @author Thiepnd
 */
public class objGift extends GameCanvas {
    private Graphics graphics;
    private portionSnake pS;
    private int width,height;
    private int x,y;
    public objGift(int width,int height){
        super(true);
        this.width=width;
        this.height=height;
        x=random(width);
        y=random(height);
    }
    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public void setpS(portionSnake pS) {
        this.pS = pS;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void drawGift(){
        graphics.setColor(0xFF0000);
        graphics.fillRect(x, y, 5, 5);
    }
    public int random(int number){
        Random r = new Random();
        int i = r.nextInt(number);
        return i;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    

}
