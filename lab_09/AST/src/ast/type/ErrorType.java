package ast.type;

import ast.Locatable;
import errorhandler.ErrorHandler;
import visitor.Visitor;

import java.util.List;

public class ErrorType extends AbstractType {

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
    public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
        return v.visit(this, param);
    }

    @Override
    public Type arithmetic(Type other, Locatable l) {
        return this;
    }

    @Override
    public Type logic(Type other, Locatable l) {
        return this;
    }

    @Override
    public Type comparison(Type other, Locatable l) {
        return this;
    }

    @Override
    public Type arithmetic(Locatable l) {
        return this;
    }

    @Override
    public Type logic(Locatable l) {
        return this;
    }

    @Override
    public Type canBeCastTo(Type other, Locatable l) {
        return this;
    }

    @Override
    public Type squareBrackets(Type other, Locatable l) {
        return this;
    }

    @Override
    public Type dot(String fieldName, Locatable l) {
        return this;
    }

    @Override
    public Type parenthesis(List<Type> types, Locatable l) {
        return this;
    }

    @Override
    public void mustBeLogical(Locatable l) {
        // NO SE HACE NADA
    }

    @Override
    public void mustPromotesTo(Type t, Locatable l) {
        // NO SE HACE NADA
    }

    @Override
    public void mustBeBuiltIn(Locatable l) {
        // NO SE HACE NADA
    }
}
