package ast.type;

import ast.Locatable;
import visitor.Visitor;

public class IntType extends AbstractType{

    private static final IntType INSTANCE = new IntType();

    private IntType() {}

    public static IntType getInstance() {
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
    public Type logic(Locatable l) {
        return IntType.getInstance();
    }

    @Override
    public Type canBeCastTo(Type other, Locatable l) {
        if(other == IntType.getInstance() || other == CharType.getInstance() || other == NumberType.getInstance())
            return other;
        return super.canBeCastTo(other, l);
    }

    @Override
    public void mustBeLogical(Locatable l) {
        // NO SE HACE NADA
        // Int SÍ es lógico
    }

    @Override
    public void mustPromotesTo(Type other, Locatable l) {
        if(other == IntType.getInstance() || other == NumberType.getInstance())
            return;
        super.mustPromotesTo(other, l);
    }

    @Override
    public void mustBeBuiltIn(Locatable l) {
        // NO SE HACE NADA
    }

    @Override
    public String toString() {
        return "IntType";
    }

    @Override
    public int numberOfBytes() {
        return 2;
    }

}
