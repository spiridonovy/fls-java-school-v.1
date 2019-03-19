import java.util.Scanner;

public class TestOfCalculateMethod {

    public static void main(String[] args) {

        System.out.println("Enter name of file: ");
        Scanner consoleReader = new Scanner(System.in);
        String fileName =(consoleReader.next());

        CalculateMethod calculator = new CalculateMethod(fileName);
        calculator.calculate();
        calculator.printResult();
    }
}
