package com.fls.school;

public class Test {
    public static void main(String[] args) {
        ListApp test = new ListApp(new int[]{3, 2, 7, 4, 90, 42, 13});

        System.out.println("Length of the array: " + test.getArray().length);
        System.out.println("Max element: " + test.max());
        System.out.println("Min element: " + test.min());

        int[] odd = test.oddElements();
        int[] even = test.evenElements();

        System.out.println("Odd elements: ");
        for (int i : odd)
            System.out.print(i + " ");
        System.out.println("\nEven elements: ");
        for (int i : even)
            System.out.print(i + " ");
        System.out.println("\n");

        System.out.println("Sum of the elements: " + test.sum());
        System.out.println("Reversing the array:");
        test.view();
        test.reverse();
        test.view();

        System.out.println("Sorting array");
        test.sort();
        test.view();

        System.out.println("\nIf {2, 4, 42} is a subset of the array");
        int[] tArr = {2, 4, 42};
        boolean res = test.contains(tArr);
        System.out.print("Array {2, 4, 42} ");
        if (res)
            System.out.println("is a subset of the array");
        else
            System.out.println("is not a subset of the array");

        System.out.println("\nIf {2, 300, 42} is a subset of the array");
        int[] tArr2 = {2, 300, 42};
        boolean res2 = test.contains(tArr2);
        System.out.print("Array {2, 300, 42} ");
        if (res2)
            System.out.println("is a subset of the array");
        else
            System.out.println("is not a subset of the array");

        System.out.println("Testing a function for counting frequency of elements");
        ListApp test2 = new ListApp(new int[]{1, 5 , 2, 3, 3, 4, 3, 4, 5, 2, 5, 5, 5});
        test2.view();
        System.out.println("Frequency of elements: " + test2.countFreq());
    }
}
