package ast.expression;

import visitor.Visitor;

public class ComparisonOp extends BinaryOp {

    public ComparisonOp(String operator, Expression left, Expression right, int line, int column) {
        super(operator, left, right, line, column);
    }

    @Override
    public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
        return v.visit(this, param);
    }

}
