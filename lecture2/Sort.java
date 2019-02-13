public class Sort {
    public static void msort(int input[]){
        if (input.length <= 1) return;  //void check
        //dividing an array into two parts
        int [] left_half = left(input);
        int [] right_half = right(input);
        //recursively sort each of the parts
        msort(left_half);
        msort(right_half);
        //
        Merge.merge(input, left_half, right_half);

    }
    private static int[] left(int[] input){
        int left_s = input.length / 2;
        int [] result = new int[left_s];

        for (int i = 0; i < left_s; i++ ) {
            result[i] = input[i];
        }
        return result;
    }

    private static int[] right(int[] input){

        int size = input.length;
        int left_s = size / 2, right_s = size - left_s, k = 0;
        int [] result = new int[right_s];

        for (int i = left_s; i < size; i++ ) {
            result[k++] = input[i];
        }
        return result;
    }
}