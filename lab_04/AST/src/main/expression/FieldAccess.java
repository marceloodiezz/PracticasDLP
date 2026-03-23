package main.expression;

import main.ast.AbstractLocatable;

public class FieldAccess extends AbstractLocatable implements Expression {

    private final String fieldName;
    private final Expression expr;

    protected FieldAccess(String fieldName, Expression expr,int line, int column) {
        super(line, column);
        this.fieldName = fieldName;
        this.expr = expr;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public Expression getExpr() {
        return this.expr;
    }

}
