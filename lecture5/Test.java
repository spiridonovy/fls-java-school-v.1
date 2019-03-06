package FLS.lesson5;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        try {
            Scanner in=new Scanner(System.in);
            System.out.println("Enter name of file to read : ");
            String input=in.nextLine();
            System.out.println(FileCalculate.calculate(input));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
