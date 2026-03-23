package ast.expression;

import ast.type.Type;
import visitor.Visitor;

public class Cast extends AbstractExpression {

    private final Type targetType;
    private final Expression expr;

    public Cast(Type targetType, Expression expr, int line, int column) {
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

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }
}
