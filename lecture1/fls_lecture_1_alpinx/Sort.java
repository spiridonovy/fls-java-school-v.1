package fls_lecture_1_alpinx;
import java.util.Arrays;

public class Sort {

    public int[] mergeSort(int[] array){
        int[] buf1 = Arrays.copyOf(array, array.length);    //copy in order not to affect the source array
        int[] buf2 = new int[array.length];                 //buffer for sorting
        int[] result = mergeSortRecursive(buf1, buf2, 0, array.length);
        return result;
    }
    private int[] mergeSortRecursive(int[] buffer1, int[] buffer2,
                                 int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1; //end of splitting array
        }

        //sort left and right parts of array
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] left = mergeSortRecursive(buffer1, buffer2, startIndex, middle);
        int[] right = mergeSortRecursive(buffer1, buffer2, middle, endIndex);

        // Merge
        int indexLeft = startIndex;
        int indexRight = middle;
        int resultIndex = startIndex;
        int[] result = left == buffer1
                ? buffer2
                : buffer1;
        //merge until one part is over
        while (indexLeft < middle && indexRight < endIndex) {
            result[resultIndex++] = left[indexLeft] < right[indexRight]
                    ? left[indexLeft++]
                    : right[indexRight++];
        }
        //append the rest values
        while (indexLeft < middle) {
            result[resultIndex++] = left[indexLeft++];
        }
        while (indexRight < endIndex) {
            result[resultIndex++] = right[indexRight++];
        }
        return result;
    }
}
