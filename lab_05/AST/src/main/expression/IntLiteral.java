package main.expression;

import main.ast.AbstractLocatable;

public class IntLiteral extends AbstractLocatable implements Expression {

    private final int value;

    protected IntLiteral(int value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
