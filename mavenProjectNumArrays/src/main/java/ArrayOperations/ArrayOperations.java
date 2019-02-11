package ArrayOperations;

public class ArrayOperations {
    public static void quickSort(int array[]) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int array[], int left, int right) {
        if (left >= right) {
            return;
        }
        int p = lomutoPartition(array, left, right);
        quickSort(array, left, p - 1);
        quickSort(array, p + 1, right);
    }

    private static int lomutoPartition(int array[], int left, int right) {
        int pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    private static void swap(int array[], int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
