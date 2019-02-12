package fls_java_school;

import java.util.HashMap;
import java.util.Map;

/**
 * Static tools for int arrays
 */

public class ArrayUtils {

    enum ArrayType {ODD, EVEN}

    /**
     * Shell's sorting using Knut's sequence
     * @param arr
     * @return sortedArr
     */

    public static int[] sortShell(int arr[] ){
        int[] sortedArr = arr.clone();
        int lengthArr = sortedArr.length;
        int left, right, temp;

        int stepLength = getMaxStep(lengthArr);

        while(stepLength > 0) {
            for(right = stepLength; right < lengthArr; right++){
                temp = sortedArr[right];
                left = right;

                while(left > stepLength - 1 && sortedArr[left - stepLength] >= temp) {
                    sortedArr[left] = sortedArr[left - stepLength];
                    left -= stepLength;
                }
                sortedArr[left] = temp;
            }
            stepLength = getNextStep(stepLength);
        }

        return sortedArr;
    }

    /**
     * Calculate max step
     * @param lengthArr
     * @return stepLength
     */
    private static int getMaxStep(int lengthArr) {
        int stepLength = 1;
        while(stepLength <= lengthArr / 3){
            stepLength = stepLength * 3 + 1;
        }

        return stepLength;
    }

    /**
     * Calculate next smaller step
     * @param stepLength
     * @return smallerStep
     */
    private static int getNextStep(int stepLength) {
        return (stepLength - 1) / 3;
    }

    /**
     * Passes the minimum element of the array
     * @param arr
     * @return min
     */
    public static int getMin(int arr[]){
        int min = arr[0];
        for(int i = 1; i < arr.length; i++){
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    /**
     * Passes the maximum element of array
     * @param arr
     * @return max
     */
    public static int getMax(int arr[]){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * Passes array with all even elements original array
     * @param arr
     * @return evenArr
     */
    public static int[] getAllEven(int arr[]){
        int[] evenArr = getAllEvenOrOdd(arr, ArrayType.EVEN);
        return evenArr;
    }

    /**
     * Passes array with all odd elements original array
     * @param arr
     * @return oddArr
     */
    public static int[] getAllOdd(int arr[]){
        int[] oddArr = getAllEvenOrOdd(arr, ArrayType.ODD);
        return oddArr;
    }

    /**
     * Passes array with all odd or even elements original array depending on <code>type</code>
     * @param arr
     * @param type
     * @return
     */
    private static int[] getAllEvenOrOdd(int arr[], ArrayType type){
        int[] arrTemp = new int[arr.length];
        int newLength = 0;

        for(int i = 1; i < arr.length; i++){
            if(isNeed(arr[i],type)){
                arrTemp[newLength] = arr[i];
                newLength++;
            }
        }

        int[] newArr = new int[newLength];
        for(int i = 0; i < newLength; i++){
            newArr[i] = arrTemp[i];
        }
        return newArr;
    }

    /**
     * Return that <code>x</code> is needed element depending on <code>type</code>
     * @param x
     * @param type
     * @return
     */
    private static boolean isNeed(int x, ArrayType type) {
        if (x % 2 == 0) {
            switch (type) {
                case EVEN:
                    return true;
                case ODD:
                    return false;
            }
        }
        switch (type) {
            case EVEN:
                return false;
            case ODD:
                return true;
            }
        return false;
    }

    /**
     * Return sum all elements array
     * @param arr
     * @return
     */
    public static long getSum(int arr[]){
        long sum = 0;
        for (int x:arr) {
            sum += x;
        }
        return sum;
    }

    /**
     * Checks that original array contains required array
     * @param originArr
     * @param requiredArr
     * @return
     */
    public static boolean contains(int originArr[], int requiredArr[]){
        int numberOfEqual = 0;
        boolean isContains = false;

        for(int x = 0;
            (originArr.length - x) >= requiredArr.length && x < originArr.length; x++){

            if (originArr[x] == requiredArr[0]){
                numberOfEqual++;

                for(int y = 1; y < requiredArr.length; y++){
                    if(originArr[x+y] == requiredArr[y]){
                        numberOfEqual++;
                    } else {
                        numberOfEqual = 0;
                        break;
                    }
                }

                if(numberOfEqual == requiredArr.length){
                    isContains = true;
                    break;
                }

            }
        }
        return isContains;
    }

    /**
     * Turn over original array
     * @param arr
     * @return
     */
    public static int[] turnOver(int arr[]){
        int[] turnedArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            turnedArr[i] = arr[arr.length - i - 1];
        }
        return turnedArr;
    }

    public static Map countAllElements(int arr[]){
        Map<Integer, Integer> countedElements = new HashMap();
        for(int x = 0; x < arr.length; x++){
            if (countedElements.containsKey(arr[x])){
                countedElements.put(arr[x],countedElements.get(arr[x])+1);
            } else {
                countedElements.put(arr[x],1);
            }
        }
        return countedElements;
    }

    public static void printCountAllElements(Map countedElements){

        System.out.print("Count each element " + countedElements.toString());
    }

    public static void printCountAllElements(int arr[]){
        printCountAllElements(countAllElements(arr));
    }

    public static void printArr(int arr[]) {
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
