package ast.statement;

import ast.AbstractLocatable;
import ast.expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class IfElse extends AbstractLocatable implements Statement {

    private final Expression condition;
    private final List<Statement> if_body;
    private final List<Statement> else_body;

    public IfElse(Expression condition, List<Statement> if_body, List<Statement> else_body, int line, int column) {
        super(line, column);
        this.condition = condition;
        this.if_body = new ArrayList<>(if_body);
        this.else_body = new ArrayList<>(else_body);
    }

    public Expression getCondition() {
        return this.condition;
    }

    public List<Statement> getIf_body() {
        return this.if_body;
    }

    public List<Statement> getElse_body() {
        return this.else_body;
    }
}
