package com.homework.irina;

import java.util.Arrays;
import java.util.Collections;

public class Two {
    public static void main(String[] args) {
        // создаем массив
        Integer[] cats = new Integer[20];
        for (int i = 0; i < cats.length; i++) {
            //каждому элементу массива присваиваем случайное число
            cats[i] = (int) (Math.random() * 100);
            System.out.println(cats[i] + " ");
        }
        System.out.println("\n Sorted:\n");
        //Сортируем массив по убыванию
        Arrays.sort(cats, Collections.reverseOrder());
        /*
        Выводим
        отсортированный
        массив
         */
        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i]);
        }
        //Получение минимального/максимального элемента
        int min = (int) Collections.min(Arrays.asList(cats));
        int max = (int) Collections.max(Arrays.asList(cats));
        System.out.println("MIN:" + min);
        System.out.println("MAX:" + max);

        //Получение всех нечетных/четных элементов

        System.out.println("Четные:");
        for (int i=0; i < cats.length; i++) {
            if (cats[i] % 2 == 0) {
                System.out.println(cats[i]);
            }
        }

        System.out.println("Нечетные:");
        for (int i=0; i < cats.length; i++) {
            if (cats[i] % 2 != 0) {
                System.out.println(cats[i]);
            }
        }
        //Сумма всех элементов массива

        int t = 0;
        for (int i = 0; i < cats.length; i++) {
            t += cats[i];
        }
        System.out.println("Сумма элементов массива=" + t);

        

    }
}
