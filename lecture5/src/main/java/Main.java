import MathLib.*;
//TODO: По хорошему нужно написать тесты, а не захламлять main,
//но я пока не разобрался как на джаве можно автогенерировать тесты
public class Main {
    public static void main(String[] args) {
        Data for7elemsSum = new Data();
        Data for5elemsDif = new Data();
        Data for9elemsDiv = new Data();
        Data for13elemsMult = new Data();
        Data invalidData = new Data();
        float result;

        for7elemsSum.readFromFile("src\\Sum7elements.txt");
        for7elemsSum.print();
        for5elemsDif.readFromFile("src\\Dif5elements.txt");
        for5elemsDif.print();
        for9elemsDiv.readFromFile("src\\Div9elements.txt");
        for9elemsDiv.print();
        for13elemsMult.readFromFile("src\\Mult13elements.txt");
        for13elemsMult.print();
        //Uncoment for check for exception
        //invalidData.readFromFile("src\\InvalidData.txt");
        //invalidData.print();

        try{

            result = OneOperationToAll.calculate(for7elemsSum);
            System.out.println("Result = " + result);
            result = OneOperationToAll.calculate(for5elemsDif);
            System.out.println("Result = " + result);
            result = OneOperationToAll.calculate(for9elemsDiv);
            System.out.println("Result = " + result);
            result = OneOperationToAll.calculate(for13elemsMult);
            System.out.println("Result = " + result);
        }
        catch (Exception myException){
            System.out.println("Exception: " + myException.getMessage());
        }
    }
}
