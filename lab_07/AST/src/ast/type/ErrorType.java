package ast.type;

import ast.Locatable;
import errorhandler.ErrorHandler;
import visitor.Visitor;

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

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }
}
