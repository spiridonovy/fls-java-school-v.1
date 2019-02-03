package initializeTestArray;

import java.util.Random;

//Класс для инициализации тестового массива из рандомных интов.

public class TestArray {

    public static int[] createRandomArray() {
        int[] testArray = new int[10];
        Random rnd = new Random();

        for (int i = 0; i < testArray.length; i++)
            testArray[i] = rnd.nextInt();

        return testArray;
    }

}
