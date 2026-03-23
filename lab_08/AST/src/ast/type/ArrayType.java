package ast.type;

import visitor.Visitor;

public class ArrayType implements Type {

    private final int size;
    private final Type elementType;

    public ArrayType(int size, Type elementType) {
        this.size = size;
        this.elementType = elementType;
    }

    public int getSize() {
        return this.size;
    }

    public Type getElementType() {
        return this.elementType;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }

}
