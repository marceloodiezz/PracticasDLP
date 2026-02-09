package main.java.type;

public class RecordField {

    private final String name;
    private final Type targetType;

    public RecordField(String name, Type targetType) {
        this.name = name;
        this.targetType = targetType;
    }

    public String getName() {
        return this.name;
    }

    public Type getTartgetType() {
        return this.targetType;
    }

}
