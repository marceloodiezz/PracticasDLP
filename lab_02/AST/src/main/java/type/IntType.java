package main.java.type;

public class IntType implements Type{

    private static final IntType INSTANCE = new IntType();

    private IntType() {}

    public static IntType getInstance() {
        return INSTANCE;
    }

}
