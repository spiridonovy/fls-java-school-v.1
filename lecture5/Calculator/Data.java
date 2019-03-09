package Calculator;

import Calculator.ExtendedExceptions.WrongNumericDataFormatException;
import Calculator.ExtendedExceptions.WrongOperationDataException;

import java.util.ArrayList;

public class Data {
    private Operations operation;
    private ArrayList<Double> numbers;

    public Operations getOperation() {
        return operation;
    }

    public String getOperationString() {                                                                                //get string of operation
        return operation.getOperationString();
    }

    public ArrayList<Double> getNumbers() {
        return numbers;
    }

    public Data(String operation, String numbers) throws Exception {
        this.operation = parseOperation(operation);
        this.numbers = parseNumbers(numbers);
    }

    private Operations parseOperation(String operations) throws Exception {                                             //parse operation from string
        operations = operations.replaceAll("\\s+", "");

        if (operations.length() > 1) {
            throw new WrongOperationDataException("Wrong length of operation row");
        }
        if (operations.isEmpty()) {
            throw new WrongOperationDataException("Operation row is empty");
        }
        switch (operations) {
            case "+":
                return Operations.ADDITION;
            case "-":
                return Operations.SUBTRACTION;
            case "*":
                return Operations.MULTIPLICATION;
            case "/":
                return Operations.DIVISION;
            default:
                throw new WrongOperationDataException("Unsupported operation!");
        }

    }

    private ArrayList<Double> parseNumbers(String numbers) throws Exception {                                           //parse numbers from string
        var numberList = new ArrayList<Double>();
        if (numbers.isEmpty()) {
            throw new WrongNumericDataFormatException("Numbers row is empty");
        }
        for (String number : numbers.split(" ")) {
            number = number.replace(",", ".");
            if (!(number.matches("-?[0-9]+") || number.matches("-?[0-9]+\\.[0-9]+"))) {                    //is number contains alphabetical symbols
                throw new WrongNumericDataFormatException("Error when parse number, not only numeric");
            }
            numberList.add(Double.parseDouble(number));
        }
        return numberList;
    }
}