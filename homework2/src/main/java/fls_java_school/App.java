package fls_java_school;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Yuriy!" );

       int[] arr = new int[10];
       int[] requiredArr = {1,2,3};

        for(int i = 0; i < 10; i++) {
            arr[i] = (int)(Math.random() * (10 + 1));
        }

        ArrayUtils.printArr(arr);
        ArrayUtils.printArr(ArrayUtils.sortShell(arr));
        System.out.println("Max elem " + ArrayUtils.getMax(arr));
        System.out.println("Min elem " + ArrayUtils.getMin(arr));
        System.out.println("Sum elements " + ArrayUtils.getSum(arr));
        System.out.println("Contains? - " + ArrayUtils.contains(arr, requiredArr));
        ArrayUtils.printArr(ArrayUtils.getAllEven(arr));
        ArrayUtils.printArr(ArrayUtils.getAllOdd(arr));
        ArrayUtils.printArr(ArrayUtils.turnOver(arr));

        ArrayUtils.printCountAllElements(arr);


    }
}
