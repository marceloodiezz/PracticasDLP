package main.expression;

import main.ast.AbstractLocatable;

public class Variable extends AbstractLocatable implements Expression {

    private final String name;

    public Variable(String name, int line, int column) {
        super(line, column);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
