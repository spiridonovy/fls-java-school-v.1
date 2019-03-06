package Calculator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileHandler {
    public void ReadFromFile(String file) {



        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(file))) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

      //  Files.lines(Paths.get(FILE_NAME), StandardCharsets.UTF_8).forEach(System.out::println);
    }
}
