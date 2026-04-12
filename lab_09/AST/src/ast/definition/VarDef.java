package ast.definition;

import ast.statement.Statement;
import ast.type.Type;
import visitor.Visitor;

public class VarDef extends AbstractDefinition implements Statement {

    public VarDef(String name, Type type, int line, int column) {
        super(name, type, line, column);
    }

    public VarDef(int line, int column, String name, Type type) {
        super(name, type, line, column);
    }

    @Override
    public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
        return v.visit(this, param);
    }

}
