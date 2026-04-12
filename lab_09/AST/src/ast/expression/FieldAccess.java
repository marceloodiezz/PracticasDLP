package ast.expression;

import ast.Locatable;
import ast.type.Type;
import visitor.Visitor;

public class FieldAccess extends AbstractExpression {

    private final String fieldName;
    private final Expression expr;

    public FieldAccess(String fieldName, Expression expr, int line, int column) {
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

    @Override
    public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
        return v.visit(this, param);
    }

}
