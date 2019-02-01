package com.sorting;

public class CountingSorter {

    private int findMaxElementInArray(int[] array) {
        int maxElem = array[0];

        for (int i = 1; i < array.length; i++)
        {
            if (maxElem < array[i]) maxElem = array[i];
        }
        return maxElem;
    }
    public int[] sort(int[] inputArr) {
        int maxElement = findMaxElementInArray(inputArr) + 1;
        int[] tempC = new int[maxElement];
        int[] resultArray = new int[inputArr.length];

        for (int i = 0; i < maxElement; i++) {
            tempC[i] = 0;
        }
        for (int i = 0; i < inputArr.length; i++)
        {
            tempC[inputArr[i]]++;
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
