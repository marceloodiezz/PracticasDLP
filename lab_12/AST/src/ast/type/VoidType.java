package ast.type;

import ast.Locatable;
import visitor.Visitor;

public class VoidType extends AbstractType {

    private static final VoidType INSTANCE = new VoidType();

    private VoidType() {}

    public static VoidType getInstance() {
        return INSTANCE;
    }

    @Override
    public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "VoidType";
    }

}
