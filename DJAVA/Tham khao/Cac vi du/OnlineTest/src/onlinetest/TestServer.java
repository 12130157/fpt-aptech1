/*
 * TestServer.java
 *
 * Created on December 22, 2008, 12:33 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package onlinetest;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author daunm_c0801l
 */
public class TestServer {
    
    /** Creates a new instance of TestServer */
    public TestServer() {
        try
        {
          TestInterface ti = new TestImplemant();
          LocateRegistry.createRegistry(1099);
          Naming.rebind("rmi://localhost:1099/onlinetest",ti);
        }catch(Exception e){
        }
  }
    
    public static void main(String args[]){
        new TestServer();
    }
    
}
