package ast.statement;

import ast.AbstractLocatable;
import ast.expression.Expression;

public class Log extends AbstractLocatable implements Statement {

    private final Expression expr;

    public Log(Expression expr, int line, int column) {
        super(line, column);
        this.expr = expr;
    }

    public Expression getExpr() {
        return this.expr;
    }
}
