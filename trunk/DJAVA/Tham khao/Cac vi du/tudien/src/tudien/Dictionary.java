/*
 * Dictionary.java
 *
 * Created on December 10, 2008, 1:21 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tudien;
import java.io.*;

import java.util.HashMap;
import javax.swing.JTextArea;

/**
 *
 * @author thanhtd_c0804g
 */
public class Dictionary {
     boolean found=true; 
    HashMap map=new HashMap();
    String word;
    String mean;
    int i=0;
    File f=new File("tudien.txt");
    /** Creates a new instance of Dictionary */
    public Dictionary() {
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
    public void Delete(String word) throws IOException{
        String s="";
        BufferedReader br=new BufferedReader(new FileReader(f));
          String thongbao="";
        while((s=br.readLine())!=null){
            if(word.equalsIgnoreCase(s.substring(0,s.indexOf(":")))){
                found=false;
                thongbao="da tim thay tu!";
            }
        }
          if(found==true){
              thongbao="khong tim thay tu!";
          }
    }
}
