/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kn_31.Mercer;

/**
 *
 * @author Mercer
 */
public class Random {
      
      /**
       * 
       * @param a початковий діапазон
       * @param b кінцевий діапазон
       * @return  повертає випадкове число 
       */
      public int getRndNum(int a, int b){
          int random_number1 = a + (int) (Math.random() * b); // Генерация 1-го числа
          return random_number1;
      }
      
      
}
