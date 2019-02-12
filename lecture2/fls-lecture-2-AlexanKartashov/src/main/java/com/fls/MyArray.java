package com.fls;

import java.util.HashMap;
import java.lang.Math;

public class MyArray {

    int array[]=new int[10];
    int length;

    public MyArray(int newLength, int min, int max)
    {
        length = newLength;
        array = new int[length];
        for (int i=0;i<length;i++)
        {
            array[i]=min + (int) (Math.random() * max);
        }
    }

    /*
    Sort elements of array via Shaker sorting
     */
    public void ShakerSort()
    {
        for (int i=0;i<(array.length/2);i++)
        {
            boolean SwapCheck = false;
            for (int j=i; j<(array.length-i-1); j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j]= array[j + 1];
                    array[j+ 1] = tmp;
                }
            }
            for (int j = array.length - 2 - i; j > i; j--) {
                if (array[j] < array[j-1]) {
                    int tmp = array[j];
                    array[j]=array[j-1];
                    array[j-1]=tmp;
                    SwapCheck = true;
                }
            }
            if(!SwapCheck) break;
        }
    }

    /*
    Print all elements of array
     */
    public void PrintArray()
    {
        for (int element:array) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    /*
    Return min element
     */
    public int GetMinElement()
    {
        int min = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    /*
    Return max element
     */
    public int GetMaxElement()
    {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /*
    Print all odd elements
     */
    public void PrintOddElements()
    {
        System.out.print("Odd elements: ");
        for (int value : array) {
            if (value%2==1) {
                System.out.print(value+" ");
            }
        }
        System.out.println();;
    }

    /*
    Print all even elements
     */
    public void PrintEvenElements()
    {
        System.out.print("Even elements: ");
        for (int value : array) {
            if (value%2==0) {
                System.out.print(value+" ");
            }
        }
        System.out.println();;
    }

    /*
    Return sum of elements
     */
    public int GetSumOfElements()
    {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    /*
    Revert elements of array
     */
    public void InvertArray()
    {
        int invertArray[] = new int[length];
        for (int i=0;i<length; i++) {
            invertArray[i] = array[length-i-1];
        }
        array = invertArray;
    }

    /*
    Print count for every element
     */
    public void PrintCountOfElements()
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int value : array) {
            Integer count = map.get(value);
            map.put(value, count == null ? 1 : count + 1);
        }
        for (int key: map.keySet()) {
            System.out.println("Value: "+key+" Count:"+map.get(key));
        }
    }
}