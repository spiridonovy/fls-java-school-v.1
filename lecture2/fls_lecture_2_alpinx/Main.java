package fls_lecture_2_alpinx;


public class Main {
    public static void main(String[] args) {

        var MyArray =new ArrayExtended();
        MyArray.setArray(generateArray(10,-10,10));
        //MyArray.setArray(new int[]{2,5,7,3,9,4});

        ConsoleViewer.print("Initial MyArray:");
        ConsoleViewer.print(MyArray.getArray());
        var SortedArray = MyArray.mergeSort();

        ConsoleViewer.print("1. Sorted MyArray:");
        ConsoleViewer.print(SortedArray.getArray());
        ConsoleViewer.print("2.1 Min Element of MyArray:");
        ConsoleViewer.print(MyArray.getMin());
        ConsoleViewer.print("2.2 Max Element of MyArray");
        ConsoleViewer.print(MyArray.getMax());
        ConsoleViewer.print("3.1 Get all odd elements:");
        ConsoleViewer.print(MyArray.getOdd());
        ConsoleViewer.print("3.2 Get all even elements:");
        ConsoleViewer.print(MyArray.getEven());
        ConsoleViewer.print("4. The sum of all elements in the array:");
        ConsoleViewer.print(MyArray.getSum());

        MyArray.setArray(new int[]{2,5,7,3,3,4,5});
        ConsoleViewer.print("Initial MyArray:");
        ConsoleViewer.print(MyArray.getArray());
        ConsoleViewer.print("5.1 Search for a sub-array(exist)");
        ConsoleViewer.print(MyArray.search(new int[]{5,7}));
        ConsoleViewer.print("5.2 Search for a sub-array(not exist)");
        ConsoleViewer.print(MyArray.search(new int[]{3,2}));
        ConsoleViewer.print("6. Mirror array:");
        ConsoleViewer.print(MyArray.mirror());
        ConsoleViewer.print("7. Count of each element:");
        ConsoleViewer.print(MyArray.getElementsCount());


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
