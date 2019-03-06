package fls.java.school.lecture5;

import java.util.Scanner;

public class TestCalculator {
    public static void main(String[] args) {
        System.out.println("Enter filename: ");
        Scanner in = new Scanner(System.in);
        String filename = in.nextLine();

        Calculator calculator = new Calculator(filename);
        System.out.println(calculator.calculate());
    }
}
