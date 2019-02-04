import java.util.Random;

public class Array {
    private int[] ArrayForSort;
    private int SizeArray;
    private Random rnd = new Random(System.currentTimeMillis());
    public Array(int SizeArray){
        this.SizeArray = SizeArray;
        ArrayForSort = new int[this.SizeArray];
        for (int i=0; i<this.SizeArray; i++){
            ArrayForSort[i] = -30+rnd.nextInt(171);
        }
    }
    public void setArrayForSort(){
        ArrayForSort = new int[this.SizeArray];
        for (int i=0; i<this.SizeArray; i++){
            ArrayForSort[i] = -30+rnd.nextInt(171);
        }
    }
    public int[] getArrayForSort(){
        return ArrayForSort;
    }
    public void setSizeArray(int AnotherSize){
        SizeArray = AnotherSize;
    }
    public int getSizeArray(){
        return SizeArray;
    }
    public void printArray(){
        for (int i=0; i<this.SizeArray; i++) {
            System.out.print(ArrayForSort[i] + " ");
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
    public void sheellSort () {
        int increment = this.ArrayForSort.length / 2;
        while (increment >= 1) {
            for (int startIndex = 0; startIndex < increment; startIndex++) {
                insertionSort(startIndex, increment);
            }
            increment = increment / 2;
        }
    }

    private void insertionSort (int startIndex, int increment) {
        for (int i = startIndex; i < this.ArrayForSort.length - 1; i = i + increment) {
            for (int j = Math.min(i + increment, this.ArrayForSort.length - 1); j - increment >= 0; j = j - increment) {
                if (this.ArrayForSort[j - increment] > this.ArrayForSort[j]) {
                    int tmp = this.ArrayForSort[j];
                    this.ArrayForSort[j] = this.ArrayForSort[j - increment];
                    this.ArrayForSort[j - increment] = tmp;
                } else {
                    break;
                }
            }
        }
    }
}
