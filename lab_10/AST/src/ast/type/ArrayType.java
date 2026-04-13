package ast.type;

import ast.Locatable;
import visitor.Visitor;

public class ArrayType extends AbstractType {

    private final int size;
    private final Type of;

    public ArrayType(int size, Type elementType) {
        this.size = size;
        this.of = elementType;
    }

    public int getSize() {
        return this.size;
    }

    public Type getOf() {
        return this.of;
    }

    @Override
    public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
        return v.visit(this, param);
    }

    @Override
    public Type squareBrackets(Type other, Locatable l) {
        if(other == IntType.getInstance())
            return of;
        return super.squareBrackets(other, l);
    }

    @Override
    public String toString() {
        return "ArrayType";
    }

}
