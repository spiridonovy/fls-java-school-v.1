import com.sun.media.sound.InvalidFormatException;

import java.io.*;
import java.lang.String;
import java.util.ArrayList;

public class CalculateMethod {

    private ArrayList<Double> numbers;
    private Character sign;
    private Double result;

    public CalculateMethod(String varFileName)
    {
        try {
            if (!varFileName.endsWith(".txt")) {
                throw new InvalidFormatException("File name must be .txt format");
            }
        }
        catch (InvalidFormatException ex)
        {
            ex.printStackTrace();
        }

        try
        {
        this.numbers = this.readNumbersFromFile(varFileName);
        this.sign = this.readSignFromFile(varFileName);
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public ArrayList<Double> readNumbersFromFile(String fileName) throws IOException
    {
        String firstLine;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            firstLine = br.readLine();
        }
        catch (FileNotFoundException ex)
        {
            throw new FileNotFoundException();
        }
        catch (IOException ex)
        {
            throw new IOException();
        }

        String[] numbersArray = firstLine.split(" ");
        ArrayList<Double> numbersFromFile = new ArrayList<Double>();
        for (int i = 0; i < numbersArray.length; i++) {
            numbersFromFile.add(Double.parseDouble(numbersArray[i]));
        }
        return numbersFromFile;
    }

    public Character readSignFromFile(String fileName) throws IOException
    {
        String secondLine;
        Character signFromFile;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            secondLine = br.readLine();
            secondLine = br.readLine();
        }
            catch (FileNotFoundException ex)
        {
        throw new FileNotFoundException();
        }
            catch (IOException ex)
        {
        throw new IOException();
        }

        signFromFile = secondLine.charAt(0);
        return signFromFile;
    }

    public void calculate()
    {
        result = this.numbers.get(0);
            for (int i=1;i<this.numbers.size();i++) {
                switch (this.sign) {
                    case '+':
                        result += this.numbers.get(i);
                        break;
                    case '-':
                        result -= this.numbers.get(i);
                        break;
                    case '*':
                        result *= this.numbers.get(i);
                        break;
                    case '/':
                        try {
                            if (this.numbers.get(i).equals(0.00))
                                throw new IllegalArgumentException("Divisor is 0!");
                            else {
                                result /= this.numbers.get(i);

                            }
                        }
                        catch (IllegalArgumentException ex)
                        {
                            ex.printStackTrace();
                            System.exit(1);
                        }
                        finally {
                            break;
                        }
                }
            }

    }

    public void printResult()
    {
        System.out.println("Result of calculation is: "+result);
    }
}
