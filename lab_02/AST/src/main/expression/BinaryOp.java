package main.expression;

import main.ast.AbstractLocatable;

public abstract class BinaryOp extends AbstractLocatable implements Expression  {

    private final String operator;
    private final Expression left;
    private final Expression right;

    protected BinaryOp(String operator, Expression left, Expression right, int line, int column) {
        super(line, column);
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public String getOperator() {
        return this.operator;
    }

    public Expression getLeft() {
        return this.left;
    }

    public Expression getRight() {
        return this.right;
    }
}
