/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demodatagramclient;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.UnknownHostException;

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

        for (int i = 1; i < 65535; i++) {
            try {
                DatagramSocket s = new DatagramSocket(i);
                s.close();
            } catch (IOException ex) {
                // must not be a server on this port
                System.out.println("There is a server on port " + i);
            }
        } // end for
    }

}
