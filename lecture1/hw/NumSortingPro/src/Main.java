import java.util.Arrays;
import java.util.Random;

import SortPackage.QuickSort;

public class Main {
    public static void main(String[] args) {
        int n = 100;
        int MaxRand = 1000;
        Random random = new Random();
        int array[] =  new int[n];


        for (int i = 0; i < n; i++){
            array[i] = random.nextInt(MaxRand);
        }

        QuickSort.quickSort(array);

        System.out.println(Arrays.toString(array));
    }
}
