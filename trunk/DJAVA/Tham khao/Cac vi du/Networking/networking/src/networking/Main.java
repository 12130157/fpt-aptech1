/*
 * Main.java
 *
 * Created on December 11, 2008, 4:27 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package networking;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 *
 * @author thanhtd_c0804g
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
    URL u = null;
           /* u = new URL("http://yahoo.com.vn");
             System.out.println("day la URL"+u);
             System.out.println("ly ten file"+u.getFile());
             System.out.println("ly ten file"+u.getPath());
             System.out.println("ly ten file"+u.getHost());
             System.out.println("ly ten file"+u.getPort());*/
            InetAddress ip= InetAddress.getLocalHost();
            System.out.println("ip:"+ip);
            System.out.println("getAddd:"+ip.getAddress());
             System.out.println("getAddd:"+ip.getHostAddress());
              System.out.println("getAddd:"+ip.getHostName());
    }
    
}
