package ast.expression;

import ast.definition.Definition;
import visitor.Visitor;

public class Variable extends AbstractExpression {

    private final String name;
    private Definition definition;

    public Variable(String name, int line, int column) {
        super(line, column);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDefinition(Definition def) {
        this.definition = def;
    }

    public Definition getDefinition() {
        return this.definition;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }

}
