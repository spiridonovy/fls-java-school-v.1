package com.homework.irina;

import java.util.LinkedList;
import java.util.Stack;

public class MySum {
    private LinkedList<Character> mySum;

    public MySum (char[] charArray){
        LinkedList<Character> newList = new LinkedList<>();
        for(char elem : charArray){
            newList.add(elem);
        }
        mySum = useSortingStation(newList);
    }

    public MySum (LinkedList<Character> charList){
        mySum = useSortingStation(charList);
    }

    public MySum (String mySumString){
        this(mySumString.toCharArray());
    }

    static MySum createMySumFromHomeworkType(String homeworkString){
        char[] charArray = homeworkString.toCharArray();
        LinkedList<Character> charList = new LinkedList<>();

        char mySumSymbol = charArray[0];
        int spaceCount = 0;

        for (char symbol : charArray ){
            if (symbol > 47 && symbol < 58){
                charList.add(symbol);
                spaceCount = 0;
            } else if( spaceCount == 0 && symbol == 32){
                charList.add(mySumSymbol);
                spaceCount++;
            }
        }
        return new MySum (charList);
    }

    public void printMySum(){
        System.out.println(mySum);
    }

    public int calculate() throws MyWrong {
        int result = 0;
        int grade = 0;
        Stack<Integer> stack = new Stack<>();

        for (char symbol : mySum ){
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
                        throw new MyWrong();
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
