package ast.expression;

import ast.Locatable;
import ast.type.Type;

public interface Expression extends Locatable {

    void setLValue(boolean lValue);

    boolean getLValue();

    Type getType();

    void setType(Type type);

}
