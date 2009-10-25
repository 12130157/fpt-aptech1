/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demodatagramclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tunn
 */
public class DatagramClient {
    public static void main(String agrs[]) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            int port =2000;

            byte[] data = new byte[]{1, 2, 3};

            DatagramPacket packet = new DatagramPacket(data, data.length, address,port);

            DatagramSocket socket=new DatagramSocket();
            socket.send(packet);

        } catch (IOException ex) {
            Logger.getLogger(DatagramClient.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
