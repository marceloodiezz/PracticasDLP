package ast.expression;

import visitor.Visitor;

public class UnaryMinus extends AbstractExpression {

    private final Expression operand;

    public UnaryMinus(Expression operand, int line, int column) {
        super(line, column);
        this.operand = operand;
    }

    public Expression getOperand() {
        return this.operand;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }

}
