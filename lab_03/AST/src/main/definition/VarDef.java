package main.definition;

import main.statement.Statement;
import main.type.Type;

public class VarDef extends AbstractDefinition implements Statement {

    public VarDef(String name, Type type, int line, int column) {
        super(name, type, line, column);
    }

}
