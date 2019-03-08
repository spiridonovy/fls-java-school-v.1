package MathLib;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Data {
    public char operation;
    public int[] numbers;

    public void readFromFile(String fileName){
        String integerLine = "";
        String errorFileIncorrectFormat = "Invalid file format";
        try {
            FileReader fr = new FileReader(fileName);
            Scanner scan = new Scanner(fr);

            //read operation symbol
            if(scan.hasNext()){
                operation = scan.next().charAt(0);
            }
            else
                System.out.println(errorFileIncorrectFormat);

            //read integer line symbol
            if(scan.hasNextLine()) {
                scan.nextLine();
                integerLine = scan.nextLine();
            }
            else
                System.out.println(errorFileIncorrectFormat);

            if (integerLine.toString() != ""){
                String[] integerStrings = integerLine.split(" ");
                numbers = new int[integerStrings.length];
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = Integer.parseInt(integerStrings[i]);
                }
            }
            else System.out.println(errorFileIncorrectFormat);

            fr.close();
        }
        catch (IOException e){
            System.out.println("MyException: " + e.getMessage());
            e.printStackTrace();
        }
        catch (NumberFormatException nfe){
            System.out.println("MyException: " + nfe.getMessage());
            nfe.printStackTrace();
        }
    }

    public void print(){
        try {
            System.out.println("Operation is '" + operation + "'");
            System.out.print("Numbers: " + numbers[0]);
            for (int i = 1; i < numbers.length; i++) {
                System.out.print(", " + numbers[i]);
            }
            System.out.println();
        }
        catch(NullPointerException npe){
            System.out.println("MyException: " + npe.getMessage());
        }
        catch(Exception e){
            System.out.println("MyException: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
