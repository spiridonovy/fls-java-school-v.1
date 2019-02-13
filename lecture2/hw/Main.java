package com.company;

public class Main {

    public static void main(String[] args) {

        int[] numbers = {10,5,3,7,2};

        selectionSort(numbers);
        printSelectionSort(numbers);
        minMaxArray(numbers);
        evenOddSum(numbers);
        sumArray(numbers);
        inverseArray(numbers);
    }

    public static void selectionSort(int[] list){

        int i, j, minValue, minIndex, temp = 0;

        for(i=0; i<list.length;i++){

            minValue = list[i];
            minIndex = i;

            for(j=i;j<list.length;j++){

                if(list[j]<minValue){

                    minValue=list[j];
                    minIndex = j;
                }
            }

            if(minValue < list[i]){

                temp = list[i];
                list[i] = list[minIndex];
                list[minIndex] = temp;
            }
        }
    }

    public static void printSelectionSort(int[] list){

        System.out.print("SelectionSort: ");

        for(int i=0; i<list.length; i++){

            System.out.print(list[i] + " ");
        }
    }

    public static void minMaxArray(int[] list){

        int max = list[0];
        int min = list[0];
        for(int i = 0; i != list.length; i ++){
            if(list[i] > max){
                max = list[i];
            }
            if(list[i] < min){
                min = list[i];
            }
        }
        System.out.println("\nMin element: " + min);
        System.out.println("Max element: " + max);
    }

    public static void evenOddSum(int[] list) {

        System.out.print("Even elements in array: ");
        for (int i = 0; i < list.length; i++) {
            if(list[i]%2 == 0){
                System.out.print(list[i] + " ");
            }
        }

        System.out.print("\nOdd elements in array: ");
        for (int i = 0; i < list.length; i++) {
            if(list[i]%2 != 0){
                System.out.print(list[i] + " ");
            }
        }
    }

    public static void sumArray (int[] list) {

        int total = 0;
        for (int i = 0; i < list.length; i++) {
            total += list[i];
        }
        System.out.println("\nSum elements in array: " + total);
    }

    public static void inverseArray(int[] list) {

        System.out.print("Reverse array: ");
        for(int i=list.length-1; i>=0; i--){
            System.out.print(list[i] + " ");
        }

    }

}



