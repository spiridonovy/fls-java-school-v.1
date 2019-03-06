import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Calculator {
    private static Operation operation;
    private static Double[] numbers;
    private static Double result = 0.0;

    public static Number calculate(String filename) {
        try {
            readFile(filename);
            switch (operation) {
                case SUM:
                    sumUp();
                    break;
                case SUBS:
                    subtract();
                    break;
                case MULT:
                    multiply();
                    break;
                case DIV:
                    divide();
                    break;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found.");
            return 0;
        }catch (IOException e) {
            System.out.println("Could not calculate correctly.");
            return 0;
        }
        if (Integer.parseInt(result.toString().split("\\.")[1]) == 0)
            return Integer.valueOf(result.toString().split("\\.")[0]);
        return result;
    }

    private static void divide() throws IOException {
        result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0.0) {
                System.out.println("Cannot divide by zero.");
                throw new IOException();
            }
            result /= numbers[i];
        }
    }

    private static void multiply() {
        result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0.0) {
                result = 0.0;
                break;
            }

            result *= numbers[i];
        }
    }

    private static void subtract() {
        result = numbers[0];
        for (int i =1; i < numbers.length; i++)
            result -= numbers[i];
    }

    private static void sumUp() {
        for (Double d : numbers)
            result += d;
    }

    private static void readFile(String filename) throws IOException {
        if (!Files.exists(Paths.get(filename)))
            throw new FileNotFoundException();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            defineOperation(reader.readLine());
            defineNumbers(reader.readLine());
        } catch (IllegalArgumentException e) {
            throw new IOException();
        }
    }

    private static void defineNumbers(String nums) {
        String[] snums = nums.split(" ");
        numbers = new Double[snums.length];
        for (int i = 0; i < numbers.length; i++) {
            if (isNumeric(snums[i])) {
                numbers[i] = Double.parseDouble(snums[i]);
            } else {
                System.out.println("Line contains non-numeric symbols");
                throw new IllegalArgumentException();
            }
        }
    }

    private static boolean isNumeric(String snum) {
        try {
            Double.parseDouble(snum);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static void defineOperation(String op) throws IllegalArgumentException {
        try {
            switch (op) {
                case "+":
                    operation = Operation.SUM;
                    break;
                case "-":
                    operation = Operation.SUBS;
                    break;
                case "*":
                    operation = Operation.MULT;
                    break;
                case "/":
                    operation = Operation.DIV;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Not appropriate operation");
            throw new IllegalArgumentException();
        }
    }

    private enum Operation { SUM, SUBS, MULT, DIV }
}
