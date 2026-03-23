package ast.expression;

import ast.AbstractLocatable;

public class AbstractExpression extends AbstractLocatable implements Expression {

    public AbstractExpression(int line, int column) {
        super(line, column);
    }

}
