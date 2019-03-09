package Calculator;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PrintCalculation {                                                                                         //print calculations
    public static void printCalculations(Data data, double result) {
        System.out.println(
                String.join(" " + data.getOperationString() + " ",
                        data.getNumbers().stream().map(Object::toString).collect(Collectors.toCollection(ArrayList::new))) + //ArrayList(double) to ArrayList(string)
                        " = " +
                        result
        );
    }
}
