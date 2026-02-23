package main.expression;

public class LogicOp extends BinaryOp {

    protected LogicOp(String operator, Expression left, Expression right, int line, int column) {
        super(operator, left, right, line, column);
    }

}
