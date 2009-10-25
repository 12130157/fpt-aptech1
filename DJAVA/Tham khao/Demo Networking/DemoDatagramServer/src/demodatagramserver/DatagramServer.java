/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demodatagramserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tunn
 */
public class DatagramServer {
    public static void main(String args[]) {
        try {
            int port=2000;

            byte[] inBuffer = new byte[256];
            
            DatagramSocket socket = new DatagramSocket(port);

            DatagramPacket packet = new DatagramPacket(inBuffer, inBuffer.length);
            
            socket.receive(packet);

            System.out.println(packet.getLength());
        } catch (IOException ex) {
            Logger.getLogger(DatagramServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
