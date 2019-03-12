package com.operations;

import java.util.ArrayList;

public class SumOperator implements IOperation {
    public int operate(ArrayList<Integer> array)
    {
        int result = 0;
        for (int elem: array) {
            result+=elem;
        }
        return result;
    }
}
