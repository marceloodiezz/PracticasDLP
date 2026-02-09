package main.java.type;

public class VoidType implements Type {

    private static final VoidType INSTANCE = new VoidType();

    private VoidType() {}

    public static VoidType getInstance() {
        return INSTANCE;
    }

}
