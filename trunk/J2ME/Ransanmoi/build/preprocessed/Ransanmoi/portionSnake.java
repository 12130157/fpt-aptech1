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
public class portionSnake extends GameCanvas{
    private Graphics snake;
    private int x,y;
    private int delay=0;
    private int numberportion;
    private int[] currentX,currentY;
    private objGift gift= new objGift(170, 170);
    public portionSnake(){
        super(true);
        numberportion=1;
        this.addPortion();
        this.addPortion();
        
        currentX=new int[100];
        currentY=new int[100];
     }
    public void setGift(objGift gift){
        this.gift=gift;
    }
    public void setsnake(Graphics g){
        this.snake=g;
    }
    public void setx(int x){
        this.x=x;
        
    }
    public void sety(int y){
        this.y=y;
    }
    public void drawPortion(int x,int y){
        snake.setColor(0xFF0000);
        snake.fillRect(x, y, 5, 5);
    }
    public void drawHead(){
        //System.out.println(currentX[numberportion-1]);
        snake.setColor(0xFF0000);
        snake.drawRect(currentX[0], currentY[0], 4, 4);
       // flushGraphics();
    }
    public void drawSnake(){
        for(int i=1;i<numberportion;i++){
                //System.out.println(i);
                this.drawPortion(currentX[i],currentY[i]);
                //flushGraphics();
        }
        this.drawHead();
    }
    public void addPortion(){
        numberportion++;
        
        
    }
    public void moveSnake(int x,int y,Graphics g){
        this.setsnake(g);
        gift.setGraphics(snake);
        gift.drawGift();
        for(int i=numberportion-1;i>0;i--){
            currentX[i]=currentX[i-1];
            currentY[i]=currentY[i-1];
        }
            currentX[0]=x;
            currentY[0]=y;
            this.drawSnake();
        if((gift.getX()-x>-5)&&(gift.getX()-x<5)&&(gift.getY()-y>-5)&&(gift.getY()-y<5)){
            this.addPortion();
            System.out.println("ok");
            gift= new objGift(170,170);
            //gift.drawGift();

        }
    }
    
}
