

public class Hello {
  /*
   * 1. Сигнатура метода 2. Комментарии 3. Объявление переменных 4. Условные
   * выражения 5. Циклы
   */
  public static void main(String[] args) {              // entry point
      int[] array = new int[15];
      for (int i = 0; i < array.length; i++) {                         //заполняем массив рандомными значениями
          array[i] = (int) (Math.random() * Integer.MAX_VALUE);
      }

      view(array);
      sort(array);
  }

    public static void view(int[] a) {                                     //вывод массива
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void sort(int[] arg) {                                   //сортировка массива слиянием
        int step = 1;                                                      //шаг разбиения
        int[] temp = new int[arg.length];                                  //временный массив
        while(step < arg.length) {
            int i = 0, l = 0;
            int m = l + step;                                               //середина сортируемого участка
            int r = l + step *2;                                            //правая граница сортируемого участка

            do {
                m = m < arg.length ? m : arg.length;                        //сортируемый участок не выходит за границы последовательности
                r = r < arg.length ? r : arg.length;
                int i1 = l, i2 = m;                                         //индексы сравниваемых элементов
                for (; i1 < m && i2 < r;) {                                 //пока i1 не дошел до середины и i2 не дошел до конца
                    if (arg[i1] < arg[i2])
                        temp[i++] = arg[i1++];
                    else
                        temp[i++] = arg[i2++];
                }

                while (i1 < m)                                              //заполняем оставшиеся элементы сортируемых участков
                    temp[i++] = arg[i1++];
                while (i2 < r)
                    temp[i++] = arg[i2++];

                l += step*2;                                                //перемещаемся на следующий участок сортировки
                m += step*2;
                r += step*2;
            } while (l < arg.length);

            for (int j = 0; j < arg.length; j++)                            //переносим сформированный массив обратно в исходный
                arg[j] = temp[j];

            step *= 2;                                                      //увеличиваем в 2 раза шаг разбиения

            view(arg);                                                      //визуализируем текущий вариант массива для наглядности
        }
    }
}