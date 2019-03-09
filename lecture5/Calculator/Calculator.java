package Calculator;

public class Calculator {
    public static double calculate(Data data) throws Exception {
        double result;
        switch (data.getOperation()) {
            case ADDITION:
                result = 0;
                for (double currentNumber : data.getNumbers()) {
                    result += currentNumber;
                }
                break;
            case SUBTRACTION:
                result = 0;
                for (double currentNumber : data.getNumbers()) {
                    result -= currentNumber;
                }
                break;
            case MULTIPLICATION:
                result = 1;
                for (double currentNumber : data.getNumbers()) {
                    result *= currentNumber;
                }
                break;
            case DIVISION:
                result = data.getNumbers().get(0);
                for (double currentNumber : data.getNumbers().subList(1, data.getNumbers().size())) {                     //not self-divide first number
                    if (currentNumber == 0)
                        throw new ArithmeticException("Dividing by zero!");
                    result /= currentNumber;
                }
                break;
            default:
                throw new Exception("Unsupported operation: " + data.getOperationString());
        }
        return result;
    }
}

