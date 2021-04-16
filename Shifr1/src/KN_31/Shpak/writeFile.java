/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KN_31.Shpak;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @@author Shpak
 */

 public class writeFile{
     String path ="d:\\text.txt";
     
    /**
     * метод дописує у кінець файлу переданий текст, якщо файл не існує його буде створено
     * @param x містить текст який треба дописати
     */
    public void addToFile(String x){
        BufferedWriter out;
        try{
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path),"Cp1251"));           
            out.write(x);
            out.newLine();
            out.close();
            
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println("your messege added to: " + path);
    }
}
    

