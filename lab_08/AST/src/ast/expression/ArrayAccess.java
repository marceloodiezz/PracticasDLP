package ast.expression;

import ast.AbstractLocatable;
import visitor.Visitor;

public class ArrayAccess extends AbstractExpression {

    private final Expression left;
    private final Expression right;

    public ArrayAccess(Expression left, Expression right, int line, int column) {
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

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }

}