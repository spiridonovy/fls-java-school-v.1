package fls_lecture_1_AlexanKartashov;

public class Sorting
{
    // Shaker or Cocktail sorting of array (min element to right, max element to left)
    public static MyArray ShakerSort(MyArray array)
    {
      for (int i=0;i<(array.array.length/2);i++)
      {
          boolean SwapCheck = false;
          for (int j=i; j<(array.array.length-i-1); j++) {
              if (array.array[j] > array.array[j + 1]) {
                  int tmp = array.array[j];
                  array.array[j]= array.array[j + 1];
                  array.array[j+ 1] = tmp;
              }
          }
          for (int j = array.array.length - 2 - i; j > i; j--) {
              if (array.array[j] < array.array[j-1]) {
                  int tmp = array.array[j];
                  array.array[j]=array.array[j-1];
                  array.array[j-1]=tmp;
                  SwapCheck = true;
              }
          }
          if(!SwapCheck) break;
      }
      return array;
    }
}
