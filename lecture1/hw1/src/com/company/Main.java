package com.company;

import com.sorting.CountingSorter;

public class Main {

    public static void main(String[] args) {
        CountingSorter sorter = new CountingSorter();
        int [] inputArr = {1, 3512, 10, 35, 3512, 25, 10};
        int [] sortedArr = sorter.sort(inputArr);

        for (int element: sortedArr
             ) {
            System.out.println(element);
        }
    }
}
