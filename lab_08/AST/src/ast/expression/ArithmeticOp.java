package ast.expression;

import visitor.Visitor;

public class ArithmeticOp extends BinaryOp {

    public ArithmeticOp(String operator, Expression left, Expression right, int line, int column) {
        super(operator, left, right, line, column);
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }

}
