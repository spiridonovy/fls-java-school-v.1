import Calculator.FileHandler;

public class Main {

    public static void main(String[] args) { // entry point

        System.out.println("Hello");
        var file = new FileHandler();
        file.ReadFromFile("C:\\Users\\Alex\\Source\\fls-java-school\\target\\file.txt");
    }
}