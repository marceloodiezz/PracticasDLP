package ast.type;

import ast.Locatable;
import visitor.Visitor;

public class NumberType extends AbstractType {

    private static final NumberType INSTANCE = new NumberType();

    private NumberType() {}

    public static NumberType getInstance() {
        return INSTANCE;
    }

    @Override
    public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
        return v.visit(this, param);
    }

    @Override
    public Type arithmetic(Type other, Locatable l) {
        if(other == NumberType.getInstance() || other == IntType.getInstance() || other == CharType.getInstance())
            return NumberType.getInstance();
        return super.arithmetic(other, l);
    }

    @Override
    public Type comparison(Type other, Locatable l) {
        if(other == IntType.getInstance() || other == CharType.getInstance() || other == NumberType.getInstance())
            return IntType.getInstance();
        return super.comparison(other, l);
    }

    @Override
    public Type arithmetic(Locatable l) {
        return NumberType.getInstance();
    }

    @Override
    public Type canBeCastTo(Type t, Locatable l) {
        if(t == IntType.getInstance() || t == NumberType.getInstance())
            return t;
        return super.canBeCastTo(t, l);
    }

    @Override
    public void mustPromotesTo(Type other, Locatable l) {
        if(other == NumberType.getInstance())
            return;
        super.mustPromotesTo(other, l);
    }

    @Override
    public void mustBeBuiltIn(Locatable l) {
        // NO SE HACE NADA
    }

    @Override
    public String toString() {
        return "NumberType";
    }

}
