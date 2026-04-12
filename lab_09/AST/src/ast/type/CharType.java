package ast.type;

import ast.Locatable;
import visitor.Visitor;

public class CharType extends AbstractType {

    private static final CharType INSTANCE = new CharType();

    private CharType() {}

    public static CharType getInstance() {
        return INSTANCE;
    }

    @Override
    public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
        return v.visit(this, param);
    }

    @Override
    public Type arithmetic(Type other, Locatable l) {
        if(other == IntType.getInstance() || other == CharType.getInstance())
            return IntType.getInstance();
        else if(other == NumberType.getInstance())
            return NumberType.getInstance();
        return super.arithmetic(other, l);
    }

    @Override
    public Type logic(Type other, Locatable l) {
        if(other == IntType.getInstance() || other == CharType.getInstance())
            return IntType.getInstance();
        return super.logic(other, l);
    }

    @Override
    public Type comparison(Type other, Locatable l) {
        if(other == IntType.getInstance() || other == CharType.getInstance() || other == NumberType.getInstance())
            return IntType.getInstance();
        return super.comparison(other, l);
    }

    @Override
    public Type arithmetic(Locatable l) {
        return IntType.getInstance();
    }

    @Override
    public Type canBeCastTo(Type t, Locatable l) {
        if(t == IntType.getInstance() || t == CharType.getInstance() || t == NumberType.getInstance())
            return t;
        return super.canBeCastTo(t, l);
    }

    @Override
    public void mustPromotesTo(Type t, Locatable l) {
        if(t == CharType.getInstance())
            return;
        super.mustPromotesTo(t, l);
    }

    @Override
    public void mustBeBuiltIn(Locatable l) {
        // NO SE HACE NADA
    }

    @Override
    public String toString() {
        return "CharType";
    }

}
