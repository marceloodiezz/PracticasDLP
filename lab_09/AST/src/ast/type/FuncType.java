package ast.type;

import ast.Locatable;
import ast.definition.VarDef;
import visitor.Visitor;

import java.util.List;

public class FuncType extends AbstractType {

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
    public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
        return v.visit(this, param);
    }

    @Override
    public Type parenthesis(List<Type> types, Locatable l) {
        if (types.size() != params.size())
            return new ErrorType("Número incorrecto de argumentos. Se esperaban " + params.size() + " y se recibieron " + types.size() + ".",  l);

        for (int i = 0; i < types.size(); i++)
            types.get(i).mustPromotesTo(params.get(i).getType(), l);

        return returnType;
    }

    @Override
    public String toString() {
        return "FunctionType";
    }
}
