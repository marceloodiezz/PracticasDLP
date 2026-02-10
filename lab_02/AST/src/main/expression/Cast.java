package main.expression;

import main.ast.AbstractLocatable;
import main.type.Type;

public class Cast extends AbstractLocatable implements Expression {

    private final Type targetType;
    private final Expression expr;

    protected Cast(Type targetType, Expression expr, int line, int column) {
        super(line, column);
        this.targetType = targetType;
        this.expr = expr;
    }

    public Type getTargetType() {
        return this.targetType;
    }

    public Expression getExpr() {
        return this.expr;
    }
}
