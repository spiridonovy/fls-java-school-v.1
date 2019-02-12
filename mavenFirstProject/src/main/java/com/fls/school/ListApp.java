package com.fls.school;

import java.util.HashMap;

public class ListApp {
    private int[] array;        //inner int array

    //sorting function
    public void sort() {
        int step = 1;                                                      //шаг разбиения
        int[] temp = new int[array.length];                                  //временный массив
        while (step < array.length) {
            int i = 0, l = 0;
            int m = l + step;                                               //середина сортируемого участка
            int r = l + step * 2;                                            //правая граница сортируемого участка

            do {
                m = m < array.length ? m : array.length;                        //сортируемый участок не выходит за границы последовательности
                r = r < array.length ? r : array.length;
                int i1 = l, i2 = m;                                         //индексы сравниваемых элементов
                for (; i1 < m && i2 < r; ) {                                 //пока i1 не дошел до середины и i2 не дошел до конца
                    if (array[i1] < array[i2])
                        temp[i++] = array[i1++];
                    else
                        temp[i++] = array[i2++];
                }

                while (i1 < m)                                              //заполняем оставшиеся элементы сортируемых участков
                    temp[i++] = array[i1++];
                while (i2 < r)
                    temp[i++] = array[i2++];

                l += step * 2;                                                //перемещаемся на следующий участок сортировки
                m += step * 2;
                r += step * 2;
            } while (l < array.length);

            for (int j = 0; j < array.length; j++)                            //переносим сформированный массив обратно в исходный
                array[j] = temp[j];

            step *= 2;                                                        //увеличиваем в 2 раза шаг разбиения
        }
    }

    //return the maximum element
    public int max() {
        ListApp copy = new ListApp(array);
        copy.sort();
        return copy.getArray()[copy.getArray().length - 1];     //returns the maximum of the sorted array
    }

    //returns the minimal element
    public int min() {
        ListApp copy = new ListApp(array);
        copy.sort();
        return copy.getArray()[0];      //return the minimum of the sorted array
    }

    //return an array with odd elements
    public int[] oddElements() {
        int size = 0;                           //size of a result array
        int[] temp = new int[array.length];     //temp array
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {            //if the element is odd
                temp[size] = array[i];          //add the element to the temp array
                size++;                         //increasing the size
            }
        }
        int[] result = new int[size];           //creating the result array
        for (int i = 0; i < result.length; i++)
            result[i] = temp[i];                //migrating elements to the result array
        return result;
    }

    //return an array with even elements
    public int[] evenElements() {
        int size = 0;                       //size of a result array
        int[] temp = new int[array.length]; //temp array
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {        //if the element is even
                temp[size] = array[i];      //add the element to the temp array
                size++;                     //increasing the size
            }
        }
        int[] result = new int[size];       //creating the result array
        for (int i = 0; i < result.length; i++)
            result[i] = temp[i];            //migrating elements to the result array
        return result;
    }

    //returns a sum of the elements
    public int sum() {
        int sum = 0;
        for (int i : array)
            sum += i;
        return sum;
    }

    //returns true, if array is a subset of the inner array
    public boolean contains(int[] arr) {
        int j;
        for (int i = 0; i < arr.length; i++) {
            for (j = 0; j < array.length; j++)
                if (arr[i] == array[j])
                    break;
            if (j == array.length)              //if the main loop was not broken,
                return false;                   //the second array is a subset of the inner array
        }
        return true;
    }

    //reverses the array
    public void reverse() {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++)
            copy[i] = array[array.length - i - 1];
        array = copy;

        System.out.println("Array was reversed.");
    }

    //counts frequency of the elements
    public String countFreq() {
        HashMap<Integer, Integer> result = new HashMap<>();     //hash map to save results
        for (int i = 0; i < array.length; i++) {
            if (!result.containsKey(array[i]))                  //if the map has not met the instance of this element
                result.put(array[i], 1);                        //put it
            else
                result.put(array[i], result.get(array[i]) + 1); //otherwise, increase the frequency
        }
        return result.toString();
    }

    //visualization
    public void view() {
        System.out.println("Current array:");
        for (int i : array)
            System.out.print(i + " ");
        System.out.println();
    }

    //getter for the array
    public int[] getArray() {
        return array;
    }

    //constructor
    public ListApp(int[] arr) {
        array = arr;
    }
}
