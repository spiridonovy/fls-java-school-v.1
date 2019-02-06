package com.selection_sort;

import static com.selection_sort.SelectionSort.selectionSort;

public class Main {

    public static void main(String[] args) {
        System.out.println("SelectionSort Algorithm");

        //declared integer array called numbers
        int[] numbers = {10,5,3,7,2};
        selectionSort(numbers);
        printArray(numbers);
    }

    public static void printArray(int[] theArray){

        //print method
        for(int i=0; i<theArray.length; i++){

            System.out.println(theArray[i]);
        }
    }
}

