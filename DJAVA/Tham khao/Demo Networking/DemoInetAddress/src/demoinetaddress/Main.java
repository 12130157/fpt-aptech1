/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demoinetaddress;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        System.out.println(getIP());
        System.out.println(getMac());
    }

    public static String getIP() {
        try {

            // TODO add your handling code here:
            InetAddress add = InetAddress.getLocalHost();
            return add.toString();

        } catch (UnknownHostException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    public static String getMac() {
        try {
            // TODO add your handling code here:
            InetAddress add = InetAddress.getLocalHost();
            NetworkInterface ni = NetworkInterface.getByInetAddress(add);
            byte[] m = ni.getHardwareAddress();//since 1.6
            String mactext = "";
            for (int i = 0; i < m.length; i++) {
                mactext += Integer.toHexString(m[i]).toUpperCase();
                if (i < m.length - 1) {
                    mactext += "-";
                }
            }
            return mactext;
        } catch (SocketException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

}
