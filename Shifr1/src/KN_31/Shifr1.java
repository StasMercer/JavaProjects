/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KN_31;

import KN_31.Shpak.DeXOR;
import KN_31.Shpak.XOR;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author Shpak
 */
public class Shifr1 {

   
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        XOR crypter = new XOR();
        DeXOR decrypter = new DeXOR();
        boolean b = true;
        String key, key_2 = null, key_3 = null;
        
        
        
        while (b){
            System.out.println("What do yo want?");
            System.out.println("1 - encrypt message");
            System.out.println("2 - decrypt message");
            System.out.println("0 - exit");
            System.out.println("Choose the variant");
            key = stdin.readLine();
            switch (key){
                case "1":{
                    crypter.setMessage();
                    crypter.setKey();
                    crypter.encodedMsg();
                    
                    System.out.println("Enter 0 to return");
                    while(!"0".equals(key_2)){
                        key_2 = stdin.readLine();
                    }
                    break;
                }
                
                case "2":{
                    
                    decrypter.setClosedMsg();
                    decrypter.setKey();
                    decrypter.getOpenMsg();
                    
                    System.out.println("Enter 0 to return");
                    while(!"0".equals(key_3)){
                        key_3 = stdin.readLine();
                    }
                    break;
                  
                }
                
                case "0":{
                    System.out.println("paka");
                    b = false;
                }
                
                default:{
                    System.out.println("Invalid Variant");
                }
            }
        }
        
        
        
        
        
    }
    
}
