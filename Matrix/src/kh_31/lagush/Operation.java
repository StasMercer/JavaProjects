/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kh_31.lagush;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Mercer
 */
public class Operation {
    
    private String path_1 = "";
    private String path_2 = "";
    private int roz_1 = 0;
    private int roz_2 = 0;
    private int roz_3 = 0;
    private int roz_4 = 0;
    private float[][] matrix;
    private float[][] matrix2;
    
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    /**
     * метод вимагає від користувача ввести необхідні данні для подальшої роботи
     * якщо данні не коректні то метод не завершиться поки вони не стануть коректими
     * 
     * @throws IOException 
     */
    public void getPath() throws IOException{
        boolean b = true;
        String inpt ="";
        System.out.println("Введіть шлях до ваших файлів");
        
        while (b){
        System.out.println("Шлях до першого:");
        inpt = stdin.readLine();
        File f_1 = new File(inpt);
        if (f_1.isFile()){
            System.out.println("Добре");
            path_1 = f_1.getAbsolutePath();
            b = false;
        }else{
            System.out.println("Помилка файлу");
        }
        }
        
        b = true;
        while(b){
        System.out.println("Шлях до 2 файлу:");
        inpt = stdin.readLine();
        File f_2 = new File(inpt);
        if (f_2.isFile()){
            System.out.println("Чудово");
             path_2 = f_2.getAbsolutePath();
             b = false;
        }else{
            System.out.println("Помилка файлу");
        }
        }
         
      
        
        
    }
    
    /**
     * метод додає дві матриці однакового розміру
     * @return повертає значення false яке завершує програму
     */
    public boolean getSum(){
       float[][] matrez = new float[roz_1][roz_2];
       if (roz_1 != roz_3 || roz_2 != roz_4){
           System.out.println("Фігова розмірність");
           return false;  
       }
        System.out.println("Додавати можна матриці тільки однакової розмірності.");
        System.out.println("Ваш результат:");
        for (int i = 0; i < roz_1; i++){
                    
                    for (int j = 0; j < roz_2; j++){
                        matrez[i][j] = matrix[i][j] + matrix2[i][j]; 
                        
                        System.out.print(matrez[i][j]+" ");
                    }
                    System.out.println();
                }
        return false;
        
    }
    /**
     * метод множить  дві матриці однакового розміру
     * @return повертає значення false яке завершує програму
     */
    public boolean getMult(){
        
        if (roz_1 != roz_4){
           System.out.println("Фігова розмірність");
           return false;  
       }
        
        int m = roz_1;
        int n = roz_4;
        int o = roz_3;
        
        float[][] matrez = new float[roz_1][roz_4];
        
        System.out.println("Ваш результат:");
        int j = 0;
        for (int i = 0; i < m; i++){
                    for (j = 0; j < n; j++){
                        matrez[i][j] = 0;
                        for (int k = 0; k < o; k++){
                            matrez[i][j] += matrix[i][k] * matrix2[k][j]; 
                        } 
                        
                        System.out.print(matrez[i][j]+" ");
                    }
                    System.out.println();
                }
        return false;
        
        
    }
    
      /**
     * метод зчитує з файлів матриці
     * 
     */
      public void printFile() throws FileNotFoundException, UnsupportedEncodingException, IOException{
       BufferedReader  in = null, in2 = null;
       String s = "";
       int k = 0;
       
       
       try {
        try {
            //кожен раз файл зчитується заново тому видно всі зміни
           in = new BufferedReader(new InputStreamReader(new FileInputStream(path_1),"Cp1251"));
           in2 = new BufferedReader(new InputStreamReader(new FileInputStream(path_2),"Cp1251"));
           
             while (in.ready()){
                 String[] tmp = in.readLine().split(" ");
                 this.roz_2 = tmp.length;
                 this.roz_1++;
             }
             
              while (in2.ready()){
                 String[] tmp = in2.readLine().split(" ");
                 this.roz_4 = tmp.length;
                 this.roz_3++;
             }
              
            
            
            
            
            System.out.println("Розмірність 1-ої матриці:" + roz_1 + " " + roz_2);
            System.out.println("Розмірність 2-ої матриці:" + roz_3 + " " + roz_4);
            
            matrix = new float[roz_1][roz_2];
            matrix2 = new float[roz_3][roz_4];
            
            in = new BufferedReader(new InputStreamReader(new FileInputStream(path_1),"Cp1251"));
            in2 = new BufferedReader(new InputStreamReader(new FileInputStream(path_2),"Cp1251"));
            
            while (in.ready()){
                
                for (int i = 0; i < roz_1; i++){
                    s = in.readLine();
                    String[] arr = s.split(" ");
                    k = 0;
                    for (int j = 0; j < roz_2; j++){
                        matrix[i][j] = Float.parseFloat(arr[k]);
                        k++;
                        
                    }
                    
                }
                
            }
            
            
            while (in2.ready()){
                
                for (int i = 0; i < roz_3; i++){
                    s = in2.readLine();
                    String[] arr = s.split(" ");
                    k = 0;
                    for (int j = 0; j < roz_4; j++){
                        matrix2[i][j] = Float.parseFloat(arr[k]);
                        k++;
                        
                    }
                }
                
            }
            
           
           
        } catch (IOException | NullPointerException e) {
            System.err.println(e.getMessage());
            System.out.println("тут.");
        }
        finally{
            in.close();
            in2.close();
        }
        
        
       
      
       }catch(ArrayIndexOutOfBoundsException e){
           System.out.println("Шото не то.");
       }
        
        
    }
}
