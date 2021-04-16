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
public class XOR {
    
    private String message;
    private String key;
   
    /**
     *метод виводить на екран наше повідомлення
     */
    public void getMessage() {
        System.out.println(message);
    }

    /**
     * метод вимагає у користувача ввести повідомлення яке буде зашифровано
     * 
     * @throws java.io.IOException
     */
    public void setMessage() throws IOException {
        String localMsg = "";
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        while (localMsg.trim().length() == 0){
            System.out.println("Input a message");
            localMsg = stdin.readLine();
        }
        this.message = localMsg;
    }

    /**
     * метод виводить на екран введений користувачем ключ
     */
    public void getKey() {
       System.out.println(key);
    }

    /**
     * метод вимагає користувача ввести ключ по якому буде зашифровано повідомлення
     * 
     * @throws java.io.IOException
     */
    public void setKey() throws IOException{
        String localKey = "";
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        while (localKey.trim().length() == 0){
            System.out.println("Input a secret key");
            localKey = stdin.readLine();
        }
        this.key = localKey;
        
        
    }
    
    
     /**
      * 
      * @param message приймає введене користувачем повідомлення
      * @param key приймає введений користувачем ключ
      * @return повертає зашифроване повідомлення у вигляді цілочисельного масиву
     * @throws java.io.UnsupportedEncodingException
      * 
      */
    public int[] encrypt(String message, String key) throws UnsupportedEncodingException{
                
                byte[] txt = message.getBytes("UTF-8");
		byte[] Skey = key.getBytes("UTF-8");
		int[] output = new int[message.length()];
                int j = 0;
                
		for (int i = 0; i < txt.length; i++) {
			output[i] = (txt[i] ^ Skey[j]);
                        j++;
                        if (j == key.length()) j=0;
                        
		}
                
                
		return output;
                        
        
    }
    
    
     /**
      * метод опрацьовує зашифроване повідомлення та записує його у файл а також
      * виводить користувачу на екран
      * 
     * @throws java.io.UnsupportedEncodingException
      */
    public void encodedMsg() throws UnsupportedEncodingException{
       writeFile write = new writeFile();
       int arr[] = encrypt(message,key);

       String str = "";
       for (int i = arr.length-1; i !=-1; i--){
          str += arr[i] + " ";
       }
       write.addToFile(str);
       System.out.println("Yor secret message :\n"+str);
    }
    
}

    
    

