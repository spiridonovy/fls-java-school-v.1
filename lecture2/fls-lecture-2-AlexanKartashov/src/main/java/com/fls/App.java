package com.fls;

public class App
{
    public static void main( String[] args )
    {
        MyArray array = new MyArray(20,1,10);
        System.out.println("Original array:");
        array.PrintArray();

        System.out.println();
        array.ShakerSort();
        System.out.println("Sorted array:");
        array.PrintArray();

        System.out.println();
        System.out.println("Min Element: "+array.GetMinElement());

        System.out.println();
        System.out.println("Max Element: "+array.GetMaxElement());

        System.out.println();
        array.PrintEvenElements();

        System.out.println();
        array.PrintOddElements();

        System.out.println();
        array.PrintCountOfElements();

        System.out.println();
        array.InvertArray();
        System.out.println("Inverted array:");
        array.PrintArray();
    }
}
