package main.statement;

import main.ast.AbstractLocatable;
import main.expression.Expression;

public class Assignment extends AbstractLocatable implements Statement {

    private final Expression left;
    private final Expression right;

    public Assignment(Expression left, Expression right, int line, int column) {
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
