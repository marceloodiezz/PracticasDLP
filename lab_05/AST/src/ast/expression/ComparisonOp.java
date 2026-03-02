package ast.expression;

public class ComparisonOp extends BinaryOp {

    public ComparisonOp(String operator, Expression left, Expression right, int line, int column) {
        super(operator, left, right, line, column);
    }

}
