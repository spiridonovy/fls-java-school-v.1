package Calculator;

enum Operations{

    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private String _stringOperation;
    Operations(String stringOperation)
    {
        this._stringOperation = stringOperation;
    }
    public String getOperationString() {                                                                                //return operation string symbol
        return this._stringOperation;
    }


}