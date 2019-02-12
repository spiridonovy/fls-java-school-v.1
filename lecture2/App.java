package com.fls.hw2;

import java.util.HashMap;

public class App 
{
    public static void main( String[] args ) {
        Integer[] array = {2, 5, 20, 20, -10, 0, 5, -9};
        Integer[] subarray = {20, -10, 0, 5};

        System.out.print("Source array - ");
        printArray(array);
        System.out.println("Min - " + Arrays.getMin(array));
        System.out.println("Max - " + Arrays.getMax(array));
        System.out.println("Sum - " + Arrays.getSum(array));
        System.out.print("Even values - ");
        printArray(Arrays.getEvenElems(array));
        System.out.print("Odd values - ");
        printArray(Arrays.getOddElems(array));
        System.out.println("Subarray? " + Arrays.isContainsSubarray(array, subarray));
        Arrays.reverse(array);
        System.out.print("Reversed array - ");
        printArray(array);
        Arrays.qSort(array, 0, array.length - 1);
        System.out.print("Sorted array - ");
        printArray(array);
        HashMap<Integer, Integer> valuesMap = Arrays.getValuesMap(array);
        System.out.print("Values count - ");
        for (Integer name: valuesMap.keySet()){
            String key = name.toString();
            String value = valuesMap.get(name).toString();
            System.out.print("(" + key + " - " + value + ")");
        }
    }

    public static void printArray(Integer[] array) {
        for (Integer value : array) {
            System.out.print('[' + Integer.toString(value) + ']');
        }
        System.out.println();
    }
}
