package main.type;

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

}
