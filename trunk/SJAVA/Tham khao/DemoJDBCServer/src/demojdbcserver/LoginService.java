/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demojdbcserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author tunn
 */
public interface LoginService extends Remote{
    public String login(String name,String pass) throws RemoteException;
}
