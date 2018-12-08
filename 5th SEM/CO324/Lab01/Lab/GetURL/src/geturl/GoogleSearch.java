/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geturl;

import static geturl.GetURL.address;
import static geturl.GetURL.out;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 *
 * @author Geeth
 */

public class GoogleSearch {
    
    public static String address;
    public static String defaultAddress = "https://www.google.lk/search?q=";
    public static String url;
    
    public static void main(String[] args)throws MalformedURLException, UnsupportedEncodingException, IOException{
        GoogleSearch.address = args[0];
        try{
            url = defaultAddress + URLEncoder.encode(args[0], "UTF-8");
            System.out.println(url);
            URL myURL = new URL(url);
            InputStream in = myURL.openStream();
            URLConnection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
            DataInputStream DataIn = new DataInputStream(new BufferedInputStream(in));
            while((out = DataIn.readLine())!= null){
                System.out.println(out);
            }
            
        }catch(UnsupportedEncodingException e1){
            System.out.println("Encoding err");
        }catch(IOException e2){
            System.out.println("IO Exception");
        }
        
    }
   
}
