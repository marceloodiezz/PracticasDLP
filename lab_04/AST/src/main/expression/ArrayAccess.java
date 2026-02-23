package main.expression;

import main.ast.AbstractLocatable;

public class ArrayAccess extends AbstractLocatable implements Expression {

    private final Expression left;
    private final Expression right;

    protected ArrayAccess(Expression left, Expression right, int line, int column) {
        super(line, column);
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return this.left;
    }

    public Expression getRight() {
        return this.right;
    }

}