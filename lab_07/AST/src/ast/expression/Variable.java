package ast.expression;

import visitor.Visitor;

public class Variable extends AbstractExpression {

    private final String name;

    public Variable(String name, int line, int column) {
        super(line, column);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }

}
