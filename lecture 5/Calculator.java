package fls.java.school.lecture5;

import java.io.*;
import java.util.ArrayList;

public class Calculator {

    private String filename, arrayString;
    private char sign;
    private ArrayList<Double> arrayDouble;
    private SignType signType;
    private double result = 0;

    Calculator(String filename) {
        this.filename = filename;
        arrayDouble = new ArrayList();
    }

    public double calculate() {
        try {
            readFromFile();
            setArrayInt();
            setSignType();
            setResult();
        }
        catch (WrongInputDataException e) {
            System.out.println(e.getMessage());
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            return result;
        }
    }

    private void readFromFile() throws IOException {
        FileInputStream fs = new FileInputStream(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        try {
            sign = br.readLine().charAt(0);
            arrayString = br.readLine();
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        catch (IOException e) {
            throw new IOException();
        }
        finally {
            fs.close();
            br.close();
        }
    }

    private void setArrayInt() throws WrongInputDataException {
        try {
            for (String data : this.arrayString.split(" ")) {
                arrayDouble.add(Double.parseDouble(data));
            }
        }
        catch (NumberFormatException e){
            throw new WrongInputDataException("Wrong string with numbers");
        }
    }

    private void setSignType() throws WrongInputDataException {
        if (sign == '+') this.signType = SignType.ADDITION;
        else if (sign == '-') this.signType = SignType.SUBTRACTION;
        else if (sign == '*') this.signType = SignType.MULTIPLICATION;
        else if (sign == '/') this.signType = SignType.DIVISION;
        else throw new WrongInputDataException("Wrong sign");
    }

    private void setResult() {
        switch(signType) {
            case ADDITION:
                addAll();
                break;
            case SUBTRACTION:
                subAll();
                break;
            case MULTIPLICATION:
                multAll();
                break;
            case DIVISION:
                divAll();
                break;
        }
    }

    private void addAll() {
        result = arrayDouble.get(0);
        for (int i = 1; i < arrayDouble.size(); i++) {
            result += arrayDouble.get(i);
        }
    }

    private void subAll() {
        result = arrayDouble.get(0);
        for (int i = 1; i < arrayDouble.size(); i++) {
            result -= arrayDouble.get(i);
        }
    }

    private void multAll() {
        result = arrayDouble.get(0);
        for (int i = 1; i < arrayDouble.size(); i++) {
            result *= arrayDouble.get(i);
        }
    }

    private void divAll() {
        result = arrayDouble.get(0);
        try {
            for (int i = 1; i < arrayDouble.size(); i++) {
                if (arrayDouble.get(i) == 0) throw new ArithmeticException();
                result /= arrayDouble.get(i);
            }
        }
        catch (ArithmeticException e) {
            System.out.println("Division by zero");
            result = 0;
        }
    }
}
