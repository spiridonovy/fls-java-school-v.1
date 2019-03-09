package Calculator;

import Calculator.ExtendedExceptions.WrongFileFormat;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHandler {
    public static Data ReadFromFile(String file) throws Exception {

        try (Stream<String> stream = Files.lines(Paths.get(file))) {                                                     //read file into stream, try-with-resources

            var data = stream.collect(Collectors.toList());
            if (data.size() > 2) {
                throw new WrongFileFormat("File have more than 2 lines!");
            }
            return new Data(data.get(0), data.get(1));

        } catch (NoSuchFileException e) {
            throw new NoSuchFileException("There is no such file: " + file);
        }


    }
}
