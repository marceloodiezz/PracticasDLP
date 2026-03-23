package ast.definition;

import ast.statement.Statement;
import ast.type.Type;

public class VarDef extends AbstractDefinition implements Statement {

    public VarDef(String name, Type type, int line, int column) {
        super(name, type, line, column);
    }

}
