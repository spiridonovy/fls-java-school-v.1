package com.fls.calc;

public class App {
    
    public static void main( String[] args ) {
        try {
            double result = FileCalculator.calculate(args[0]);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }
}
