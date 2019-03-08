package MathLib;

public class OneOperationToAll {

    public static float calculate(Data data) throws Exception{
        float res;

        switch(data.operation){
            case '+':
                res = 0;
                for (int i = 0; i < data.numbers.length; i++){
                    res += data.numbers[i];
                }
                break;
            case '-':
                res = 0;
                for (int i = 0; i < data.numbers.length; i++){
                    res -= data.numbers[i];
                }
                break;
            case '*':
                res = 1;
                for (int i = 0; i < data.numbers.length; i++){
                    res *= data.numbers[i];
                }
                break;
            case '/':
                res = data.numbers[0];
                for (int i = 1; i < data.numbers.length; i++){
                    if(data.numbers[i] == 0)
                        throw new ArithmeticException("Dividing by zero");
                    res /= data.numbers[i];
                }
                break;
                default: throw new Exception("MyException: Unexpected operation sign");
        }
        return res;
    }
}
