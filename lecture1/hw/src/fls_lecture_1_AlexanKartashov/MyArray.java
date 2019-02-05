package fls_lecture_1_AlexanKartashov;

import java.lang.Math;

public class MyArray {

    int array[]=new int[10];

    public MyArray(int length, int min, int max)
    {
        array = new int[length];
        for (int i=0;i<length;i++)
        {
            array[i]=min + (int) (Math.random() * max);
        }
    }

    public void PrintArray()
    {
        for (int element:array) {
            System.out.print(element+" ");
        }
        System.out.println();
    }
}
