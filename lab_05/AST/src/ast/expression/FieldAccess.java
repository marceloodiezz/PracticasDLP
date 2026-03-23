package ast.expression;

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

}
