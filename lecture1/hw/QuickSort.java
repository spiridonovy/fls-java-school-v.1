import java.util.Vector;

public class QuickSort {

    private Vector<Integer> array=new Vector<Integer>();

    public QuickSort()
    {
        array.setSize(0);
    }
    public  QuickSort(Vector array)
    {
        this.array=array;
    }

    public Vector getArray() {
        return array;
    }

    public void setArray(Vector array) {
        this.array = array;
    }

    //array printing method
    public void printArray()
    {
        for (int element:array) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    //quick sort method
    public  void quickSort()
    {
        int startIndex=0, endIndex=array.size()-1;
        Sort(startIndex,endIndex);
    }

    //recursive method for quick sorting
    private void Sort(int start,int end)
    {
        //if the length of the array is 0, then complete the execution
        if(array.size()==0)
            return;

        //if there is nothing else to divide, then complete the execution
        if(start>=end)
            return;

        //choose the supporting element
        int averageIndex=start+(end-start)/2;
        int supportingElement=array.elementAt(averageIndex);
        int temporaryStart=start,temporaryEnd=end;

        //we will divide into subarrays which are less and more than the average element, respectively
        while (temporaryStart<=temporaryEnd)
        {
            while (array.elementAt(temporaryStart)<supportingElement)
            {
                temporaryStart++;
            }

            while (array.elementAt(temporaryEnd)>supportingElement)
            {
                temporaryEnd--;
            }

            //swap two items not in their heaps
            if(temporaryStart<=temporaryEnd)
            {
                int temporary=array.elementAt(temporaryStart);
                array.set(temporaryStart,array.elementAt(temporaryEnd));
                array.set(temporaryEnd,temporary);
                temporaryStart++;
                temporaryEnd--;
            }
        }

        //recursion call to sort left and right, respectively
        if(start<temporaryEnd)
            Sort(start,temporaryEnd);

        if(end>temporaryStart)
            Sort(temporaryStart,end);

    }
}
