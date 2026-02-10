package main.statement;

import main.ast.AbstractLocatable;
import main.expression.Expression;
import main.expression.Variable;

import java.util.ArrayList;
import java.util.List;

public class FuncCall extends AbstractLocatable implements Statement, Expression {

    private final List<Expression> args;
    private final Variable variable;

    protected FuncCall(List<Expression> args, Variable variable, int line, int column) {
        super(line, column);
        this.args = new ArrayList<>(args);
        this.variable = variable;
    }

    public List<Expression> getArgs() {
        return this.args;
    }

    public Variable getVariable() {
        return this.variable;
    }

}
