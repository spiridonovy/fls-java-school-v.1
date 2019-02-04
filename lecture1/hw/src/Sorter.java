
public class Sorter {
    private int arr[];
    private int lengthArr;

    /**
     * Create Sorter using external array
     * @param arr
     */
    Sorter(int arr[]){
        this.arr = arr.clone();
        lengthArr = arr.length;
    }

    /**
     * Create Sorter and array using external length and range array's numbers
     * @param lengthArr
     * @param range
     */
    Sorter(int lengthArr, int range){
        this.arr = new int[lengthArr];
        for (int i = 0 ; i < lengthArr; i++){
            arr[i] = (int)(Math.random()*(range + 1));
        }
        this.lengthArr = lengthArr;
    }

    /**
     * Print Sorter's array
     */
    public void printArr(){
        for (int i: arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Shell sorting using Knut's sequence
     */
    public void ShellSort(){
        int left, right;
        int temp;
        int stepLength = getMaxGap();

        while (stepLength>0){
            for (right = stepLength; right < lengthArr; right++){
                temp = arr[right];
                left = right;

                while (left > stepLength - 1 && arr[left - stepLength] >= temp){
                    arr[left] = arr[left - stepLength];
                    left -= stepLength;
                }
                arr[left] = temp;
            }
            stepLength = getNextGap(stepLength);
        }
    }

    /**
     * Calculate max gap
     * @return
     */
    private int getMaxGap(){
        int stepLength = 1;
        while (stepLength <= lengthArr/3){
            stepLength = stepLength*3 + 1;
        }
        return stepLength;
    }

    /**
     * Calculate next smaller step
     * @param stepLength
     * @return
     */
    private int getNextGap(int stepLength){
        return (stepLength - 1) / 3;
    }
}
