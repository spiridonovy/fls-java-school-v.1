public class Main {
    public static void main(String[] args){
        Array array = new Array(20);
        int[] subArray = {1, 12, 7};
        array.printArray();
        array.shellSort();
        array.printArray();
        System.out.println("Maximum element in array = " + array.max());
        System.out.println("Minimum element in array = " + array.min());
        array.reverseArray();
        array.printArray();
        System.out.println("Sum of all elements = " + array.sumElements());
        System.out.println("All even numbers in array: " + array.allEven());
        System.out.println("All odd numbers in array: " + array.allOdd());
        System.out.println(array.isSubarrayInArray(subArray));
        array.countElements();
    }
}
