import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.time.Instant;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main (String[] args){
        HashMap<String, Integer> DropTable = new HashMap<String, Integer>();

        /*try {
            File myFile = new File("variant.txt");
            FileReader fileReader = new FileReader(myFile));
            BufferedReader reader = new BufferedReader(fileReader);

            String line =null;
            while ((line = reader.readLine()) !=null){

                System.out.println(line);

            }
            reader.close();
        } catch (Exception ex) {
            System.out.println("ЧТО-ТО ПОШЛО НЕ ТАК :'( ");
        }*/
        int result=0;
        try {
            URL url = Main.class.getResource("variant.txt");
            Scanner fileReader = new Scanner(new File(url.toURI()));
            String inputFile[]=new String[2];
            inputFile[0]=fileReader.nextLine();
            inputFile[1]=fileReader.nextLine();
            Scanner prsInt = new Scanner(inputFile[1]);
            if(inputFile[0].equals("+")){
                while(prsInt.hasNextInt()){
                    result+=prsInt.nextInt();
                }
                System.out.println("was input operator "+inputFile[0]+" and result: "+result);
            }else{
                if(inputFile[0].equals("-")){
                    while(prsInt.hasNextInt()){
                        result-=prsInt.nextInt();
                    }
                    System.out.println("was input operator "+inputFile[0]+" and result: "+result);
                }else{
                    System.out.println("operator not support");
                }

            }

        }catch(Exception ex){
            System.out.println("ЧТО-ТО ПОШЛО НЕ ТАК :'( "+ "КОД ОШИБКИ: "+ex);
        }
    }
}
