package fls_lecture_1_AlexanKartashov;

public class Main {

    public static void main(String[] args) {
        MyArray array = new MyArray(15,1,100);

        System.out.println("Old array:");
        array.PrintArray();

        array= Sorting.ShakerSort(array);

        System.out.println("New array:");
        array.PrintArray();
    }
}
