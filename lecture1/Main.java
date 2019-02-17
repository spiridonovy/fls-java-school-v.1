package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] unsortedArray = {21, 14, 43, 18, 37, 56, 19, 13};
        System.out.println(Arrays.toString(unsortedArray));
        choiceSort(unsortedArray);
    }
    //Сортировка Выбором
    public static void choiceSort(int[] arrayToSort) {

        //проходим по массиву
        //найти минмимальный массив
        //меняем местами первый и минимальный элемент

        //повторяем пока не пройдем по всему массиву
        int indexMin;
        for (int index = 0; index < arrayToSort.length - 1; index++){
            indexMin = index;
            for (int indexToScan = index; indexToScan < arrayToSort.length; indexToScan++) {
                if (arrayToSort[indexMin] > arrayToSort[indexToScan]) {
                    indexMin = indexToScan;
                }
            }   /*нахождение минимального элемента*/

            int temp = arrayToSort[index];
            arrayToSort[index] = arrayToSort[indexMin];
            arrayToSort[indexMin] = temp;
        }
        System.out.println(Arrays.toString(arrayToSort));
    }
}