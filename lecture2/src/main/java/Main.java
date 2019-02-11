import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Array arr=new Array(10);
        Array arr1=new Array();
        for (int i = 0; i <10 ; i++) {
            arr.set(i,rand.nextInt(99));
        }

        System.out.print("Array : ");
        arr.printArray();

        System.out.println("Maximum array elements : " + arr.max());
        System.out.println("Minimal array elements : " + arr.min());

        arr1=arr.evenNumbers();
        System.out.print("Subarray of even numbers : ");
        arr1.printArray();

        System.out.print("Subarray of odd numbers : ");
        arr1=arr.oddNumbers();
        arr1.printArray();

        System.out.print("The sum of all elements of the array : ");
        System.out.println(arr.sum());

        Map<Integer,Integer> map=arr.amountOfElement();
        System.out.println("Frequencies of each element of the array :");
        for(Integer i : map.keySet()){
            System.out.println(i + " - " + map.get(i));
        }

        System.out.println("Frequencies of each element of the array : ");
        arr1.add(2);
        arr1.printArray();
        System.out.println("Exists?   " + arr.existenceOfSubarray(arr1));

        System.out.print("Inverted array : ");
        arr.reverse();
        arr.printArray();

        System.out.print("Sorted array : ");
        arr.sort();
        arr.printArray();
    }

}