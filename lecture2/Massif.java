package lecture2;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Massif {
    public static int max(int[] input) {
        return Arrays.stream(input).max().getAsInt();
    }
    public static int min(int[] input) {
        return Arrays.stream(input).min().getAsInt();
    }
    public static int sum(int[] input) {
        return Arrays.stream(input).sum();
    }
    public static boolean search(int[] input, int[] tmp) {
        int counter = 0, i = 0, j = 0;

        while(j < tmp.length && i < input.length) {
            if (input[i] == tmp[j]){
                counter++;
                i++;
                j++;
                if (counter == tmp.length){
                    return true;
                }
             }
             else {
                 counter = 0;
                 i++;
                 j = 0;
             }

        }

        return false;
    }

    public static int[] reverse(int[] input) {
        int[] result = new int[input.length];
        for (int i = input.length - 1; i >= 0; i-- )
            result[input.length - 1 - i] = input[i];

        return result;
    }

    public static String counter(int[] input) {
        int countNumber = 1;
        Sort.msort(input);
        System.out.println(Arrays.toString(input));
        String result = "";
        for(int i = 1; i < input.length; i++){
            if (input[i] == input[i-1]){
                countNumber++;
                if (i == input.length - 1)
                    result = result + input[i - 1] + " - " + countNumber + " ";
            }
            else{
                result = result + input[i - 1] + " - " + countNumber + " ";
                countNumber = 1;
            }
        }
        return result;
    }
}
