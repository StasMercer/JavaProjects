/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kh_31.lagush;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mercer
 */
public class Matrix {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Operation oper = new Operation();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in,"Cp1251"));
        boolean b = true;
        String key = "";
        while (b){
            System.out.println("1 - Додавання");
            System.out.println("2 - Множення");
            key = stdin.readLine();
            switch(key){
                case"1": {
                    System.out.println("Додавати можна матриці тільки однакової розмірності.");
                    oper.getPath();
                    oper.printFile();
                    b = oper.getSum();
                    break;
                }
                
                case "2":{
                    System.out.println("Переконайтесь що к-сть рядків 1-ої матриці\n"
                            + "дорівнює кількості стовбців 2-ої.");
                    oper.getPath();
                    oper.printFile();
                    b = oper.getMult();
                    break;
                }
                
                default:{
                    System.out.println("Там тільки 1 і 2. Навіщо натискати щось інше?");
                }
            }
        }
        
    }
    
}
