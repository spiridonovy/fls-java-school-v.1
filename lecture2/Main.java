package lecture2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[15];
        for (int i = 0; i < array.length; i++)
            array[i] = ((int)(Math.random() * 100) - 50);
        System.out.println("in:  " + Arrays.toString(array));
        Sort.msort(array);
        System.out.println("out: " + Arrays.toString(array));

        System.out.println("min: " + Massif.min(array));
        System.out.println("max: " + Massif.max(array));
        System.out.println("sum: " + Massif.sum(array));

        int[] tmp = {3, 12}, input = {1, 2, 3, 1, 3};
        System.out.println("search: " + Massif.search(input, tmp));
        System.out.println("reverse: " + Arrays.toString(Massif.reverse(array)));
        System.out.println("counter: " + Massif.counter(input));
    }
}
