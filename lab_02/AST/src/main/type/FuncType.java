package main.type;

import main.definition.VarDef;

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
}
