package ast.expression;

public class ArithmeticOp extends BinaryOp {

    public ArithmeticOp(String operator, Expression left, Expression right, int line, int column) {
        super(operator, left, right, line, column);
    }

}
