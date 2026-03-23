package main.statement;

import main.ast.AbstractLocatable;

import java.util.ArrayList;
import java.util.List;

public class If_Else extends AbstractLocatable implements Statement {

    private final List<Statement> if_body;
    private final List<Statement> else_body;

    public If_Else(List<Statement> if_body, List<Statement> else_body, int line, int column) {
        super(line, column);
        this.if_body = new ArrayList<>(if_body);
        this.else_body = new ArrayList<>(else_body);
    }

    public List<Statement> getIf_body() {
        return this.if_body;
    }

    public List<Statement> getElse_body() {
        return this.else_body;
    }
}
