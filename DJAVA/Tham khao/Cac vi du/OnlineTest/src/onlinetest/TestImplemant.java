/*
 * TestImplemant.java
 *
 * Created on December 22, 2008, 12:33 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package onlinetest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/**
 *
 * @author daunm_c0801l
 */
public class TestImplemant extends UnicastRemoteObject implements TestInterface{
    File f;
    /** Creates a new instance of TestImplemant */
    public TestImplemant() throws RemoteException {
    }
    
    public String inputTest(String question) throws RemoteException {
        String ans=null;
        String thongbao = null;
        BufferedWriter bw = null;
        BufferedReader br = null;
        f = new File("test.dat");
        try {
            if(f.exists()){
                thongbao = "File da ton tai";
            }else{
                
                f.createNewFile();
                
            }
            bw = new BufferedWriter(new FileWriter("test.dat"));
            br = new BufferedReader(new FileReader("test.dat"));
            String s;
            int i=0;
            while((s=br.readLine())!=null){
                i++;
            }
           String quest =  question.substring(0,question.indexOf("?"));
            question ="q."+ String.valueOf(i+1)+":"+quest;
            bw.write(question);
            String[] answer = new String[6];
           
                answer[1]=question.substring(question.indexOf("1")+1,question.indexOf("2"));
                answer[2]=question.substring(question.indexOf("2")+1,question.indexOf("3"));
                answer[3]=question.substring(question.indexOf("3")+1,question.indexOf("4"));
                answer[4]=question.substring(question.indexOf("4")+1,question.indexOf("5"));
                answer[5]=question.substring(question.indexOf("5")+1,question.indexOf("6"));
                answer[6]=question.substring(question.indexOf("6")+1);
           
            for(int k = 0;k<6;k++)
            {
                if(answer[k].length()!=0){
                    ans=String.valueOf(i+1)+"-"+answer[k];
                    bw.write(ans);
                }
            }
            
            thongbao = "Da ghi cau hoi thanh cong";
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return thongbao;
    }
    
    public String ouputTestq(String i) throws RemoteException {
        BufferedReader br = null;
        String thongbao=null;
        try {
            br = new BufferedReader(new FileReader("test.dat"));
            String s = null;
            
            while((s=br.readLine())!=null){
                if(s.substring(0,1).equalsIgnoreCase("q"))
                {
                  if(i.equalsIgnoreCase(s.substring(0,s.indexOf(":")))){
                    thongbao = s;
                  }
                }
            }
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return thongbao;
    }
    
     public Vector ouputTesta(String i) throws RemoteException{
          BufferedReader br = null;
          Vector<String> v = new Vector<String>(); 
        String thongbao="No Imformation";
        try {
            br = new BufferedReader(new FileReader("test.dat"));
            String s = null;
            
            while((s=br.readLine())!=null){
                if(s.substring(0,1).equalsIgnoreCase(i.substring(1,2)))
                {
                 
                    v.add(s);
                 
                }
            }
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return v;
         
     }
    
    public String replyTest() throws RemoteException {
        String thongbao = null;
        return thongbao;
    }
    
    public Vector allQuestion() throws RemoteException {
        Vector<String> v=null;
                v = new Vector<String>();
        BufferedReader br = null;
        String thongbao=null;
        try {
            br = new BufferedReader(new FileReader("test.dat"));
            String s=null;
            
            while((s=br.readLine())!=null) {
                if(s.substring(0,1).equalsIgnoreCase("q"))
                {
                   v.add(s.substring(0,s.indexOf(":")));
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return v;
    }
}

