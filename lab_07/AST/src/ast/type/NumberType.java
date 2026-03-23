package ast.type;

import visitor.Visitor;

public class NumberType implements Type {

    private static final NumberType INSTANCE = new NumberType();

    private NumberType() {}

    public static NumberType getInstance() {
        return INSTANCE;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }

}
