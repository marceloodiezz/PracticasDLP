package ast.type;

import visitor.Visitor;

public class CharType implements Type{

    private static final CharType INSTANCE = new CharType();

    private CharType() {}

    public static CharType getInstance() {
        return INSTANCE;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }

}
