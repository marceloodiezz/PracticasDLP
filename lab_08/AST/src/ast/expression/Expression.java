package ast.expression;

import ast.Locatable;

public interface Expression extends Locatable {

    void setLValue(boolean lValue);

    boolean getLValue();

}
