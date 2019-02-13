package com.sorting;

import java.util.HashMap;

public class ArrayOperations {

    private int [] array;

    public ArrayOperations(int[] inputArray)
    {
        this.array = inputArray;
    }

    public int findMaxElementInArray() {
        int maxElem = array[0];

        for (int i = 1; i < array.length; i++) {
            if (maxElem < array[i]) maxElem = array[i];
        }
        return maxElem;
    }

    public int findMinElementInArray() {
        int minElem = array[0];

        for (int i = 1; i < array.length; i++) {
            if (minElem > array[i]) minElem = array[i];
        }
        return minElem;
    }

    public int[] getEvenElements() {
        int[] resultArr = new int[array.length];
        int counter = 0;
        for (int element : array) {
            if (element % 2 != 0) {
                resultArr[counter] = element;
                counter++;
            }

        }
        return resultArr;
    }

    public int[] getOddElements() {
        int[] resultArr = new int[array.length];
        int counter = 0;
        for (int element : array) {
            if (element % 2 == 0) {
                resultArr[counter] = element;
                counter++;
            }

        }
        return resultArr;
    }
    public int getSumOfElements()
    {
        int sum = 0;
        for (int element: array) {
            sum+=element;
        }
        return sum;
    }

    public int[] revert() {
        int length = array.length;
        int [] resultArr = new int[length];
        for (int i=0;i <length;i++)
        {
            resultArr[length-1-i] = array[i];
        }
        return resultArr;
    }
    public boolean isArrayContainsSubArray(int [] subArray) {

        int counter = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (counter == subArray.length - 1)
                return true;

            if (array[i] == subArray[counter])
            {
                counter++;
                continue;
            }

            if (array[i] != subArray[counter])
            {
                counter = 0;
            }
        }
        return false;
    }

    public HashMap<Integer, Integer> outputCountOfElements() {
        HashMap<Integer, Integer> countOfElements = new HashMap<>();

        for (int element : array) {
            if ( countOfElements.containsKey(element)) countOfElements.put(element, countOfElements.get(element)+1);
            else countOfElements.put(element,1);
        }

        return countOfElements;
    }
    public int[] sort() {
        int maxElement = findMaxElementInArray() + 1;
        int[] tempC = new int[maxElement];
        int[] resultArray = new int[array.length];

        for (int i = 0; i < maxElement; i++) {
            tempC[i] = 0;
        }
        for (int i = 0; i < array.length; i++)
        {
            tempC[array[i]]++;
        }
        int tempKey = 0;
        for(int i = 0; i < maxElement;i++)
        {
            if (tempC[i]!=0) {
                for (int j = 0; j < tempC[i]; j++) {
                    resultArray[tempKey] = i;
                    tempKey++;
                }
            }
        }
        return resultArray;

    }
}
