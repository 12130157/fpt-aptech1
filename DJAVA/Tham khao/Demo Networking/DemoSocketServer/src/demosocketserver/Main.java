/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demosocketserver;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author tunn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for (int port = 1; port <= 65535; port++) {
            try {
                // the next line will fail and drop into the catch block if
                // there is already a server running on the port
                ServerSocket server = new ServerSocket(port);
            } catch (IOException ex) {
                System.out.println("There is a server on port " + port);
            } // end catch 
        } // end for
    }
}
