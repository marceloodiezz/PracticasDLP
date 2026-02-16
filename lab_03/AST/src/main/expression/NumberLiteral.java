package main.expression;

import main.ast.AbstractLocatable;

public class NumberLiteral extends AbstractLocatable implements Expression {

    private final double value;

    protected NumberLiteral(double value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
