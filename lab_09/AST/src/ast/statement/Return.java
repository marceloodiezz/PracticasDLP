package ast.statement;


import ast.AbstractLocatable;
import ast.expression.Expression;
import visitor.Visitor;

public class Return extends AbstractLocatable implements Statement {

    private final Expression value;

    public Return(Expression value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public Expression getValue() {
        return this.value;
    }

    @Override
    public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
        return v.visit(this, param);
    }

}
