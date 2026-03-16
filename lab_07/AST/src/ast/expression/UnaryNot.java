package ast.expression;

import visitor.Visitor;

public class UnaryNot extends AbstractExpression {

    private final Expression operand;

    public UnaryNot(Expression operand, int line, int column) {
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
