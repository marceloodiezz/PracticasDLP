package ast.expression;

import ast.AbstractLocatable;
import ast.type.Type;

public abstract class AbstractExpression extends AbstractLocatable implements Expression {

    private boolean lValue;
    private Type type;

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

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

}
