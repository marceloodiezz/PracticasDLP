package ast.definition;

import ast.Locatable;
import ast.type.Type;

public interface Definition extends Locatable {

    public String getName();
    public Type getType();

    public void setScope(int scope);
    public int getScope();
}
