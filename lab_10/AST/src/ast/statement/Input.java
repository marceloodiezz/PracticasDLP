package ast.statement;

import ast.AbstractLocatable;
import ast.expression.Expression;
import visitor.Visitor;

public class Input extends AbstractLocatable implements Statement {

    private final Expression target;

    public Input(Expression target, int line, int column) {
        super(line, column);
        this.target = target;
    }

    public Expression getTarget() {
        return this.target;
    }

    @Override
    public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
        return v.visit(this, param);
    }

}
