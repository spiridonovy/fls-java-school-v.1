package com.fls.hw2;

import java.util.ArrayList;
import java.util.HashMap;

public class Arrays {

    // Recursive quick sorting of Integereger array
    public static void qSort(Integer[] array, Integer low, Integer high) {
        Integer i = low;
        Integer j = high;
        Integer x = array[low + (high - low) / 2];
        do {
            while(array[i] < x) ++i;
            while(array[j] > x) --j;
            if (i <= j) {
                Integer temp = array[i];
                array[i++] = array[j];
                array[j--] = temp;
            }
        } while(i <= j);
        if (low < j) qSort(array, low, j);
        if (i < high) qSort(array, i, high);
    }

    // Getting the minimum array element
    public static Integer getMin(Integer[] array) {
        Integer min = Integer.MAX_VALUE;
        for (Integer value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    // Getting the maximum array element
    public static Integer getMax(Integer[] array) {
        Integer max = Integer.MIN_VALUE;
        for (Integer value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    // Getting even elements of the array
    public static Integer[] getEvenElems(Integer[] array) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (Integer value : array) {
            if (value % 2 == 0) {
                list.add(value);
            }
        }
        return list.toArray(new Integer[list.size()]);
    }

    // Getting odd elements of the array
    public static Integer[] getOddElems(Integer[] array) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (Integer value : array) {
            if (value % 2 != 0) {
                list.add(value);
            }
        }
        return list.toArray(new Integer[list.size()]);
    }

    // Getting the sum of array elements
    public static Integer getSum(Integer[] array) {
        Integer sum = 0;
        for (Integer value : array) {
            sum += value;
        }
        return sum;
    }

    // Check if the array contains a specific subarray
    public static boolean isContainsSubarray(Integer[] array, Integer []subarray) {
        if (subarray.length > array.length) {
            return false;
        }

        boolean isContainsSubarray = false;
        for (Integer i = 0; i < array.length - subarray.length + 1; i++) {
            if (array[i] == subarray[0]) {
                isContainsSubarray = true;
                for (Integer j = 1; j < subarray.length; j++) {
                    if (array[++i] != subarray[j]) {
                        isContainsSubarray = false;
                        break;
                    }
                }
                if (isContainsSubarray) {
                    return true;
                } else {
                    i--;
                }
            }
        }
        return false;
    }

    // Reverse the order of the array elements
    public static void reverse(Integer[] array) {
        for (Integer i = 0; i < array.length / 2; i++) {
            Integer temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    // Count the number of all elements of the array
    public static HashMap<Integer, Integer> getValuesMap(Integer[] array) {
        HashMap<Integer, Integer> valuesMap = new HashMap<Integer, Integer>();
        for (Integer value : array) {
            Integer count = valuesMap.get(value);
            valuesMap.put(value, count == null ? 1 : count + 1);
        }
        return valuesMap;
    }
}
