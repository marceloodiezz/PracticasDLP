package main.expression;

public class ArithmeticOp extends BinaryOp {

    protected ArithmeticOp(String operator, Expression left, Expression right, int line, int column) {
        super(operator, left, right, line, column);
    }

}
