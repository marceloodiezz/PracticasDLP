package ast.type;

import ast.AbstractLocatable;

public class RecordField extends AbstractLocatable {

    private final String name;
    private final Type targetType;

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

}
