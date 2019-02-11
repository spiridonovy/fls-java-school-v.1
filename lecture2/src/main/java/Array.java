import java.util.HashMap;
import java.util.Map;

public class Array {

    private int[] array;
    private int size;

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Array() {
        size=0;
        array=new int[size];
    }

    public  Array(int size) {
        this.size=size;
        array=new int[this.size];
    }

    public void add(int value){
        size++;
        int[] tempArray=array;
        array=new int[size];
        System.arraycopy(tempArray, 0, array, 0, size - 1);
        array[size-1]=value;
    }
    public void set(int index, int value) {
        array[index]=value;
    }

    //array printing method
    public void printArray() {
        for (int element:array) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    //quick sort method
    public  void sort() {
        int startIndex=0, endIndex=size-1;
        quickSort(startIndex,endIndex);
    }

    //recursive method for quick sorting
    private void quickSort(int start,int end) {
        //if the length of the array is 0, then complete the execution
        if(size==0)
            return;

        //if there is nothing else to divide, then complete the execution
        if(start>=end)
            return;

        //choose the supporting element
        int averageIndex=start+(end-start)/2;
        int supportingElement=array[averageIndex];
        int temporaryStart=start,temporaryEnd=end;

        //we will divide into subarrays which are less and more than the average element, respectively
        while (temporaryStart<=temporaryEnd) {
            while (array[temporaryStart]<supportingElement) {
                temporaryStart++;
            }

            while (array[temporaryEnd]>supportingElement) {
                temporaryEnd--;
            }

            //swap two items not in their heaps
            if(temporaryStart<=temporaryEnd) {
                int temporary=array[temporaryStart];
                array[temporaryStart]=array[temporaryEnd];
                array[temporaryEnd]=temporary;
                temporaryStart++;
                temporaryEnd--;
            }
        }

        //recursion call to sort left and right, respectively
        if(start<temporaryEnd)
            quickSort(start,temporaryEnd);

        if(end>temporaryStart)
            quickSort(temporaryStart,end);

    }

    //maximum value search method in array
    public int max() {
        Array temporary=new Array(size);
        System.arraycopy(array, 0, temporary.array, 0, size);
        temporary.sort();
        return temporary.array[temporary.size-1];
    }

    //method for finding the minimum value in the array
    public int min() {
        Array temporary=new Array(size);
        System.arraycopy(array, 0, temporary.array, 0, size);
        temporary.sort();
        return temporary.array[0];
    }

    //method of obtaining all the even elements of the array
    public Array evenNumbers(){
        Array temporary=new Array();
        for (int i = 0; i <size ; i++)
            if (array[i] % 2 == 0)
                temporary.add(array[i]);
        return temporary;
    }

    //method of getting all odd elements of an array
    public Array oddNumbers(){
        Array temporary=new Array();
        for (int i = 0; i <size ; i++)
            if (array[i] % 2 != 0)
                temporary.add(array[i]);
        return temporary;
    }

    //method that summarizes all the elements of an array
    public int sum(){
        int sum=0;
        for (int i = 0; i < size; i++)
            sum+=array[i];
        return sum;
    }

    //method that counts the number of all elements of the array
    public Map<Integer, Integer> amountOfElement(){
        Map<Integer,Integer> temporary=new HashMap<Integer, Integer>();
        for (int i = 0; i <size ; i++) {
            if(temporary.containsKey(array[i]))
                temporary.put(array[i],temporary.get(array[i])+1);
            else
                temporary.put(array[i],1);
        }
        return temporary;
    }

    //a method that looks for a subarray in an array
    public boolean existenceOfSubarray(Array subarray)
    {
        boolean exist=true;
        Array temporary=new Array(size);
        System.arraycopy(array, 0, temporary.array, 0, size);
        temporary.sort();
        for (int i = 0; i < subarray.size; i++) {
            if(!temporary.searchBinary(0,size-1,subarray.array[i])) {
                exist = false;
                break;
            }
        }
        return exist;
    }

    //binary search method that is needed for searching for elements in an array
    private boolean searchBinary ( int left, int right, int key) {
        int average = 0;
        while (true) {
            average = (left + right) / 2;

            if (key < array[average])
                right = average - 1;
            else if (key > array[average])
                left = average + 1;
            else
                return true;

            if (left > right)
                return false;
        }
    }

    //method that flips the array
    public void reverse() {
        int start=0,end=size-1;
        while(start<end){
            int temp=array[start];
            array[start]=array[end];
            array[end]=temp;
            start++;
            end--;
        }
    }
}
