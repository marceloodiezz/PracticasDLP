package ast.expression;

import ast.AbstractLocatable;

public abstract class AbstractExpression extends AbstractLocatable implements Expression {

    private boolean lValue;

    public AbstractExpression(int line, int column) {
        super(line, column);
    }

    @Override
    public void setLValue(boolean lValue) {
        this.lValue = lValue;
    }

    @Override
    public boolean getLValue() {
        return this.lValue;
    }

}
