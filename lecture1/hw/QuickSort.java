public class QuickSort {
    void quickSort(int [] array, int leftPtr, int rightPtr) {
        if (array.length < 2) return;
        if (leftPtr >= rightPtr) return;

        int pivot = array[leftPtr + (rightPtr - leftPtr)]; // в качестве опорного элемента - последний
        int i = leftPtr, j = rightPtr;

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }

        /* после разделения массива относительно опорного элемента
        нужно упорядочить его части */

        if (leftPtr < j)
            quickSort(array, leftPtr, j);
        if (rightPtr > i)
            quickSort(array, i, rightPtr);
    }
}
