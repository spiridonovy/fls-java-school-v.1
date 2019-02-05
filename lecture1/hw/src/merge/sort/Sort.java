package merge.sort;


public class Sort {
    public static void Msort(int input[]){
        if (input.length <= 1) return;  //void check
                                        //dividing an array into two parts
        int [] left = Left(input);
        int [] right = Right(input);
                                        //recursively sort each of the parts
        Msort(left);
        Msort(right);
                                        //merging
        Merge.Merge(input, left, right);

    }
    private static int[] Left(int[] input){
        int left_s = input.length / 2;	//left is first half of input array
        int [] result = new int[left_s];

        for (int i = 0; i < left_s; i++ ) {
            result[i] = input[i];
        }
        return result;
    }

    private static int[] Right(int[] input){

        int size = input.length;		//right is input array without first half
        int left_s = size / 2, right_s = size - left_s, k = 0;
        int [] result = new int[right_s];

        for (int i = left_s; i < size; i++ ) {
            result[k++] = input[i];
        }
        return result;
    }
}
