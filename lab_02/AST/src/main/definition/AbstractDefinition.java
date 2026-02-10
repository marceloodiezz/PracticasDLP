package main.definition;

import main.ast.AbstractLocatable;
import main.type.Type;

public abstract class AbstractDefinition extends AbstractLocatable implements Definition {

    private final String name;
    private final Type type;

    public AbstractDefinition(String name, Type type, int line, int column) {
        super(line, column);
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Type getType() {
        return this.type;
    }
}
