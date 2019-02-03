package mainPack;

import initializeTestArray.TestArray;
import sorting.InsertionSort;

public class Main {

    public static void main(String[] args) {

        //инициализация тестового массива
        TestArray test = new TestArray();
        int[] array = test.createRandomArray();

        //инициализация класса с сортировкой
        InsertionSort sort = new InsertionSort();

        //использование алгоритма сортировки и вывод результатов
        for(int i = 0; i < array.length; i++)
            System.out.println(sort.insertionSort(array)[i]);
    }
}
