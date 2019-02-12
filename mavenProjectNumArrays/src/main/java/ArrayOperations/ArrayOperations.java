package ArrayOperations;
import java.lang.Exception;
import java.util.Arrays;

public class ArrayOperations {

    public static int getMaxElement(int array[]) throws Exception {
        if (array == null) throw new Exception("The Array is not Defined.");
        int max = array[0];
        for (int i = 1; i < array.length - 1; i++){
            if (max < array[i]){
                max = array[i];
            }
        }
        return max;
    }

    public static int getMinElement(int array[]) throws Exception {
        if (array == null) throw new Exception("The Array is not Defined.");
        int min = array[0];
        for (int i = 1; i < array.length - 1; i++){
            if (min > array[i]){
                min = array[i];
            }
        }
        return min;
    }

    private static int getEvenNumbersCount(int array[]){
        int evenNumbersCount = 0;
        for (int i = 0; i < array.length - 1; i++){
            if (array[i] % 2 == 0){
                evenNumbersCount++;
            }
        }
        return evenNumbersCount;
    }

    public static int[] getAllOddNumbers(int array[]) throws Exception {
        if (array == null) throw new Exception("The Array is not Defined.");
        int[] oddNumbers = new int[array.length - 1 - getEvenNumbersCount(array)];
        int j = 0;
        for (int i = 0; i < array.length - 1; i++){
            if (array[i] % 2 == 1){
                oddNumbers[j++] = array[i];
            }
        }
        return oddNumbers;
    }

    public static int[] getAllEvenNumbers(int array[]) throws Exception {
        if (array == null) throw new Exception("The Array is not Defined.");
        int[] evenNumbers = new int[getEvenNumbersCount(array)];
        int j = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 == 0){
                evenNumbers[j++] = array[i];
            }
        }
        return evenNumbers;
    }

    public static int getSumAllNumbers(int array[]) throws Exception {
        if (array == null) throw new Exception("The Array is not Defined.");
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }
    public static boolean subArraySearch(int array[], int probableSubArray[]) throws Exception{
        if (array == null) throw new Exception("The Array is not Defined.");
        if (probableSubArray == null) throw new Exception("The Probable SubArray is not Defined.");
        if (array.length < probableSubArray.length) throw new Exception("Array cannot be less than a SubArray");

        boolean isSubArray = false;
        for (int i = 0; i <= array.length - probableSubArray.length; i++) {
            int j;
            for (j = 0; j < probableSubArray.length; j++)
                if (array[i + j] != probableSubArray[j])
                    break;
            if (j == probableSubArray.length)
                isSubArray = true;
        }
        return isSubArray;
    }
    public static int[] getReverseArray(int array[]) throws Exception{
        if (array == null) throw new Exception("The Array is not Defined.");
        int[] reverseArray = new int[array.length];
        System.arraycopy(array,0, reverseArray ,0, array.length);
        for (int i = 0; i < array.length; i++){
            reverseArray[i] = array[array.length - 1 - i];
        }
        return reverseArray;
    }

    private static int getCountOfDifElementsSortedArray(int array[]) throws Exception {
        if (array == null) throw new Exception("The Array is not Defined.");
        int countOfDifElements = 1;
        for (int i = 0; i < array.length; ) {
            int j = i;
            do {
                j++;
                if (j == array.length) return countOfDifElements;
            } while (array[i] == array[j]);
            i = j;
            countOfDifElements++;
        }
        return countOfDifElements;
    }
    /*
    public static int[][] getQuantityOfEachArrayElement(int array[]) throws Exception{
        if (array == null) throw new Exception("The Array is not Defined.");
        int countDifElements = 0;
        quickSort(array);
        countDifElements = getCountOfDifElementsSortedArray(array);
        int[][] arrElementsQuantity = new int[2][countDifElements];
        for (int i = 0, j = 0; i < countDifElements || j < array.length; i++){
            arrElementsQuantity[0][i] = array[j + 1];
            arrElementsQuantity[1][i] = 0;
            int k = j;
            do {
                j++;
                arrElementsQuantity[1][i]++;
                if (k == array.length) break;
            } while (array[k] == array[j]);
            j = k;
        }
        return arrElementsQuantity;
    }
*/
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
