/*
 * Dictionnary.java
 *
 * Created on December 10, 2008, 2:54 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tudien;
import java.io.*;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JTextArea;

/**
 *
 * @author thanhtd_c0804g
 */
public class Dictionnary {
     boolean found=true; 
    HashMap map=new HashMap();
    String word;
    String mean;
    int i=0;
    File f=new File("tudien.txt");
    /** Creates a new instance of Dictionary */
    public Dictionnary() {
    }
    public String Search(String word) throws FileNotFoundException, IOException{
        String s="";
        BufferedReader br=new BufferedReader(new FileReader(f));
        String nghia="";
        while((s=br.readLine())!=null){
            if(word.equalsIgnoreCase(s.substring(0,s.indexOf(":")))){
                nghia=s.substring(s.indexOf(":"));
                break;
            }else{
                nghia="Not Found";
            }
        }
        return nghia;
    }
    public String Add(String word,String mean) throws IOException{
         String s="";
        BufferedReader br=new BufferedReader(new FileReader(f));
        BufferedWriter bw=new BufferedWriter(new FileWriter(f,true));
        String thongbao="";
        while((s=br.readLine())!=null){
            if(word.equalsIgnoreCase(s.substring(0,s.indexOf(":")))){
                found=false;
                thongbao="tu da ton tai!";
                break;
            }
        }
        if(found==true){
                bw.write(word+":"+mean);
                thongbao="da them thanh cong";
                bw.close();
            }
        
        return thongbao;
    }
    public String Delete(String word) throws IOException{
        ArrayList arrl=new ArrayList();
        String s="";
        BufferedReader br=new BufferedReader(new FileReader(f));
          String thongbao="";
        while((s=br.readLine())!=null){
            if(word.equalsIgnoreCase(s.substring(0,s.indexOf(":")))==false){
                arrl.add(s);
            }
        }
          
              f.delete();
               File f=new File("tudien.txt");
               BufferedWriter bw=new BufferedWriter(new FileWriter(f,true));
               for(i=0;i<arrl.size();i++)
               {
                   bw.write(arrl.get(i).toString());
                   thongbao="Da xoa!";
               }
          if(found==true){
              thongbao="khong tim thay tu!";
          }
               return thongbao;
    }
}

