package ast.expression;

import visitor.Visitor;

public class NumberLiteral extends AbstractExpression {

    private final double value;

    public NumberLiteral(double value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
        return v.visit(this, param);
    }

}
