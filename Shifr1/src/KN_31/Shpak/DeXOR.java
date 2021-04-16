/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KN_31.Shpak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Shpak
 */
public class DeXOR {
    private String openMsg ="";
    private String closedMsg ="";
    private String Key ="";
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
   

    /**
     * метод вимагає у користувача ввести зашифроване повідомлення
     * @throws java.io.IOException
     */
    public void setClosedMsg() throws IOException {
        String localMsg = "";
        while (localMsg.length() == 0){
        System.out.println("Input your secret message");
        localMsg = stdin.readLine();
        }
        this.closedMsg = localMsg;
        
    }
    
    
    /**
     * метод вимагає у користувача ввести таємний ключ
     * @throws IOException 
     */
    public void setKey() throws IOException {
        String localKey = "";
        
        while (localKey.trim().length() == 0){
            System.out.println("Input a Key");
            localKey = stdin.readLine();
        }
        this.Key = localKey;
    }
    /**
     * 
     * @param message приймає зашифроване повідомлення
     * @param Key приймає таємний ключ
     * @throws UnsupportedEncodingException 
     */
    public void decrypt(String message,String Key) throws UnsupportedEncodingException{
        String s = "";
        int j = 0;
        int k = 0;
        String[] temp = message.split(" ");
        int[] arr = new int [temp.length];
        byte[] txt = new byte[arr.length];
        
        for (int i = temp.length-1; i !=-1; i--){
           arr[k] = Integer.parseInt(temp[i]);
           k++;
           
        }
        
        for (int i =0; i<txt.length;i++){
            txt[i] = (byte) arr[i];
        }
        
                
                
                
		byte[] output = new byte[arr.length];
		byte[] Skey = Key.getBytes("UTF-8");

		for (int i = 0; i < arr.length; i++) {
			output[i] =  (byte) (txt[i] ^ Skey[j]);
                        j++;
                        if (j == Key.length()) j = 0;
		}

		
	String answer = new String(output, "UTF-8");
        this.openMsg = answer; 
        
    }
    
    /**
     * метод виводить на екран розшифроване повідомлення
     * @throws UnsupportedEncodingException 
     */
     public void getOpenMsg() throws UnsupportedEncodingException {
        decrypt(closedMsg,Key);
        System.out.println("Decrypted message : "+openMsg);
    }
    
            
}



