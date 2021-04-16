/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kn_31.Mercer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 *
 * @author Mercer
 */
public class Zagatka {
    private ArrayList<String> arr = new ArrayList();
    int i =0;
    int j =0;
    /**
     * метод записує у колекцію загадки з файла
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     * @throws IOException 
     */
    public void printFile() throws FileNotFoundException, UnsupportedEncodingException, IOException{
        BufferedReader in;
       String s = "", otv = "";
        try {
            //кожен раз файл зчитується заново тому видно всі зміни
           in = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\zagatki.txt"),"Cp1251"));

            while (in.ready()){
                
                s = in.readLine();
                this.arr.add(s);
                
                
            }
            
            //System.out.println(otv);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally{

        }



    }
    /**
     * 
     * @param el приймає індекс загадки, або відгадки яку потрібно повернути
     * @return
     * @throws InterruptedException 
     */
    public String getZag(String el) throws InterruptedException{
        int k = 0;

        k = Integer.parseInt(el);
            
        return arr.get(k);
   
    }
    
    
}
