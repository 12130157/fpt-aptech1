/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demosocketclient;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tunn
 */
public class Client {
    public static void main(String agrs[]) {
        Socket client = null;
        PrintStream swriter = null;//
        try {
            client = new Socket("127.0.0.1",2000);
            swriter=new PrintStream(client.getOutputStream());
            swriter.println("Hello Socket");
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                client.close();
                swriter.close();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
