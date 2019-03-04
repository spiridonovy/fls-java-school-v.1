package com.fls.calc;

import java.io.*;

public class FileCalculator {

    public static double calculate(String pathName) throws Exception {
        String extension;
        try {
            extension = pathName.substring(pathName.length() - 4);
        } catch (IndexOutOfBoundsException e) {
            throw new IncorrectFileExtensionException("Only .txt extension supported");
        }

        if (!extension.equals(".txt")) {
            throw new IncorrectFileExtensionException("Only .txt extension supported");
        }

        File file = new File(pathName);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        char operation;
        double[] arguments;
        
        try {
            String line = br.readLine();

            if (line.length() != 1) {
                throw new Exception();
            }

            operation = line.charAt(0);

            line = br.readLine();
            String[] args = line.split(" ");
            arguments = new double[args.length];
            for (int i = 0; i < args.length; i++) {
                arguments[i] = Double.parseDouble(args[i]);
            }

            if (br.readLine() != null) {
                throw new Exception();
            }
            br.close();

            switch (operation) {
                case '+' :
                    return summarizeAll(arguments);
                case '-' :
                    return subtractAll(arguments);
                case '*' :
                    return multiplyAll(arguments);
                case '/' :
                    return divideAll(arguments);
                default:
                    throw new Exception();
            }
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new IncorrectFileInputException();
        }
    }

    private static double summarizeAll(double[] arguments) {
        double result = arguments[0];
        for (int i = 1; i < arguments.length; i++) {
            result += arguments[i];
        }
        return result;
    }

    private static double subtractAll(double[] arguments) {
        double result = arguments[0];
        for (int i = 1; i < arguments.length; i++) {
            result -= arguments[i];
        }
        return result;
    }

    private static double multiplyAll(double[] arguments) {
        double result = arguments[0];
        for (int i = 1; i < arguments.length; i++) {
            result *= arguments[i];
        }
        return result;
    }

    private static double divideAll(double[] arguments) {
        double result = arguments[0];
        for (int i = 1; i < arguments.length; i++) {
            result /= arguments[i];
        }
        return result;
    }
}
