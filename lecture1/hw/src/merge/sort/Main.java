package merge.sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[15];
        for (int i = 0; i < array.length; i++)				//fill random array
            array[i] = ((int)(Math.random() * 100) - 50);	//[-50, 50]
        System.out.println("in:  " + Arrays.toString(array));
        Sort.Msort(array);
        System.out.println("out: " + Arrays.toString(array));
    }
}
