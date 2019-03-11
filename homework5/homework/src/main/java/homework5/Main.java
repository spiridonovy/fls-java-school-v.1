package homework5;


/**
 * Run application from here.
 */
public class Main {

    public static void main(String[] args) {
        MyFileReader reader = new MyFileReader();
        String expStr1 = reader.readToString("src\\file1.txt");
        System.out.println(reader.readToString(expStr1));
        Expression expression1 = Expression.createExpressionFromHomeworkType(expStr1);
        expression1.printExpression();
        System.out.println("Решение 1 = " + expression1.calculate());


        String expStr2 = reader.readToString("src\\Сложная строка.txt");
        System.out.println(reader.readToString(expStr2));
        Expression expression2 = new Expression(expStr2);
        expression2.printExpression();
        System.out.println("Решение 2 = " + expression2.calculate());


    }

}
