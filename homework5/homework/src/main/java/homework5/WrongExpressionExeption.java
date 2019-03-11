package homework5;

public class WrongExpressionExeption extends Throwable{
    public WrongExpressionExeption(){
        super("Неправильное выражение, не может быть вычислено");
    }
}
