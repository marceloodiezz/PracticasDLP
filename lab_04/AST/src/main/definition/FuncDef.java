package main.definition;

import main.statement.Statement;
import main.type.Type;

import java.util.ArrayList;
import java.util.List;

public class FuncDef extends AbstractDefinition {

    private final List<Statement> body;

    public FuncDef(String name, Type type, List<Statement> body, int line, int column) {
        super(name, type, line, column);
        this.body = new ArrayList<>(body);
    }

    public List<Statement> getBody() {
        return body;
    }
}
