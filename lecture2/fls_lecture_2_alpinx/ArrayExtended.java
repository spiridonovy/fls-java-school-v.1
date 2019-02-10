package fls_lecture_2_alpinx;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayExtended {
    private int[] array;

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public ArrayExtended mergeSort() {
        int[] buf1 = Arrays.copyOf(array, array.length);    //copy in order not to affect the source array
        int[] buf2 = new int[array.length];                 //buffer for sorting
        var result = new ArrayExtended();
        result.setArray(mergeSortRecursive(buf1, buf2, 0, array.length));
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

    public int getMin() {
        return this.mergeSort().getArray()[0];
    }

    public int getMax() {
        return this.mergeSort().getArray()[array.length - 1];
    }

    public boolean isOdd(int number) {
        if (number % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public int[] getOdd() {
        var oddCount = 0;
        for (var item : array) {
            if (isOdd(item)) {
                oddCount++;
            }
        }
        var oddArray = new int[oddCount];
        var count = 0;
        for (var item : array) {
            if (isOdd(item)) {
                oddArray[count] = item;
                count++;
            }
        }
        return oddArray;
    }

    public int[] getEven() {
        var evenCount = 0;
        for (var item : array) {
            if (!isOdd(item)) {
                evenCount++;
            }
        }
        var evenArray = new int[evenCount];
        var count = 0;
        for (var item : array) {
            if (!isOdd(item)) {
                evenArray[count] = item;
                count++;
            }
        }
        return evenArray;
    }

    public int getSum(){
        var sum = 0;
        for (var item:array) {
            sum+=item;
        }
        return sum;
    }
    public boolean search(int[] subArray){
        if (subArray.length == 0 && subArray.length > array.length) {
            return false;
        }
        int limit = array.length - subArray.length;
        next:
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j < subArray.length; j++) {
                if (subArray[j] != array[i+j]) {
                    continue next;//continue from next label
                }
            }
            return true; // Sub array found
        }
        return false;// Return default value false
    }
    public int[] mirror(){
        var mirrorArr = new int[array.length];
        for (var i=0;i<=array.length-1;i++){
            mirrorArr[i]=array[array.length-1-i];
        }
        return mirrorArr;
    }
    public Map<Integer, Integer> getElementsCount(){
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (var number : array) {
            if (!countMap.containsKey(number)) {
                countMap.put(number, 1);                //Create new
            } else {                                    //Add to existing key
                Integer count = countMap.get(number);
                count = count + 1;
                countMap.put(number, count);
            }
        }
        return countMap;
    }
}
