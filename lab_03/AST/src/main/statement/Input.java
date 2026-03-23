package main.statement;

import main.ast.AbstractLocatable;
import main.expression.Expression;

public class Input extends AbstractLocatable implements Statement {

    private final Expression target;

    public Input(Expression target, int line, int column) {
        super(line, column);
        this.target = target;
    }

    public Expression getTarget() {
        return this.target;
    }

}
