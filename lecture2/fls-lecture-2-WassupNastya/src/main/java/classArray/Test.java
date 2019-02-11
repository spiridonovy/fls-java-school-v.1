package classArray;
import java.util.Map;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random rand = new Random();
        Array array = new Array(10);

        for (int i = 0; i < array.getSize(); i++)
            array.setElement(i, rand.nextInt(9));

        System.out.print("Unsorted array: ");
        for (int i = 0; i < array.getSize(); i++)
            System.out.print(array.getElement(i) + " ");

        System.out.print("\nSorted array: ");

        array.sortArray(array, 0,9);
        for (int i = 0; i < array.getSize(); i++)
            System.out.print(array.getElement(i) + " ");

        System.out.print("\nMax = " + array.getMax());
        System.out.print("\nMin = " + array.getMin());

        Array arrayEven = array.getEven();
        System.out.print("\nArray with even elements: ");
        for (int i = 0; i < arrayEven.getSize(); i++)
            System.out.print(arrayEven.getElement(i) + " ");

        Array arrayOdd = array.getOdd();
        System.out.print("\nArray with odd elements: ");
        for (int i = 0; i < arrayOdd.getSize(); i++)
            System.out.print(arrayOdd.getElement(i) + " ");

        System.out.print("\nSum of all elements: " + array.getSum());

        Array subarray = new Array(2);
        subarray.setElement(0,1);
        subarray.setElement(1,2);
        System.out.print("\nArray includes {1,2} : " + array.findSubarray(subarray));

        System.out.print("\nReverse array: ");
        array.reverseArray();
        for (int i = 0; i < array.getSize(); i++)
            System.out.print(array.getElement(i) + " ");

        System.out.println("\nCount elements:");
        Map<Integer, Integer> hashMap = array.countElements();
        for (Map.Entry<Integer, Integer> pair: hashMap.entrySet()) {
            System.out.print(pair.getKey() + ": ");
            System.out.println(pair.getValue());
        }
    }
}
