/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Layermanager;

import java.io.IOException;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

/**
 * @author ThiepND
 */
public class Midlet extends MIDlet {
    private Display display;
    public void startApp() {
        try {
            display = Display.getDisplay(this);
            ExampleGameCanvas gameCanvas = new ExampleGameCanvas();
            gameCanvas.start();
            display.setCurrent(gameCanvas);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Display getDisplay(){
        return display;
    }
    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
        exit();
    }
    public void exit(){
        System.gc();
        destroyApp(false);
        notifyDestroyed();
    }
}
