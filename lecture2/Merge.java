public class Merge {
    public static void merge(int[] result, int[] left, int[] right) {
        int leftInd = 0,  rightInd = 0;     //indexes for answer array

        for (int i = 0; i < result.length; i++){
            //the passage of the left and right array with alternate comparison
            if (rightInd >= right.length || (leftInd < left.length && left[leftInd] <= right[rightInd]))
                result[i] = left[leftInd++];
            else
                result[i] = right[rightInd++];
        }
    }
}