package com.sorting;

public class Sorter {
    // Recursive quick sorting of integer array
    public static void qSort(int[] array, int low, int high) {
        int i = low;
        int j = high;
        int x = array[low + (high - low) / 2];
        do {
            while(array[i] < x) ++i;
            while(array[j] > x) --j;
            if(i <= j) {
                int temp = array[i];
                array[i++] = array[j];
                array[j--] = temp;
            }
        } while(i <= j);
        if (low < j) qSort(array, low, j);
        if (i < high) qSort(array, i, high);
    }
}
