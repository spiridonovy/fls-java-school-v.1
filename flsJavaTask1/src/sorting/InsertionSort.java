package sorting;

//Класс с реализацией сортировки вставкой.


public class InsertionSort {

    /*Алгоритм делит массив на две половины.
     * Левая - отсортированные элементы, правая - неотсортированные.
      * Алгоритм на каждой итерации берет элемент из правой части и вставляет в левую,
      * оставляя ее отсортированной.*/

    public static int[] insertionSort(int[] elements) {
        for (int i = 1; i < elements.length; i++) {
            int key = elements[i];
            int j = i - 1;
            while (j >= 0 && key < elements[j]) {
                elements[j + 1] = elements[j];
                j--;
            }
            elements[j + 1] = key;
        }
        return elements;
    }

}
