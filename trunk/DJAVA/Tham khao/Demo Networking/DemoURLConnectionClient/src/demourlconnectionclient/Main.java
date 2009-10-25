/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demourlconnectionclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 *
 * @author tunn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException, MalformedURLException, IOException {
        // TODO code application logic here
        String strUrl="http://localhost:8080/DemoURLConnenctionServer/ServerService";
        String text="Hello";
        String stringToReverse = URLEncoder.encode(text, "UTF-8");

        URL url = new URL(strUrl);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);

        OutputStreamWriter out = new OutputStreamWriter(
                connection.getOutputStream());
        out.write("string=" + stringToReverse);
        out.close();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                connection.getInputStream()));

        String decodedString;
        System.out.println("test");
        while ((decodedString = in.readLine()) != null) {
            System.out.println(decodedString);
        }
        in.close();
    }
}