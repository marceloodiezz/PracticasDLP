package ast.type;

import ast.AbstractLocatable;
import visitor.Visitor;

public class RecordField extends AbstractLocatable {

    private final String name;
    private final Type targetType;

    private int offset;

    public RecordField(String name, Type targetType, int line, int column) {
        super(line, column);
        this.name = name;
        this.targetType = targetType;
    }

    public String getName() {
        return this.name;
    }

    public Type getTargetType() {
        return this.targetType;
    }

    @Override
    public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
        return v.visit(this, param);
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

}
