import Calculator.FileHandler;
import Calculator.Calculator;
import Calculator.Data;
import Calculator.PrintCalculation;


public class Main {

    public static void main(String[] args) { // entry point

        System.out.println("Hello");
        Data data;
        var files = new String[]{
                "lecture5\\Data\\test1.txt",//ADDITION
                "lecture5\\Data\\test2.txt",//SUBTRACTION
                "lecture5\\Data\\test3.txt",//MULTIPLICATION
                "lecture5\\Data\\test4.txt",//DIVISION
                "lecture5\\Data\\test5.txt",//Wrong double format like 4,123
                "lecture5\\Data\\test6.txt",//wrong operation
                "lecture5\\Data\\test7.txt",//divide by zero
                "lecture5\\Data\\test8.txt",//not numeric
                "lecture5\\Data\\test9.txt",//Unsupported operation!
                "lecture5\\Data\\test10.txt",//File have more than 2 lines!
                "lecture5\\Data\\NEFile.txt",//not existing file

        };
        for (var testFile:files) {
            try {
                System.out.print(testFile.substring(testFile.lastIndexOf('\\')+1) +"\t\t");
                data = FileHandler.ReadFromFile(testFile);
                PrintCalculation.printCalculations(data, Calculator.calculate(data));
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}