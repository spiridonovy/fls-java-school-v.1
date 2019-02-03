package fls_lecture_1_alpinx;


public class Main {
    public static void main(String[] args) {

        int[] array = generateArray(20,-100,100);
        ConsoleViewer.print("Initial array:");
        ConsoleViewer.print(array);
        int[] sortedArray=new Sort().mergeSort(array);
        ConsoleViewer.print("Sorted array:");
        ConsoleViewer.print(sortedArray);

    }
    public static int[] generateArray(int length,int min ,int max){//generate random int array from min to max
        int[] array = new int[length];
        for (var iter =0; iter<length; iter++)
        {
           array[iter]=min + (int)(Math.random() * ((max - min) + 1));
        }
        return array;
    }
}
