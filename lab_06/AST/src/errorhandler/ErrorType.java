package errorhandler;

import ast.Locatable;
import ast.type.Type;

public class ErrorType implements Type {

    private String cause;
    private Locatable locatable;

    public ErrorType(String cause, Locatable locatable) {
        this.cause = cause;
        this.locatable = locatable;
        ErrorHandler.getInstance().addError(this);
    }

    public String getCause() {
        return this.cause;
    }

    public Locatable getLocatable() {
        return this.locatable;
    }

    @Override
    public String toString() {
        return "Error en fila {" + locatable.getLine() + "} y columna {" + locatable.getColumn() + "}: " + cause;
    }
}
