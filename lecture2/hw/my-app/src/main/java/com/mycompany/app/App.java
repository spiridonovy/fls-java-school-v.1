package com.mycompany.app;

import com.sorting.ArrayOperations;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        int[] inputArray = {1, 2, 3, 4, 5, 3, 3, 2, 5};

        ArrayOperations operations = new ArrayOperations(inputArray);
        //sorting
        int[] sortedArray = operations.sort();
        System.out.println("Sorted: ");
        for (int elem : sortedArray) {
            System.out.println(elem);
        }

        //Min & Max
        int minElem = operations.findMinElementInArray();
        int maxElem = operations.findMaxElementInArray();

        System.out.println("Min elem: " + minElem + ". Max elem: " + maxElem);

        //OddAndEven

        int[] odd = operations.getOddElements();
        int[] even = operations.getEvenElements();

        System.out.println("Odd: ");
        for (int elem : odd) {
            System.out.println(elem);
        }
        System.out.println("Even: ");
        for (int elem : even) {
            System.out.println(elem);
        }

        // Sum
        int sum = operations.getSumOfElements();

        System.out.println(sum);

        //SubArray
        int[] subArray = {2, 3, 4};
        boolean isContains = operations.isArrayContainsSubArray(subArray);

        System.out.println(isContains);

        //Revert

        int[] reverted = operations.revert();

        System.out.println("Reverted: ");
        for (int elem : reverted) {
            System.out.println(elem);
        }

        //CountOfElements

        HashMap<Integer, Integer> count = operations.outputCountOfElements();
        System.out.println("Count of elements.");
        System.out.println(count);

    }

}
