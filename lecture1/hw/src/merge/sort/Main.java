package merge.sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[15];
        for (int i = 0; i < array.length; i++)
            array[i] = ((int)(Math.random() * 100) - 50);
        System.out.println(Arrays.toString(array));
        Sort.Msort(array);
        System.out.println(Arrays.toString(array));
    }
}
