import com.fileIO.FileReader;
import com.operations.IOperation;
import com.operations.SumOperator;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        FileReader fr = new FileReader("\\config.txt");
        String operation = fr.getOperation();
        ArrayList<Integer> array = fr.getListOfArguments();
        IOperation operationHandler;
        if (operation.equals("+")) {
            operationHandler = new SumOperator();
        } else
        {
            System.out.println("Selected operation not supported yet.");
            return;
        }
        System.out.println(operationHandler.operate(array));
    }
}