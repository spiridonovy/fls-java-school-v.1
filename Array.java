import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Array {
    private int[] array;
    private int SizeArray;
    private Random rnd = new Random(System.currentTimeMillis());
    public Array(int SizeArray){
        this.SizeArray = SizeArray;
        array = new int[this.SizeArray];
        for (int i=0; i<this.SizeArray; i++){
            array[i] = rnd.nextInt(317);
        }
    }
    public void setArray(){
        //array = new int[this.SizeArray];
        for (int i=0; i<this.SizeArray; i++) {
            array[i] = rnd.nextInt(317);
        }
    }
    public int[] getArray(){
        return array;
    }
    public void setSizeArray(int AnotherSize){
        SizeArray = AnotherSize;
    }
    public int getSizeArray(){
        return SizeArray;
    }
    public void printArray(){
        for (int i=0; i<this.SizeArray; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Выбор длин промежутков (increment), на которых
     * будут находиться сортируемые элементы исходного
     * массива на каждом шаге алгоритма.
     * Сравнение и сортировка между собой значений,
     * стоящих один от другого на расстоянии increment
     * После этого процедура повторяется для increment / 2,
     * а завершается сортировка Шелла сортировкой вставками.
     */
    public void shellSort () {
        int increment = this.array.length / 2;
        while (increment >= 1) {
            for (int startIndex = 0; startIndex < increment; startIndex++) {
                insertionSort(startIndex, increment);
            }
            increment = increment / 2;
        }
    }

    private void insertionSort (int startIndex, int increment) {
        for (int i = startIndex; i < this.array.length - 1; i = i + increment) {
            for (int j = Math.min(i + increment, this.array.length - 1); j - increment >= 0; j = j - increment) {
                if (this.array[j - increment] > this.array[j]) {
                    int tmp = this.array[j];
                    this.array[j] = this.array[j - increment];
                    this.array[j - increment] = tmp;
                } else {
                    break;
                }
            }
        }
    }

    public int max(){
        int maxElement = -1000000;
        for (int i=0; i<this.getSizeArray(); i++){
            if (array[i]>maxElement){
                maxElement=array[i];
            }
        }
        return maxElement;
    }

    public int min(){
        int minElement = 10000000;
        for (int i=0; i<this.getSizeArray(); i++){
            if (array[i]<minElement){
                minElement=array[i];
            }
        }
        return minElement;
    }

    public int sumElements(){
        int sum = 0;
        for (int i=0; i<this.getSizeArray(); i++){
            sum += array[i];
        }
        return sum;
    }

    public void reverseArray(){
        for (int i=0; i<this.getSizeArray()/2; i++){
            int tmp = array[this.getSizeArray() -1 - i];
            array[this.getSizeArray() -1 - i] = array[i];
            array[i] = tmp;
        }
    }

    public List<Integer> allEven(){
        List<Integer> arrayEven = new ArrayList<Integer>();
        for (int i=0; i<this.getSizeArray(); i++){
            if (array[i] % 2 == 0){
                arrayEven.add(array[i]);
            }
        }
        return arrayEven;
    }

    public List<Integer> allOdd(){
        List<Integer> arrayOdd = new ArrayList<Integer>();
        for (int i=0; i<this.getSizeArray(); i++){
            if (array[i] % 2 != 0){
                arrayOdd.add(array[i]);
            }
        }
        return arrayOdd;
    }

    public boolean isSubarrayInArray(int[] subArray){
        int index = -1;
        for (int i=0; i<this.getSizeArray() - subArray.length + 1; i++){
            index = i;
            for (int j=0; j<subArray.length -1; j++){
                if (array[i + j] != subArray[j]) {
                   index = -1;
                   break;
                }
            }
        }
        if (index >= 0){
            return true;
        }
        return false;
    }

    public void countElements(){
        int[] counter = new int[this.max() + 1];
        for (int i=0; i<counter.length; i++){
            counter[i] = 0;
        }
        for (int i=0; i<this.getSizeArray();i++){
            counter[array[i]]++;
        }
        for (int i=0; i<counter.length; i++){
            if (counter[i] != 0){
                System.out.print(i + "-" + counter[i] + " ");
            }
        }
    }
}
