import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)  {
        String line;
        List<String> data = new LinkedList<>();
        try{
            FileInputStream fstream = new FileInputStream("data");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            // Read File Line By Line
            while ((line = br.readLine()) != null)   {
                // Add data
                data.add(line);
            }

            // Close the input stream
            fstream.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            return;
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            return;
        }

        try{
            String[] nums = data.get(1).split(" ");
            double calculate = Calculator.calculate(data.get(0), nums);
            System.out.println(calculate);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Wrong file format!");
        }
    }
}
