package ast.type;

import ast.definition.VarDef;
import visitor.Visitor;

import java.util.List;

public class FuncType implements Type {

    private final Type returnType;
    private final List<VarDef> params;

    public FuncType(Type returnType, List<VarDef> params) {
        this.returnType = returnType;
        this.params = params;
    }

    public Type getReturnType() {
        return this.returnType;
    }

    public List<VarDef> getParams() {
        return params;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }
}
