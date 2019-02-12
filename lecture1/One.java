package com.homework.irina;

import java.util.Arrays;
import java.util.Collections;

public class One<git> {

    public static void main(String[] args) {
	// создаем массив
        Integer [] cats = new Integer [20];
                for (int i=0; i<cats.length; i++) {
                    //каждому элементу массива присваиваем случайное число
                    cats [i]=(int)(Math.random()*100);
                    System.out.println(cats [i]+" ");
                }
                System.out.println("\n Sorted:\n");
        //Сортируем массив по убыванию
        Arrays.sort(cats, Collections.reverseOrder());
        /*
        Выводим
        отсортированный
        массив
         */
        for (int i=0; i<cats.length; i++) {
            System.out.println(cats [i]);
        }
    }
}
   