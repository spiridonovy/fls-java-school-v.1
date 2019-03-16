
import java.io.File;

import java.net.URL;
import java.util.Scanner;

public class Calculate {

    public void calculate (String filename){
        int result=0;
        try {
            URL url = Calculate.class.getResource(filename);
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
