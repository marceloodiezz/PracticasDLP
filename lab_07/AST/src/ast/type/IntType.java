package ast.type;

import visitor.Visitor;

public class IntType implements Type{

    private static final IntType INSTANCE = new IntType();

    private IntType() {}

    public static IntType getInstance() {
        return INSTANCE;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }

}
