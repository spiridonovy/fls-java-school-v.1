package homework5;

import java.util.LinkedList;
import java.util.Stack;


/**
 *  только с целыми и неотрицательными
 */
public class Expression {
    private LinkedList<Character> expression;

    public Expression(char[] charArray){
        LinkedList<Character> newList = new LinkedList<>();
        for(char elem : charArray){
            newList.add(elem);
        }
        expression = useSortingStation(newList);
    }

    public Expression(LinkedList<Character> charList){
        expression = useSortingStation(charList);
    }

    public Expression(String expressionString){
        this(expressionString.toCharArray());
    }

    static Expression createExpressionFromHomeworkType(String homeworkString){
        char[] charArray = homeworkString.toCharArray();
        LinkedList<Character> charList = new LinkedList<>();

        char expressionSymbol = charArray[0];
        int spaceCount = 0;

        for (char symbol : charArray ){
            if (symbol > 47 && symbol < 58){
                charList.add(symbol);
                spaceCount = 0;
            } else if( spaceCount == 0 && symbol == 32){
                charList.add(expressionSymbol);
                spaceCount++;
            }
        }
        return new Expression(charList);
    }

    public void printExpression(){
        System.out.println(expression);
    }

    public int calculate() throws WrongExpressionExeption {
        int result = 0;
        int grade = 0;
        Stack<Integer> stack = new Stack<>();

        for (char symbol : expression ){
            switch (symbol){
                case '+':
                    result += stack.pop();
                    break;
                case '-':
                    result -= stack.pop();
                    break;
                case '*':
                    result *= stack.pop();
                    break;
                case '/': // добавить эксепшн на формат при делении на 0
                    try {
                        result /= stack.pop();
                    } catch (Exception e){
                        throw new WrongExpressionExeption();
                    }
                    break;
                case ' ':
                    grade = 0;
                    stack.push(result);
                    break;
                default:
                    result = (result*(10*grade)) + Character.digit(symbol,10);
                    grade = 1;
                    break;
            }
        }
        return result;
    }

    private LinkedList<Character> useSortingStation (LinkedList<Character> notSortedList){
        LinkedList<Character> sortedList = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char symbol : notSortedList){
            switch (symbol){
                case '+':
                case '-':
                    while (stack.empty() == false && (stack.peek() == '*' || stack.peek()== '/')){
                        sortedList.add(stack.pop());
                    }
                    sortedList.add(' ');
                    stack.push(symbol);
                    break;
                case '*':
                case '/':
                    sortedList.add(' ');
                    stack.push(symbol);
                    break;
                case '(':
                    stack.push(symbol);
                    break;
                case ')':
                    while (stack.empty() == false && stack.peek() != '('){
                        sortedList.add(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sortedList.add(symbol);
                    break;
            }
        }

        while (stack.empty() == false){
            sortedList.add(stack.pop());
        }

        return sortedList;
    }
}
