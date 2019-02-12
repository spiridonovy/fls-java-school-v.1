public class ArrayOperations {

    public static int[] insertionSort(int[] elements) {
        for (int i = 1; i < elements.length; i++) {
            int key = elements[i];
            int j = i - 1;
            while (j >= 0 && key < elements[j]) {
                elements[j + 1] = elements[j];
                j--;
            }
            elements[j + 1] = key;
        }
        return elements;
    }

    public static int getMinElement(int[] elements) {
        ArrayOperations arr = new ArrayOperations();
        int[] arr1;
        arr1 = arr.insertionSort(elements);
        int minElement = arr1[0];
        return minElement;
    }

    public static int getMaxElement(int[] elements) {
        ArrayOperations arr = new ArrayOperations();
        int[] arr1;
        arr1 = arr.insertionSort(elements);
        int minElement = arr1[arr1.length - 1];
        return minElement;
    }

    public static int[] getEvenElements(int[] elements) {

        int count = 0;
        for(int i = 0; i < elements.length; i++){
            if(elements[i] % 2 == 0)
                count++;
        }

        int[] arr1 = new int[count];

        for(int i = 0, j = 0; j < count; i++) {
            if((elements[i] % 2) == 0) {
                arr1[j] = elements[i];
                j++;
            }
        }
        return arr1;
    }

    public static int[] getNotEvenElements(int[] elements) {
        int count = 0;
        for(int i = 0; i < elements.length; i++){
            if((elements[i] % 2 - 1) == 0)
                count++;
        }

        int[] arr1 = new int[count];

        for(int i = 0, j = 0; j < count; i++) {
            if((elements[i] % 2 - 1) == 0) {
                arr1[j] = elements[i];
                j++;
            }
        }
        return arr1;
    }

    public static int getSumOfElements(int[] elements) {
        int sum = 0;
        for(int i = 0; i < elements.length; i++)
            sum = sum + elements[i];
        return sum;
    }

    public static int[] inverseArray(int[] elements) {
        int[] invertedArray = new int[elements.length];
        int i;
        int j;
        for(i = elements.length - 1, j = 0; i > -1; i--, j++)
            invertedArray[j] = elements[i];

        return invertedArray;
    }

}
