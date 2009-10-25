/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Ransanmoi;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.*;

/**
 * @author Thiepnd
 */
public class Snake extends MIDlet implements CommandListener {
    Display display;
    public void startApp() {
        display=Display.getDisplay(this);
        CanvasSnake cvs= new CanvasSnake();
        cvs.start();
        display.setCurrent(cvs);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
       exit();
    }

    public void commandAction(Command c, Displayable d) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    public void exit(){
        System.gc();
        destroyApp(false);
        notifyDestroyed();
    }
}
