package ast.definition;

import ast.statement.Statement;
import ast.type.Type;
import visitor.Visitor;

public class VarDef extends AbstractDefinition implements Statement {

    public VarDef(String name, Type type, int line, int column) {
        super(name, type, line, column);
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }

}
