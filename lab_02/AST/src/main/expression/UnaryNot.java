package main.expression;

import main.ast.AbstractLocatable;

public class UnaryNot extends AbstractLocatable implements Expression {

    private final Expression operand;

    protected UnaryNot(Expression operand, int line, int column) {
        super(line, column);
        this.operand = operand;
    }

    public Expression getOperand() {
        return this.operand;
    }
}
