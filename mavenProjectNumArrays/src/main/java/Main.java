import java.util.Arrays;
import java.util.Random;

import ArrayOperations.ArrayOperations;

public class Main {
    public static void main(String[] args) {
        /*int n = 100;
        int MaxRand = 1000;
        Random random = new Random();
        int array[] =  new int[n];

        for (int i = 0; i < n; i++){
            array[i] = random.nextInt(MaxRand);
        }


        ArrayOperations.quickSort(array);*/
        boolean isSubArray = false;
        int arr[] = {1, 2 ,3};
        int mas[] = {-1, 0, 3, 2, 3, 4};
        try {
            isSubArray = ArrayOperations.subArraySearch(mas, arr);
            System.out.println(Arrays.toString(ArrayOperations.getReverseArray(mas)));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println(Arrays.toString(mas));
        System.out.println(Arrays.toString(arr));
        System.out.println(isSubArray);

        int arsen[] = {1,1,1,2,2,3,3,3,3,3};
        int qtymas[][] = new int[2][3];
        try {
            //qtymas = ArrayOperations.getQuantityOfEachArrayElement(arsen);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println(Arrays.toString(qtymas[0]));
        System.out.println(Arrays.toString(qtymas[1]));
    }
}