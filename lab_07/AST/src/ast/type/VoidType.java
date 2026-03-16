package ast.type;

import visitor.Visitor;

public class VoidType implements Type {

    private static final VoidType INSTANCE = new VoidType();

    private VoidType() {}

    public static VoidType getInstance() {
        return INSTANCE;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }

}
