package com.sorting;

import com.sorting.Sorter;

public class Main {

    public static void main(String[] args) {
        int array[] = {-1, 2, 5 ,4, -10};

        for (int elem: array) {
            System.out.print(Integer.toString(elem) + ' ');
        }

        Sorter.qSort(array, 0, array.length - 1);
        System.out.println();

        for (int elem: array) {
            System.out.print(Integer.toString(elem) + ' ');
        }
    }
}
