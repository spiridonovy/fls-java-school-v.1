package fls_lecture_1_AlexanKartashov;

import java.lang.Math;

// Class for generating and printing array's elements
public class MyArray {

    int array[]=new int[10];

    // Constructor for generating random numbers for array
    public MyArray(int length, int min, int max)
    {
        array = new int[length];
        for (int i=0;i<length;i++)
        {
            array[i]=min + (int) (Math.random() * max);
        }
    }

    // Print elements of array on one line
    public void PrintArray()
    {
        for (int element:array) {
            System.out.print(element+" ");
        }
        System.out.println();
    }
}
