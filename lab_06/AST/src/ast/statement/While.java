package ast.statement;

import ast.AbstractLocatable;
import ast.expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class While extends AbstractLocatable implements Statement {

    private final Expression condition;
    private final List<Statement> body;

    public While(Expression condition, List<Statement> body, int line, int column) {
        super(line, column);
        this.condition = condition;
        this.body = new ArrayList<>(body);
    }

    public Expression getCondition() {
        return this.condition;
    }

    public List<Statement> getBody() {
        return this.body;
    }

}
