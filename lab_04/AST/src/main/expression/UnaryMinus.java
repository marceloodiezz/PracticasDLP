package main.expression;

import main.ast.AbstractLocatable;

public class UnaryMinus extends AbstractLocatable implements Expression {

    private final Expression operand;

    protected UnaryMinus(Expression operand, int line, int column) {
        super(line, column);
        this.operand = operand;
    }

    public Expression getOperand() {
        return this.operand;
    }
}
