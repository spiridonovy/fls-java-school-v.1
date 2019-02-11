package classArray;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Array {

    private int size;
    private int[] array;

    Array (int size) {
        this.size = size;
        array = new int[size];
    }

    public int getSize() {
        return this.size;
    }

    public int getElement(int index) {
        return array[index];
    }

    public void setElement(int index, int value) {
        this.array[index] = value;
    }

    public void sortArray(Array array, int leftPtr, int rightPtr) {
        if (array.getSize() < 2) return;
        if (leftPtr >= rightPtr) return;


        int pivot = array.getElement(leftPtr + (rightPtr - leftPtr));
        int i = leftPtr, j = rightPtr;

        while (i <= j) {
            while (array.getElement(i) < pivot) {
                i++;
            }
            while (array.getElement(j) > pivot) {
                j--;
            }
            if (i <= j) {
                int tmp = array.getElement(i);
                array.setElement(i, array.getElement(j));
                array.setElement(j, tmp);
                i++;
                j--;
            }
        }
        if (leftPtr < j)
            sortArray(array, leftPtr, j);
        if (rightPtr > i)
            sortArray(array, i, rightPtr);
    }

    public int getMax() {
        int max = this.getElement(0);
        for (int i = 1; i < this.getSize(); i++) {
            if (this.getElement(i) > max)
                max = this.getElement(i);
        }
        return max;
    }

    public int getMin() {
        int min = this.getElement(0);
        for (int i = 1; i < this.getSize(); i++) {
            if (this.getElement(i) < min)
                min = this.getElement(i);
        }
        return min;
    }

    public Array getEven() {
        Vector<Integer> tmp = new Vector();
        int k = 0;
        for (int i = 0; i<array.length; i++) {
            if (array[i] % 2 == 0) {
                tmp.add(k, array[i]);
                k++;
            }
        }
        Array arrayEven = new Array(tmp.size());
        for (int i = 0; i < tmp.size(); i++)
            arrayEven.setElement(i, tmp.get(i));
        return arrayEven;
    }

    public Array getOdd() {
        Vector<Integer> tmp = new Vector();
        int k = 0;
        for (int i = 0; i<array.length; i++) {
            if (array[i] % 2 != 0) {
                tmp.add(k, array[i]);
                k++;
            }
        }
        Array arrayOdd = new Array(tmp.size());
        for (int i = 0; i < tmp.size(); i++)
            arrayOdd.setElement(i, tmp.get(i));
        return arrayOdd;
    }

    public int getSum() {
        int sum = 0;
        for (int i = 0; i < 10; i++)
            sum += this.getElement(i);
        return sum;
    }

    public boolean findSubarray(Array subarray) {
        boolean flag = false;
        for (int i = 0; i < this.getSize(); i++) {
            if (this.getElement(i) ==  subarray.getElement(0)) {
                int k = 1, t = i + 1;
                flag = true;
                while ((k < subarray.getSize()) && (t < this.getSize())) {
                    if (this.getElement(t) != subarray.getElement(k)) {
                        flag = false;
                        break;
                    }
                    k++;
                    t++;
                }
                if (k < subarray.getSize()) flag = false;
                if (flag == true) break;
            }
        }
        return flag;
    }

    public void reverseArray() {
        Array tmp = new Array(this.getSize());

        for (int i = 0; i < this.getSize(); i++)
            tmp.setElement(this.getSize() - 1 - i, this.getElement(i));

        for (int i = 0; i < this.getSize(); i++)
            this.setElement(i, tmp.getElement(i));
    }

    public Map countElements() {
        Map<Integer, Integer> tmp = new HashMap();
        for (int i=0; i<this.getSize(); i++)
            if (tmp.containsKey(array[i]))
                tmp.put(this.getElement(i), tmp.get(array[i]) + 1);
            else
                tmp.put(this.getElement(i), 1);
        return tmp;
    }
}
