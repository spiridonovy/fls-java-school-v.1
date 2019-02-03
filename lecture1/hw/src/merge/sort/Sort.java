package merge.sort;

import java.util.Arrays;

public class Sort {
    public static void Msort(int input[]){
        if (input.length <= 1) return;
        int [] left = Left(input);
        int [] right = Right(input);
        //int [] result = new int[input.length];
        Msort(left);
        Msort(right);

        Merge.Merge(input, left, right);

        //System.out.println(Arrays.toString(left));
        //System.out.println(Arrays.toString(right));
        //System.out.println(Arrays.toString(input));

    }
    public static int[] Left(int[] input){
        int left_s = input.length / 2;
        int [] result = new int[left_s];

        for (int i = 0; i < left_s; i++ ) {
            result[i] = input[i];
        }
        return result;
    }

    public static int[] Right(int[] input){

        int size = input.length;
        int left_s = size / 2, right_s = size - left_s, k = 0;
        int [] result = new int[right_s];

        for (int i = left_s; i < size; i++ ) {
            result[k++] = input[i];
        }
        return result;
    }
}
