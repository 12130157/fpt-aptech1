/*
 * NewClass.java
 *
 * Created on December 22, 2008, 12:31 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package onlinetest;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 *
 * @author daunm_c0801l
 */
public interface TestInterface extends Remote {
    
    /** Creates a new instance of NewClass */
    public String inputTest(String question) throws RemoteException;
    public String ouputTestq(String i) throws RemoteException;
    public Vector ouputTesta(String i) throws RemoteException;
    public String replyTest() throws RemoteException;
    public Vector allQuestion() throws RemoteException;
    
    
}
