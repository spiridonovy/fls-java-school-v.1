package FLS.lesson5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class FileCalculate {
    private static char sign;
    private static Vector<Double> numbers=new Vector<Double>();
    private static double answer;

    public static double calculate(String pathname) throws Exception {
        String str;
        List<String> data = new ArrayList<String>();
        try(BufferedReader reader = new BufferedReader(new FileReader(pathname))) {
            while ((str = reader.readLine()) != null){
                data.add(str);
            }
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        }
        catch (Exception e) {
            throw new Exception("Cannot read from file.");
        }

        if(data.size()<2)
            throw new IncorrectDataException("Invalid data entry format.");

        if(!correctSign(data.get(0)))
            throw new IncorrectDataException("Incorrect sign input format.Make sure that there is no space\nbefore the sign or you have entered exactly one sign.");

        if(!correctNumbers(data.get(1)))
            throw new IncorrectDataException("Incorrect number input format.");

        switch (sign){
            case '+':
                return summarize();
            case '-':
                return subtract();
            case '*':
                return multiply();
            case '/':
                return divide();
            default:
                throw new IncorrectDataException("Wrong sign");
        }
    }

    private static double summarize(){
        for (Double number : numbers) {
            answer += number;
        }
        return  answer;
    }

    private static double subtract(){
        answer=numbers.get(0);
        for (int i = 1; i <numbers.size() ; i++) {
            answer-=numbers.get(i);
        }
        return answer;
    }

    private static double multiply(){
        answer=numbers.get(0);
        for (int i = 1; i <numbers.size() ; i++) {
            answer*=numbers.get(i);
        }
        return answer;
    }

    private static double divide() throws Exception {
        answer = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i)==0)
                throw new Exception("Division by zero occurred.");
            answer /= numbers.get(i);
        }
        return answer;
    }

    private static boolean correctNumbers(String str) throws IncorrectDataException {
        String[] temp = str.split(" ");

        try {
            for (String s : temp) {
                numbers.add(Double.parseDouble(s));
            }
        }catch (Exception e){
            throw new IncorrectDataException("Invalid number input format.");
        }

        if(numbers.size()<2)
            throw new IncorrectDataException("At least two numbers are required to complete the operation.");

        return str.matches("[0-9\\s+]+");
    }

    private static boolean correctSign(String str){
        if(str.length()==1){
            sign=str.charAt(0);
            return true;
        }
        else
            return false;
    }
}
