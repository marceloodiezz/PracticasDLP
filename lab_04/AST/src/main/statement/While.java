package main.statement;

import main.ast.AbstractLocatable;
import main.expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class While extends AbstractLocatable implements Statement {

    private final List<Statement> body;
    private final Expression condition;

    public While(List<Statement> body, Expression condition, int line, int column) {
        super(line, column);
        this.body = new ArrayList<>(body);;
        this.condition = condition;
    }

    public List<Statement> getBody() {
        return this.body;
    }

    public Expression getCondition() {
        return this.condition;
    }
}
