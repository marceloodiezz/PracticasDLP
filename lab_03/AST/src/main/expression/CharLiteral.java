package main.expression;

import main.ast.AbstractLocatable;

public class CharLiteral extends AbstractLocatable implements Expression {

    private final char value;

    protected CharLiteral(char value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public char getValue() {
        return this.value;
    }

}
