package homework5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MyFileReader {

    public String readToString (String fileName)  {
        StringBuffer stringBuffer = new StringBuffer();
        int point = 0;
        int symbol ;

        try (FileInputStream file = new FileInputStream(fileName)){
            symbol = file.read();
            for(; symbol != -1; point++ ){
                stringBuffer.insert(point,(char) symbol);
                symbol = file.read();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuffer.substring(0);
    }
}
