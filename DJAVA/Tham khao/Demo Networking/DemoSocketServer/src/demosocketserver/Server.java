/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demosocketserver;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tunn
 */
public class Server {
    public static void main(String agrs[]) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(2000);
            System.out.println("Server is running");
            Socket proxy=server.accept();

            BufferedReader reader=new BufferedReader(
                                    new InputStreamReader(proxy.getInputStream()));
            int c=0;
            while((c=reader.read())!=-1) {
                System.out.print(Character.toString((char) c));
            }

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                server.close();
                System.out.println("Server is closed");
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
